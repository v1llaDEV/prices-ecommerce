FROM openjdk:17
WORKDIR /app
COPY ./target/prices-ecommerce-1.0.0.jar /app
EXPOSE 8080
CMD ["java", "-jar", "prices-ecommerce-1.0.0.jar"]