@tag
@BatchModulesNegative
Feature: Batch Negative Module CRUD operations

@PostbatchcreateNegative
Scenario Outline:
	When : Post in batch by excel "<SheetName>" and <RowNumber>
	Then : Status 400 Badrequest.
	
	Examples:
	 | SheetName       | RowNumber |
    | BatchNegative   |          0|
	
@getbatchbyidNegative
Scenario Outline:
When : get request for batch <id>
Then : Response body status is verified.

Examples:
|id|
|6754|

@getbatchbynameNegative
Scenario Outline:
When : get request for batch by "<name>"
Then : Response body status is verified.

Examples:
|name|
|Jul23-Api|

@getbatchbyprogramidNegative
Scenario Outline:
When : get request for batch by program <id>
Then : Response body status is verified.

Examples:
|id|
|999|

@putbatchNegative
Scenario Outline:
When : Put request for batch by excel in "<SheetName>" and <RowNumber>
Then : Batch didnot get updated 

   Examples:
    | SheetName | RowNumber |
    |PutBatchNegative  | 		0|
    
@deletebatchbyid
Scenario Outline:
When : delete request for batch <id>
Then : batch id didnot get deleted by 404 status code

Examples:
|id|
|6778|
