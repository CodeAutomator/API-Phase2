@BatchModulesPositive
Feature: Batch Module CRUD operations

@Postbatchcreate
Scenario Outline:
	When : Post in batch by excel "<SheetName>" and <RowNumber>
	Then : Status 201 created.
	
	Examples:
	|SheetName|RowNumber|
	|Batch		|			 	0|
	
@getallbatch
Scenario:
When : get request for all batches
Then : Response body status is verified.

@getbatchbyid
Scenario Outline:
When : get request for batch <id>
Then : Response body status is verified.

Examples:
|id|
|6600|

@getbatchbyname
Scenario Outline:
When : get request for batch by "<name>"
Then : Response body status is verified.

Examples:
|name|
|Jul23-ApiTrekkers-SDET5-Team13-013|

@getbatchbyprogramid
Scenario Outline:
When : get request for batch by program <id>
Then : Response body status is verified.

Examples:
|id|
|13832|

@putbatch
Scenario Outline:
When : Put request for batch by excel in "<SheetName>" and <RowNumber>
Then : Response body for put status is verified.

   Examples:
    | SheetName | RowNumber |
    |PutBatch  | 		0|
    
#@deletebatchbyid
#Scenario Outline:
#When : delete request for batch <id>
#Then : batch id data gets deleted
#
#Examples:
#|id|
#|6778|
