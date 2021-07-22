#!/bin/bash

# assign parameters to variables
psql_host=$1
psql_port=$2
db_name=$3
psql_user=$4
psql_password=$5

# if not exactly 5 inputs
if [ $# -ne 5 ]; then
  echo "arguments required: psql_host, psql_port, db_name, psql_user, psql_password"
  echo "usage: ./scripts/host_info.sh psql_host psql_port db_name psql_user psql_password"
  exit 1
fi

# obtain hardware specifications data through CLI
hostname=$(hostname -f)
lscpu_out=$(lscpu)
cpu_number=$(echo "$lscpu_out" | egrep "^CPU\(s\):" | awk '{print $2}' | xargs)
cpu_architecture=$(echo "$lscpu_out" | egrep "^Architecture:" | awk '{print $2}' | xargs)
cpu_model=$(echo "$lscpu_out" | egrep "^Model name:" | awk '{$1="";$2="";print $0}' | xargs)
cpu_mhz=$(echo "$lscpu_out" | egrep "^CPU MHz:" | awk '{print $3}' | xargs)
l2_cache=$(echo "$lscpu_out" | egrep "^L2 cache:" | awk '{print substr($3, 1, length($3)-1)}' | xargs)
total_mem=$(free -k | head -n 2 | tail -n 1 | awk '{print $2}' | xargs)
timestamp=$(date --utc +"%Y-%m-%d %H:%M:%S")

# construct SQL INSERT statement
insert_stmt="INSERT INTO host_info (hostname, cpu_number, cpu_architecture, cpu_model, cpu_mhz, l2_cache, total_mem, timestamp)
VALUES ('$hostname', $cpu_number, '$cpu_architecture', '$cpu_model', $cpu_mhz, '$l2_cache', $total_mem, '$timestamp');"

# execute SQL INSERT statement
export PGPASSWORD=$psql_password
psql -h $psql_host -U $psql_user -d $db_name -p $psql_port -c "$insert_stmt"

exit $?
