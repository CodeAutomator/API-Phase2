@tag
Feature: Assignment Module Scenarios
 
  
@1CreateDataP
	 Scenario: User is trying to create an assignment
	 Given User creates POST Request for the LMS API endpoint
	 When User sends request Body from excel 
	 Then User receives created Status with response body
	 
	 @2GetAllDataP
  Scenario: User is trying to extract all data of assignments
  	Given User creates GET Request for the LMS API endpoint 
    When User calls the payload API with get request
    Then User gets data of all assignments in response
       
   @3GetDataByAssignmentIdP
 	 Scenario: User is trying to extract data by assignment id
 	  Given User creates GET Request for the LMS API endpoint 
    When User calls the payload API with get request by assignmentId
    Then User gets data by assignment id in response

 	@4GetDataByBatchIdP
  Scenario: User is trying to extract data by batch id
   	 Given User creates GET Request for the LMS API endpoint 
    When User calls the payload API with get request by batchId
    Then User gets data by batch id in response
    
     @5UpdateDataByAssignmentIdP
	Scenario: User is trying to update an assignment
		Given User creates PUT Request for the LMS API endpoint
    When User calls the payload API with put request by assignmentId
    Then Assignment gets updated
    
       #@16DeleteDataByAssignmentIdP
#	 Scenario: User is trying to delete an assignment
#	 	Given User creates DELETE Request for the LMS API endpoint 
    #When User calls the payload API with delete request by assignmentId
    #Then Assignment gets deleted  