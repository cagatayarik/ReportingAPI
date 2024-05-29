# Financial House Reporting API

## Technologies
- Java
- Spring Boot
- Maven
- RestTemplate

## Prerequisites
- Java 20 should be installed
- Maven is required to build the project and manage dependencies.

## Installation
Start by cloning the project from Github;

```
git clone https://github.com/cagatayarik/ReportingAPI.git

cd reporting-api
```

To download dependencies and build the project, run:
```
mvn clean install
```
To run the application
```
mvn spring-boot:run
```

This API provides the following endpoints:
- Merchant Login: http://localhost:8080/api/v3/merchant/user/login
- Get Transaction Report: http://localhost:8080/api/v3/transactions/report
- Query Transaction List: http://localhost:8080/api/v3/transaction/list
- Get Transaction: http://localhost:8080/api/v3/transaction
- Retrieve Client Information: http://localhost:8080/api/v3/client


### Heroku URL: https://reporting-api-747b22413209.herokuapp.com




## I would implement if I had more time and documentation:
- I would like to write more comprehensive tests to increase the reliability of the application.
- I would like to strengthen the security architecture of the application by implementing Spring Security.
- I would aim to make the application more modular, which would simplify maintenance and management.
- I would also like to develop the front end further.
