
# Reporte Trimestral del Diezmo

## Features
 - There should be a page to display following information
 
   Information about church and "tesorero"
   - Branch Name: eg (Reforma)
   - Branch Details: eg (address, city)
   - Tesorero Details: eg (name, phone number, email-address)
   
   Report description
   - each month : name
     - row displaying: each week of the month
     - row displaing: each week amount (diezmo)
       - column at the end: display total = Sum(all weeks)
       
    Display status of the deposit: (available, delayed, done)
     - available since: date
     - delayed: how many weeks have passed?
     - done: date
     
     Tithe total (diezmo) = sum(3 months total)
     Tithe 10% to be deposited
     
     
## Implementation Details
 - is the report going to be created automatically?
    - how? As part of the 1st iteration there could be a button to trigger the action.
      - the code should validate dates and create missing reports if applicable.
    - Consider the following
      - Q1 = Jan, Feb, March
        Jan 1st should triggered Q1.Year-1 report creation
      - Q2 = Apr, May, Jun
        Apr 1st should triggered Q1 report creation
      - Q3 = Jul, Aug, Sept
        Jul 1st should triggered Q2 report creation
      - Q4 = Oct, Nov, Dec
        Oct 1st should triggered Q3 report creation
 - data should be returned from database
  - EG 
    - getTotalPerMonth 
    `select *, sum(amount) as totalPerMonth from catalog_count where registrationDate >= date('2020-03-01') and registrationDate <= date('2020-10-1') and catalogCountEnumId = 8 group By Month(registrationDate);`
    - getMonthWeeks
 - Maybe reports should be "stored" or mark as already generated
  - sql-statement: string
  - status: (string [available, delayed, done])
  - creation date: dateTime
  - paymentDate: dateTime (null)
  - linkToEvidence: String (evidence should be a picture)
  > should this "deposit" be validated by someone?
  
 ### Pseudo-code
 Report 
