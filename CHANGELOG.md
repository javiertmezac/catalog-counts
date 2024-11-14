# Catalog Counts Service Changelog

## 3.0.0
release date: Nov 13, 2024

### Improvements
- update java 8 to java 21. ( fix imports, dependencies, etc)

### Infrastructure
- change deployment to Digital Ocean (so far nov 2024, manual deployment)
- de-activated ECS Deployment and ECS Service Desire Count github workflows on main branch

## 2.4.0
release date: Oct 13, 2024

### Features
- change initial-amount POST action to it's own api endpoint
- add timezoneId and status to branch request
  - this will allow basic branch/account setup
- Persona API to allow CRUD operations

## 2.3.3
release date: Jul 7, 2024

### Features
- Improve Default Report to include SumExpensesDetails.

### Breaking Changes
- Stored Procedure `V0.0.17__sp_default_report_by_cce_identifier.sql` to extend sum expenses with details (catalog_counts)

## 2.3.2
release date: May 30, 2024

### Features
- improve CC insert and update: now it considers timezones to verify still able to upsert
- CC insert and update: validate period not confirmed
- JWT login
  - add expiration time (default to CC_SERVICE_DEFAULT_EXPIRATION_SECS env var)
  - set uid as claim
  - improve userimpl to fetch persona based on uid claim

## 2.3.1
release date: May 27, 2023
- validate range date on default report create
 
## 2.3.0
release date: May 20, 2024

### Features
- improve "default" report type
  - consider timezones when generating report
 
### Breaking Changes
- Stored Procedure `V0.0.14__timezone_table.sql` to store timezones
- Stored Procedure `V0.0.15__branch_timezone_aware.sql` to alter branch table and add timezone column
- Stored Procedure `V0.0.16__sp_default_report_income_expenses.sql` get incomes or expenses considering branch timezone

## 2.2.3
release date: Apr 25, 2024

### Features
- multiple "branches/accounts" supported for the same user

### Improvements
- Fetch Catalog Count list cumulative sum by branch and cc editable as Stored Procedure
  - Logic has been replaced to use Stored Procedure

### Breaking Changes
- Stored Procedure `V0.0.13__sp_cclist_cumulativesum_editable.sql` to fetch catalog count list

## 2.2.1
release date: Mar 30, 2024

### Features
- Add Branch Initial Amount
- update insomnia collection
- add github workflow to deploy ECS fargate (cc-service)
- add API to post branch initial amount

### Improvements
- Excel import : reads "comments" column

## 2.1.0.2
release date:  Mar 20, 2024

### Comments
- No official release
- add 4.5 "Ahorro para Conferencias" - Catalog Count
- modify CatalogCountEnumRepository to select AllRowsOrderBy (cc.identifier)

## 2.1.0.1
release date:  - 

### Comments
- No official release
- Added ecs-service-desire-count.yml github action to update ECS service - based on cron schedule

## 2.1.0
release date: Apr 9, 2023

### Features
- Now supports initial amount to be configured. Flow is the same as registering a CatalogCount, only difference is the EnumId.
  - As a note, it is important to register the Initial Amount with a date previous to the month Movements will start. ie. Movements start on Feb, initial amount should be set in Jan.

### Breaking Changes
- add V0.0.11, requires flyway migration to be run in DB


## 2.0.2-beta
release date: July 7, 2022

### HOTFIX
- extend confirmation date til 10


## 2.0.1-beta
release date: July 3, 2022

### HOTFIX
- add branchId to calculate report incomes and expenses

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
