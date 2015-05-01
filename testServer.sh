#!/bin/sh

### 1. It generates the traffic 
### 2. list out the total time at client side


server=localhost
port=9090

date1=$(date +"%s")
for i in `seq 1 10000`
do
    telnet ${server} ${port}
done
date2=$(date +"%s")

diff=$(($date2-$date1))

echo "diff = ${diff}"
echo "$(($diff / 60)) minutes and $(($diff % 60)) seconds elapsed."
