## 📜 Summary

The target of this application is provide a service rest to get a list filtered of price information.

### Technology

- Springboot 3.5.0
- H2 database in memory
- Service REST
- Java 21

## 🚀 Getting started

The first step is compile the project using maven with next command:

mvn clean install -U

To start the application execute the next command:

mvn spring-boot:run

There will be available the endpoint to make requests in the next url:

http://localhost:8080/api/v1/prices

with next query params:

applicationDateTime - DateTime in ISO Date Time Format yyyy-MM-dd'T'HH:mm:ss.SSSXXX  
productId - String  
brandId - String

Example:

http://localhost:8080/api/v1/prices?applicationDateTime=2020-12-31T23:59:59Z&productId=1&brandId=1