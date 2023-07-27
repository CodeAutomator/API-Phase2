
Feature: Assignment submission Module for negative scenario
Background : User sets Authorization to No Auth.
@assignneg
Scenario Outline:
	Given : "post" Request to "create" the data for negative scenario
	When : payload by excel "<SheetName>" and <RowNumber>
	Then : user recieves the list of data which can be validated for negative scenario.
 	
	Examples:
	|SheetName|RowNumber|
	|negpost	|				0	|



 @assignmentidget	
 	Scenario Outline: get by id
 	Given : "get" Request to "retrieve" the data for negative scenario
 	When : data is retrieved using <id>  get request
 	Then : user recieves the list of data which can be validated for negative scenario.
 	
 	Examples:
 	|id|
	|1000|
	
	@useridgetnegative
	Scenario Outline: get grades
	Given : "get" Request to "retrieve" the data for negative scenario
 	When : user data from get request by "<id>" 
 	Then : user recieves the list of data which can be validated for negative scenario.
 	
 	Examples:
 	|id|
 	|U1000|
 	
 	@batchidbyget
 	Scenario Outline: get grades by batch id
 	Given : "get" Request to "retrieve" the data for negative scenario
 	When : grade using batch <id> by get request
 Then : user recieves the list of data which can be validated for negative scenario.
 	
 	
 	Examples:
 	|id|
 	|1212|
 	
 	@submissionbyuserid
 		Scenario Outline: get submission by userid
 	Given : "get" Request to "retrieve" the data for negative scenario
 	When :  submission by using user "<id>" with get request
 	Then : user recieves the list of data which can be validated for negative scenario.
 	
 	
 	Examples:
 	|id|
 	|U4344|
 	
 	@SubBatchIdneg
 	Scenario Outline:get submission by batch id
 	Given : "get" Request to "retrieve" the data for negative scenario
 	When :  submission by using batch <id> request
 	Then : user recieves the list of data which can be validated for negative scenario.
 	
 	
 	Examples:
 	|id|
 	|1057|
 	
 	@Putresubmitassignneg
 	Scenario Outline: resubmit assignment with update request
 	Given : "put" Request to "update" the data for negative scenario
	When : payload by excel "<SheetName>" and <RowNumber>
 Then : user recieves the list of data which can be validated for negative scenario.	
 	
 	Examples:
 	|SheetName|RowNumber|
 	|Negputscenario|				 0|
 	
 	@Putgradeassignmentval
 	Scenario Outline: update assginment 
 	Given : "put" Request to "update" the data for negative scenario
 		When : payload by excel "<SheetName>" and <RowNumber>
	Then : user recieves the list of data which can be validated for negative scenario.
 	
 	
 	Examples:
 	|SheetName					 |RowNumber|
 	|Negputscenariograde |				 0|
 	
 	@Delassignsubneg
 	Scenario Outline: delete request for deleting the id 
 	Given : "del" Request to "delete" the data for negative scenario 
 	When :  submission by using submission <id> with delete request
 	Then : user recieves the list of data which can be validated for negative scenario.
 	
 	
 	Examples:
 	|id|
 	|1111|