FROM amazoncorretto:8-alpine-jdk
MAINTAINER teretorres

COPY target/TereTorres-0.0.1-SNAPSHOT.jar TereTorres-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java","-jar","/TereTorres-0.0.1-SNAPSHOT.jar"]
