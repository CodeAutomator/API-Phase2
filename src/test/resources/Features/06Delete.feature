
Feature: Assignment Module Scenarios
 
	@1Delassignsub
 	Scenario Outline: delete request for deleting the id 
 	Given : "del" Request to "delete" the data 
 	When :  delete the  submission by using submission <id> request
 	Then : user recieves the list of data which can be validated.
 	
 	Examples:
 	|id|
 	|0|
	
	
	@2DeleteDataByAssignmentIdP
	 Scenario: User is trying to delete an assignment
	 	Given User creates DELETE Request for the LMS API endpoint 
    When User calls the payload API with delete request by assignmentId
    Then Assignment gets deleted  
    
    @3DeleteUserByID
Scenario Outline:
Given :User delete request to delete the user
When :User send delete request with userid
Then :User receives 200 OK Status with response message
    
  
 @4deletebatchbyid
Scenario Outline:
When : delete request for batch <id>
Then : batch id data gets deleted

Examples:
|id|
|6788|

 @5DELETEBYID
     Scenario: DELETE by programId
     When we send DELETE ByID
     Then validating DELETE BY ID status codes
     @6DELETEBYNAME      
    Scenario: DELETE by programName
     When we send url DELETE Name
     Then validating DELTE BY NAME status codes