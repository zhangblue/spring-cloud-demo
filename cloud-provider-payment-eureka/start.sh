#!/bin/bash

pid_file=monitor.pid

function start() {
  nohup java -jar cloud-provider-payment-1.0-SNAPSHOT.jar >/dev/null 2>&1 &
  if [[ $? -eq 0 ]]; then
    echo $! >${pid_file}
  else
    exit 1
  fi
}

function stop() {
  kill $(cat ${pid_file})

  if [[ $? -eq 0 ]]; then
    rm -f ${pid_file}
  else
    exit 1
  fi
}

function call() {
  case $1 in
  'start')
    start
    ;;
  'stop')
    stop
    ;;
  *) ;;
  esac
}

call "$1"
