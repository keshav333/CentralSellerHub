FROM openjdk:8-jdk-alpine
VOLUME /tmp
ADD target/csp-mysql.war csp-mysql.war
EXPOSE 9090
ENTRYPOINT ["java","-jar","/csp-mysql.war"]
