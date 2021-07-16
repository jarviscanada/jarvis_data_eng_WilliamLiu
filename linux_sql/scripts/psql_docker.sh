#!/bin/bash

# assign parameters to variables
cmd=$1
db_username=$2
db_password=$3

# start docker if docker server is not running
sudo systemctl status docker || systemctl start docker

# check if jrvs-psql container exists
psql_container_count=$(docker container ls -a -f name=jrvs-psql | wc -l)

# switch case based on input command
case $cmd in
create)
  # if jrvs-psql container exists
  if [ $psql_container_count -eq 2 ]; then
    echo "jrvs-psql container already exists"
    exit 1
  fi

  # if not exactly 3 inputs
  if [ $# -ne 3 ]; then
    echo "arguments required: cmd, db_username, db_password"
    exit 1
  fi

  # create new volume
  docker volume create pgdata
  # create container from jrvs-psql image
  docker run --name jrvs-psql -e POSTGRES_PASSWORD=${db_password} -e POSTGRES_USER=${db_username} -d -v pgdata:/var/lib/postgresql/data -p 5432:5432 postgres

  exit $?
  ;;
start | stop)
  # if jrvs-psql container does not exist
  if [ $psql_container_count -ne 2 ]; then
    echo "jrvs-psql container does not exist"
    exit 1
  fi

  # start|stop jrvs-psql container
  docker container $cmd jrvs-psql

  exit $?
  ;;
*)
  echo "invalid cmd"
  echo "usage: ./scripts/psql_docker.sh start|stop|create [db_username][db_password]"

  exit 1
  ;;
esac
