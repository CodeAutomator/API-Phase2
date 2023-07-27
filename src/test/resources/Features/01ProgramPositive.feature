Feature: Program student information

   Background:
      Given user is getting information
       
   @GETALL
   Scenario: GET student information
    Given user is getting information
    When we send base url
    Then validating status codes
   
     @POST1
    Scenario: POST student information
   
    When we send base ith post url
    Then validating first post status codes
   
    @GETBYID
    Scenario: Get by programId
    When we send with programId
    Then validating GET BY Idstatus codes
   
    @PUTBYID
    Scenario: PUT by programId
     When we send put url ByID
    Then validating PUT BY IDstatus codes
   
    @PUTBYPROGRAMNAME
    Scenario: PUT by programName
     When we send put url By Name
    Then validating PUT BY Name status codes
     
     #@DELETEBYID
     #Scenario: DELETE by programId
     #When we send DELETE ByID
     #Then validating DELETE BY ID status codes
     
     @POST2
     Scenario: second POST student information
     When we sendsecond base  post url
     Then validating Second POST BYID status check
     
     #@DELETEBYNAME      
    #Scenario: DELETE by programName
     #When we send url DELETE Name
     #Then validating DELTE BY NAME status codes
