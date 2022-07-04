# Catalog Counts Service Changelog

## 2.0.0-beta
release date: July 3, 2022

### Features
- Period API
- Period report creation and status
- Report creation considering systemDefault timezone for "from" and "to" Dates
  - add report roles names (description)

### Breaking Changes
- Added encoding on password

### Fix
- fix some General unit tests

### Documentation
- Update Documentation folder. add Insomnia collection
- add Quarterly Report | Brainstorming

## 1.1.1
release date: June 14, 2022

### Breaking Changes
- updated DB to include confirmedBy as CompositeKey
    - period_details compositeKey branch, period, confirmed
    - report FCK branch, period, confirmed
- ran myBatis Generator to update PeriodDetails and Report related DAOs

## 1.1.0
release date: June 10, 2022

### Features
- ++ 1.1.0-alpha version
- added GET method on ConfirmPeriodApi
- added BranchApi
- change table structure on report and period_details
    - composite key on period_details (branch and period)
    - composite fk on report (branch and period)
    - updated data objects

### Improvements
- modified existing PersonaApi to adjust new requirements
- display date when logging. previous was just date

## 1.1.0-alpha
release date: June 6, 2022

### What's Changed
* Feature/logger log trail by @javiertmezac in https://github.com/javiertmezac/catalog-counts/pull/46
* Develop by @javiertmezac in https://github.com/javiertmezac/catalog-counts/pull/47
* Feature/confirmation alert by @javiertmezac in https://github.com/javiertmezac/catalog-counts/pull/49
* improve audit report logic  by @javiertmezac in https://github.com/javiertmezac/catalog-counts/pull/48
* PeriodConfirm API by @javiertmezac in https://github.com/javiertmezac/catalog-counts/pull/53

**Full Changelog**: https://github.com/javiertmezac/catalog-counts/compare/1.0.0...1.1.0-alpha

## 1.0.0
release date: May 9, 2022

### What's Changed
* Feature/login api by @javiertmezac in https://github.com/javiertmezac/catalog-counts/pull/35
* Feature/refactor tables by @javiertmezac in https://github.com/javiertmezac/catalog-counts/pull/37
* Feature/refactor by @javiertmezac in https://github.com/javiertmezac/catalog-counts/pull/38
* Feature/get user data by @javiertmezac in https://github.com/javiertmezac/catalog-counts/pull/39
* update catalog-count endpoint by @javiertmezac in https://github.com/javiertmezac/catalog-counts/pull/43
* Develop by @javiertmezac in https://github.com/javiertmezac/catalog-counts/pull/44

## 0.5.1
release date: July 30, 2021

### Features
- Added CatalogCountEnum API - Get All

### Internal changes
- Refactored CatalogCountEnum Repository

### Dependencies
- bump commons-beanutils to 1.9.4

## 0.4.1
release date: July 12, 2021

### Internal changes
- changed catalog_count registrationDate column to datetime
- Refactored Service domain

### Fixes
- AttendanceList: return all list of personas even attendance list exist.

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
