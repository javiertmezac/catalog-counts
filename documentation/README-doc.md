# catalog-counts
catalog-counts

it seems we are missing 2 columns in CatalogCount table.
1- we should identified to which church the "entry" belongs to
2- who is using the application (user/profile Id)

# Saldo Anterior - (possible Table Name: MonthlyTotal)
At the end of each month we should have a "reference/value" representing the current total
after adding and subtracting all operations/movements.
This value should be considered at the end and beginning of each month.

The idea is to have another table containing following columns:
1- value (float/double)
2- registrationDate (datetime)
3- churchId (id) - this could be a foreignKey

This means, there should be a process behind updating this table at the end of the month.
the process should consider following scenario:
1- taking last month total
2- addition and subtraction of current month's movements/entries (CatalogCount Table)
3- inserting new value to MonthlyTotal Table
4- repeat the same for each registered church?


# Excel Import
Documentation

Whats the format excel spreadsheets should follow?

Note Columns are written in spanish.
 - Fecha (define format)
 - Cuenta (this is the catalog count enum)
 - Descripcion (this should correspond to the values set on the CatalogCount Table)
 - Cargo 
    - (if "cuenta" equals 1.x then Cargo column should have a value)
    - format should be <number>.<number>
 - Abono (if "cuenta" != 1.x then Abono column should have a value)
 - Saldo column should be the last column
 
 Specifications:
 - excel extension should be .xlsx
 - Columns should be in order as described above.
 - There should not be "empty rows" between months (if there is an empty row, 
    should be have a way to "interrupt" the import and let the user know about this error, 
    then resume from last successful "row"?) (NOTE: //todo: evaluate if "empty rows" validation can be done
    before import process starts. Take a look at com.jtmc.apps.reforma.service.excelimport.ExcelSheet for more details)
 - There should be only one row describing the columns name and it should start on cel/box "B2" (first row of the table)
 - "Saldo Anterior" row should always be the "second row"
 - Last row should be the "total row"
    - consider selecting all the rows and giving a table format

    
 # Excel import pending considerations
 ## importing "registros" per year.
 - Tab should be named as "Registros <year>" 
    - this means it should only contain all the related "info/incoming/expenses" to that year
    - this should be helpful to import data related to this year
    
    ### same excel file may be uploaded many times..
        - scenario #1: maybe first time a user uploads, it only sets latest year of data (eg. 2020)
        - scenario #1.1: same file has been "locally" updated with data from (eg.2019), then user uploads the excel file
         ( for this scenario how do we ensure consistency between excel and database?)
         - consider checksum of each multiple version, or uploading each "Registros <year>" as a separate file?
    
    
 Technical Specifications
 
 Upload Excel File
 - to start an import process, file should firstly have been uploaded to "storage cloud" (consider s3)
    - FileServiceAPI /file should be:
        - / (POST) single upload presing-url 
           - personProfileId (UUID)
           - file name (consider whole path) 
           - file checksum
        - / (PUT) complete singleUpload
            -  fileStorageKey
        - NOTE: MAYBE THIS SHOULD NOT BE EXPOSED / (GET) list uploaded files (return names)
            - query Param (personProfileId)
            
    - there should be a profile to link the upload (file linked to person profile, and person profile linked to church profile)

    
  Excel Imports
  - there should be an API to "start" import process
    - to start an import, we need to know which tab
    - post method with name of the file as json payload
    
    
    
 References
 - https://www.javatpoint.com/how-to-read-excel-file-in-java
