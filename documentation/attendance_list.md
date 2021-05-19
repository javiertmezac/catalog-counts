
# Attendance List

## Background
The idea is to keep a record of the attendance of the church members.

1st iteration - Consider only Sundays

## What would be the User experience?
- list of names with a checkbox (checked = true = attended)
  - this list should be fetched from DB
  - structure to store in DB
    - attendance table
###  - from frontend keep data in a json format, store until (save) button is clicked
    
### - backend
  - endpoint to manage attendance
    - Get /api/attendance/{id}
    - Put /api/attendance/{id} or /api/attendance (maybe this will be a post and a patch)
      - request
        list<persona>
      - response
        idAttendance
        list<persona>
  - DB
    - persona
      - id: PK
      - name
      - lastname 
    - attendance
      - id : PK
      - idPersona: FK
      - attended: boolean
      - date: dateTime

- ability to add a new "name - new member"
  - how to store this new name?
