#!/usr/bin/env bash

cd /data/Rx

git pull
echo "拉取代码完成"

/data/Rx/gradlew product:buildNeeded -x test

ps -ef|grep product-1.0.jar | awk '{print $2}'| xargs kill -9
echo "删除原进程完成"

echo "运行"
\cp -rf /data/Rx/home/build/libs/product-1.0.jar .
nohup java -jar -Xmx512m product-1.0.jar --spring.profiles.active=dev &
