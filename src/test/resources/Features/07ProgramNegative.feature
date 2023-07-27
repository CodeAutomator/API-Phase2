Feature: validating negative scenarios
   #Background:
     # Given user is getting information
       
   
      Scenario: POST student 400 status code
       When we send base url validating  post url
     
    Scenario: validating 404 status code
    When we send with invalid programId
   
    Scenario: PUT by programId validating 404 status code
     When we send put url By invalid ID
    Scenario: PUT by programId validating 400 status code
     When we send put url By invalid ID
   
     Scenario: PUT by programName validating 404 status code
     When we send put url BY invalid programName
    Scenario: PUT by programName validating 400 status code
     When we send put url Byinvalid programName
     
     Scenario: DELETE by programId validating 404 status code
     When we send DELETE By invalid ID
     
     
      Scenario: DELETE by programName validating 404 status code
     When we send url DELETE invalid Name
