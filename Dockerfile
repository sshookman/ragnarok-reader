FROM seanshookman/ubuntu-jdk-gradle:latest
MAINTAINER Sean Shookmans <SMS112788@gmail.com>

WORKDIR /app
ADD . /app

RUN ["gradle", "clean", "build"]
CMD ["java", "-jar", "build/libs/ragnarok-reader-all.jar"]
