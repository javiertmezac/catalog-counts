# catalog-counts
catalog-counts

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
 - Salgo column should be the last column
 
 Specifications:
 - excel extension should be .xlsx
 - Columns should be in order as described above.
 - There should not be "empty rows" between months (if there is an empty row, should be have a way to "interrupt" the import and let the user know about this error, then resume from last successful "row"?)
 - Tab should be named as "Registros" 
 - There should be only one row describing the columns name and it should start on cel/box "B2"
 - Last row should be the "total row"
    - consider selecting all the rows and giving a table format
 - "Saldo Anterior" row should always be the "second row"
    - Consider the possibility of importing "registros" per year.
    
    
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
    - post method with name of the file as json payload
    
    
    
 References
 - https://www.javatpoint.com/how-to-read-excel-file-in-java
