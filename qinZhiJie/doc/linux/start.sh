#!/bin/sh
APP=qinzhijie-0.0.1-0.0.1

APP_NAME=${APP}".jar"
command=$1

function start()
{

  rm -f tpid

  nohup java -jar ${APP_NAME} > /dev/null 2>&1 &

  echo $! > tpid

  echo "${APP_NAME} start Success.... "
  
  check


}

function stop()
{

  tpid=`ps -ef|grep $APP_NAME|grep -v grep|grep -v kill|awk '{print $2}'`
  if [ ${tpid} ]; then
     echo "${APP_NAME} Stop Process... pid=${tpid}"
     kill -15 $tpid
   fi

   sleep 5
   tpid=`ps -ef|grep $APP_NAME|grep -v grep|grep -v kill|awk '{print $2}'`

   if [ ${tpid} ]; then
      echo "${APP_NAME} Kill Process... pid=${tpid}"
      kill -9 $tpid
    else
      echo "${APP_NAME} Stop Success..."
    fi
}

function check()
{
   tpid=`ps -ef|grep $APP_NAME|grep -v grep|grep -v kill|awk '{print $2}'`
   if [ ${tpid} ]; then
       echo "${APP_NAME} is running... pid=${tpid}"
   else
       echo "${APP_NAME} is NOT running..."
   fi

}

function restart()
{
	stop
	start
}

function forcekill()
{
  tpid=`ps -ef|grep $APP_NAME|grep -v grep|grep -v kill|awk '{print $2}'`

  if [ ${tpid} ]; then
     echo "${APP_NAME} Kill Process... pid=${tpid}"
     kill -9 $tpid

  fi

}

if [ "${command}" ==  "start" ]; then
    start

elif [ "${command}" ==  "stop" ]; then
     stop

elif [ "${command}" ==  "check" ]; then
     check

elif [ "${command}" ==  "kill" ]; then
     forcekill
	 
elif [ "${command}" ==  "restart" ]; then
     restart	 
else
    echo "请输入对应操作:  start / stop / restart / check / kill...."
fi