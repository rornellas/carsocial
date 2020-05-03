FROM openjdk:8-jre-alpine

RUN apk add --update bash && rm -rf /var/cache/apk/*

USER root
RUN  apk update && apk upgrade && apk add netcat-openbsd
RUN mkdir -p /usr/local/service
ADD build/libs/service-0.0.1-SNAPSHOT.jar /usr/local/service-app/service-0.0.1-SNAPSHOT.jar

ADD ./run.sh /root/
RUN chmod +x /root/run.sh
RUN ls -ltr /usr/local/service-app
RUN ls -ltr /root
CMD sh /root/run.sh