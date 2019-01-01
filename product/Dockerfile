FROM daocloud.io/library/java:8u111-jre-alpine
MAINTAINER Dwyane

ENTRYPOINT ["java","-Xmx1024m","-jar","/tmp/product-1.0.jar","--spring.profiles.active=${SPRING_PROFILES_ACTIVE}"]