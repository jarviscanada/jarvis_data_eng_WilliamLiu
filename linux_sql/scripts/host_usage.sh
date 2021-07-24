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
  echo "usage: ./scripts/host_usage.sh psql_host psql_port db_name psql_user psql_password"
  exit 1
fi

# obtain Linux resource usage data through CLI
timestamp=$(date --utc +"%Y-%m-%d %H:%M:%S")
memory_free=$(vmstat -t --unit M | tail -n 1 | awk '{print $4}' | xargs)
cpu_idle=$(vmstat -t --unit M | tail -n 1 | awk '{print $15}' | xargs)
cpu_kernel=$(vmstat -t --unit M | tail -n 1 | awk '{print $14}' | xargs)
disk_io=$(vmstat -d | tail -n 1 | awk '{print $10}')
disk_available=$(df -BM / | tail -n 1 | awk '{print substr($4, 1, length($4)-1)}')

# construct SQL INSERT statement
hostname=$(hostname -f)
insert_stmt="INSERT INTO host_usage (timestamp, host_id, memory_free, cpu_idle, cpu_kernel, disk_io, disk_available)
VALUES ('$timestamp', (SELECT id FROM host_info WHERE hostname='$hostname'), $memory_free, $cpu_idle, $cpu_kernel, $disk_io, $disk_available);"

# execute SQL INSERT statement
export PGPASSWORD=$psql_password
psql -h $psql_host -U $psql_user -d $db_name -p $psql_port -c "$insert_stmt"

exit $?
