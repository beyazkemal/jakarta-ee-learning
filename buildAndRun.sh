#!/bin/sh
mvn clean package && docker build -t com.airhacks/learning .
docker rm -f learning || true && docker run -d -p 8080:8080 -p 4848:4848 --name learning com.airhacks/learning 
