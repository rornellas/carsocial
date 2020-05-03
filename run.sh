#!/bin/sh

echo "********************************************************"
echo "Starting app"
echo "********************************************************"

java -Dserver.port=$SERVER_PORT -jar /usr/local/service-app/service-0.0.1-SNAPSHOT.jar