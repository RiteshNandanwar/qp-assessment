FROM openjdk:17-jdk-alpine
EXPOSE 8085
ADD target/dockergrocery-booking-app-0.0.1-SNAPSHOT.jar GroceryBookingApp-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/GroceryBookingApp-0.0.1-SNAPSHOT.jar"]