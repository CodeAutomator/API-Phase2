Feature: Assignment submission Module 

Background : User sets Authorization to No Auth.
@assign
Scenario Outline:
	Given : "post" Request to "create" the data 
	When : User sends request Body from excel "<SheetName>" and <RowNumber>
	Then : :User receives 201 Created Status with response body.
 	
	Examples:
	
	|SheetName|RowNumber|
	|postassign	|				0	|


@getalldatainsubmission
Scenario: get all data
 	Given : "get" Request to "retrieve" the data  
 	When : User sends get request 
 	Then : user recieves the list of data which can be validated.
 @getbyassignmentid	
 	Scenario Outline: get by id
 	Given : "get" Request to "retrieve" the data 
 	When : data is retrieved using <id> by get request
 	Then : user recieves the list of data which can be validated.
 	
 	Examples:
 	|id|
	|0|
		@Putgradeassignment
 	Scenario Outline: update assginment 
 	Given : "put" Request to "update" the data
 	When : User sends request Body from excel "<SheetName>" and <RowNumber>
 Then : user recieves the list of data which can be validated.
 	
 	Examples:
 	|SheetName|RowNumber|
 	|putgrade	|				 0|
 	
	
	@getbystudentid
	Scenario Outline: get grades
	Given : "get" Request to "retrieve" the data 
 	When : grade is retrieved using "<id>" by get request
 	Then : user recieves the list of data which can be validated.
 	
 	Examples:
 	|id|
 	|U0|
 	
 	@getbybatchid
 	Scenario Outline: get grades by batch id
 	Given : "get" Request to "retrieve" the data 
 	When : grade is retrieved using batch <id> by get request
 	Then : user recieves the list of data which can be validated.
 	
 	Examples:
 	|id|
 	|0|
 	
 	@getsubmissionbyuserid
 		Scenario Outline: get submission by userid
 	Given : "get" Request to "retrieve" the data 
 	When :  get submission by using user "<id>" request
 	Then : user recieves the list of data which can be validated.
 	
 	Examples:
 	|id|
 	|0|
 	
 	@getSubbyBatchId
 	Scenario Outline:get submission by batch id
 	Given : "get" Request to "retrieve" the data 
 	When :  get submission by using batch <id> request
 	Then : user recieves the list of data which can be validated.
 	
 	Examples:
 	|id|
 	|0|
 	
 	@Putresubmitassign
 	Scenario Outline: resubmit assignment with update request
 	Given : "put" Request to "update" the data
 When : User sends request Body from excel "<SheetName>" and <RowNumber>
 Then : user recieves the list of data which can be validated.
 	    
	
 	
 	Examples:
 	|SheetName|RowNumber|
 	|put			|				 0|
 	
 #	@Putgradeassignment
 #	Scenario Outline: update assginment 
 #	Given : "put" Request to "update" the data
 #	When : User sends request Body from excel "<SheetName>" and <RowNumber>
 #Then : user recieves the list of data which can be validated.
 #	
 #	Examples:
 #	|SheetName|RowNumber|
 #	|putgrade	|				 0|
 #	
 #	@Delassignsub
 #	Scenario Outline: delete request for deleting the id 
 #	Given : "del" Request to "delete" the data 
 #	When :  delete the  submission by using submission <id> request
 #	Then : user recieves the list of data which can be validated.
 #	
 #	Examples:
 #	|id|
 #	|1158|
 	
 	