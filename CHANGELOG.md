# Catalog Counts Service Changelog

## 0.4.0
release date: Jun 21, 2021

### Features
#### cc-service-api
- Catalog Count API
  - POST - request - added registrationDate as requested parameter (payload)
  - GET 
    - response - returned registrationDate in yyyy-MM-dd format
    - response - added Catalog Count Enum description _identifier - description_ format

### Internal changes
- Added CORS filter to allow internal requests from s3 
- changed .jar file name to be picked from docker build command

### Known Issues
- alb-target group does not take the ECS tasks ipv4 to be registered automatically

## 0.3.0
release date: Jun 14, 2021

### Features
#### cc-service-api
- added new Persona endpoint (POST http verb)

### Fixes
- validation to throw RuntimeException when MonthlyTotalMapper returns null

### Internal changes
- dockerized cc-service
  - included dockerfile to load environment variables
  - changed Module to load from env variables, not from properties
### Known Issues
- alb-target group does not take the ECS tasks ipv4 to be registered automatically

## 0.2.0
Release Date: Feb 28, 2021
## Feature
- Excel import (Beta version): This will allow users to "import existing data" into database
### Fixes
- Added Saldo Column to display correct "Total"
- Added Monthly_Total column

## 0.1.0
Release Date:  Sep 5, 2020
### Features
- CatalogCountAPI
- HealtheckAPI
- Basic Generic Exception Handler
- UnitTests
- Guice Configuration
