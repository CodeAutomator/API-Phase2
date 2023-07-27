Feature: Positive Scenarios of User Module

@CreateUsers
Scenario Outline:
Given :User Post Request for the LMS API end point for user creation
When :User sends request body for creating user from excel "<SheetName>" and <RowNumber>
Then :User receives 201 Created Status with response message

Examples:
|SheetName|RowNumber|
|CreateUser|           0|
|CreateUser|           1|
|CreateUser|           2|



@GetUserByID
Scenario Outline:
Given :User create Get Request for the LMS API end point with valid userID
When :User sends request with valid user id to get response
Then :User receives 200 OK Status with response message

@GetUserByID
Scenario Outline:
Given :User create Get Request for the LMS API end point with valid userID
When :User sends request with valid user id to get response
Then :User receives 200 OK Status with response message


@GetAllStaff
Scenario Outline:
Given :User create Get Request for the LMS API end point to getallstaff
When :User sends request to get all staff
Then :User receives 200 OK Status with response message

@GetUsersWithRoles
Scenario Outline:
Given :User create Get Request to the LMS API to retrieve users
When :User sends request to get all users with their roles
Then :User receives 200 OK Status with response message


@PutUserById
Scenario Outline:
Given :User put request to update user data
When :User sends Put request body to update from excel "<SheetName>" and <RowNumber>
Then :User receives 200 OK Status with response message

Examples:
|SheetName|RowNumber|
|UpdateUser|       0|



@PutAssignUserProgramBatch
Scenario Outline:
Given :User put request to assign program and batch to user
When :User sends put request with body having programId and batchId and RoleId and UserId
Then :User receive 200 OK with message User has been assigned to Program and Batch

@PutUserRoleUpdate
Scenario Outline:
Given :User put request to update data for given userid
When :User sends Put request body having Roleid and RoleStatus and Userid
Then :User receives 200 OK Status with response message




#@DeleteUserByID
#Scenario Outline:
#Given :User delete request to delete the user
#When :User send delete request with userid
#Then :User receives 200 OK Status with response message










