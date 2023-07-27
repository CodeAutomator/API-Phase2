Feature:Negative Scenario for User module

@CreatedataWithInvaliddata
Scenario Outline:
Given :User creates Post Request to the LMS API end point
When :User sends request body for creating user from excel "<SheetName>" and <RowNumber>
Then :User receives 400 Bad Request Status with message

Examples:
|SheetName|RowNumber|
|NegativeCreateUser|           0|


@CreatedataWithMissingData
Scenario Outline:
Given :User creates Post Request to the LMS API end point
When :User sends request body for creating user from excel "<SheetName>" and <RowNumber>
Then :User receives 400 Bad Request Status with message

Examples:
|SheetName|RowNumber|
|NegativeCreateUser|           1|


@GetUserWithInValidID
Scenario Outline:
Given :User create Get Request for the LMS API end point with invalid userID
When :User sends request with invalid user id to get response
Then :User receives 404 Not Found message

@PutUserByInvalidId
Scenario Outline:
Given :User put request to update data with Invalid userID
When :User sends Put request body to update from excel "<SheetName>" and <RowNumber>
Then :User receives 404 Not Found message

Examples:
|SheetName     |RowNumber|
|NegativeCreateUser|    2|

@PutUserWithMissingData
Scenario Outline:
Given :User put request to update data with missing mandatory fields
When :User sends Put request body to update from excel "<SheetName>" and <RowNumber>
Then :User receives 400 Bad Request Status with message  

Examples:
|SheetName     |RowNumber|
|NegativeCreateUser|    1|


@PutRoleUpdateInvalidId
Scenario Outline:
Given :User put request to update data with Invalid userID
When :User sends Put request body having Roleid and RoleStatus and Invalid Userid
Then :User receives 404 Not Found message


@PutRoleUpdateWithMissingData
Scenario Outline:
Given :User put request to update data with missing mandatory fields
When :User sends Put request body having Roleid and Userid
Then :User receives 400 Bad Request Status with message

@PutAssignUserProgramwithInvalidID
Scenario Outline:
Given :User put request to assign program and batch to user with invalid ID
When :User sends put request with body having programId and batchId and RoleId and  Invalid UserId
Then :User receives 404 Not Found message

@PutAssignUserProgramwithoutRoleID
Scenario Outline:
Given :User put request to assign program and batch with user ID
When :User sends put request with body having programId and batchId and UserId
Then :User receives 400 Bad Request Status with message

@DeleteUserByInvalidID
Scenario Outline:
Given :User delete request to delete the user invalid UserId
When :User send delete request with  invalid userid
Then :User receives 404 Not Found message userid doesnot exist

