FROM daocloud.io/library/java:8u111-jre-alpine
MAINTAINER Ryze

ENTRYPOINT ["java","-Xmx512m","-jar","/tmp/config-1.0.jar"," --spring.profiles.active=${SPRING_PROFILES_ACTIVE}"]