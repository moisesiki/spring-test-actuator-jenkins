FROM maven:3.8.6-openjdk-8
MAINTAINER Mouhoutassim BELLO (mouhoutassim.bello@rintio.com)

WORKDIR project
COPY . .
RUN mvn clean install
EXPOSE 8093
ENTRYPOINT java -jar target/TyActuator.jar
