#!/bin/bash

#********************************************************
#Created: 
#Author	: lj
#Last modified: 
#Description: 
#********************************************************


logpath=/web/servers/service/elasticsearch-7.10.2/customer/logs/`date +'%Y%m%d%H%M%S'`.log
echo $logpath

#***check command execute status method***
checkerror()
{
        if [ $? != 0 ]; then
                called_from=$(caller 0)
                echo "Executing command failed,check error at [$called_from]" | tee -a $logpath
                exit 1;
        fi
}
#*****************************************

#************get timestamp method*********
function getTimestamp()
{
        datetime=`date +'%Y%m%d%H%M%S'`
        seconds=`date -d "$datetime" +%s`
        milliseconds=$((seconds*1000+10#`date "+%N"`/1000000))
        echo "${milliseconds}"
}
#*****************************************

echo "Start execute ES forcemerge..." | tee -a $logpath
startTime1=$(getTimestamp)
echo `curl -X POST -u elastic:testDmall -s "http://10.10.10.10:9200/my_index/_forcemerge?max_num_segments=1&pretty"` | tee -a $logpath
checkerror
endTime1=$(getTimestamp)
echo "Execute fsd_goods_v1/_forcemerge consume :[" $((${endTime1}-${startTime1})) "]ms" | tee -a $logpath

echo "End execute ES forcemerge..." | tee -a $logpath
