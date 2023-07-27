package api.endpoints;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

import api.payload.AssignUserProgram;
import api.payload.UpdateUser;
import api.payload.User;
import api.payload.UserRole;
//created to perform CRUD requests to User module
public class UserEndPoints {
	public static Response createUser(String payload)
	{
		Response response= given()
				.contentType(ContentType.JSON) 
				.accept(ContentType.JSON)
				.body(payload)
				.auth().none()
			.when()
				.post(Routes.userpost_url);
				
		
		return response;
		
	}
	public static Response getUsers()
	{
		Response response=given()
					.when()
				.get(Routes.get_allusers_url);
		return response;
	}
	public static Response getUserByID(String userId)
	{
		Response response=given()
						.pathParam("userId",userId)
				.when()
				.get(Routes.get_byuserid_url);
		
		return response;
		
	}
	public static Response getUserWithRoles()
	{
		Response response=given()
					.when()
				.get(Routes.get_userwithroles_url);
		
		return response;
	}
	public static Response getAllStaff()
	{
		Response response=given()
					.when()
				.get(Routes.get_allstaff_url);
		
		return response;
	}
	public static Response putUser(String userId, UpdateUser payload)
	{
		Response response=given()
				.contentType(ContentType.JSON) 
				.accept(ContentType.JSON)
				.body(payload)
				.pathParam("userId",userId)
			.when()
			.put(Routes.put_url);
		
		return response;				
	}
	public static Response putUserRole(String userId, String payload)
	{
		Response response=given()
				.contentType(ContentType.JSON) 
				.accept(ContentType.JSON)
				.body(payload)
				.pathParam("userId",userId)
			.when()
			.put(Routes.put_userrole_url);
		
		return response;	
	}
	public static Response putAssignUserProgram(String userId,String payload)
	{
		Response response=given()
				.contentType(ContentType.JSON) 
				.accept(ContentType.JSON)
				.body(payload)
				.pathParam("userId",userId)
			.when()
			.put(Routes.put_assignuser_url);
		
		return response;
		
	}
	public static Response deleteUser(String userId)
	{
		Response response=given()
						.pathParam("userId",userId)
				.when()
				.delete(Routes.userdelete_url);
		
		return response;
		
	}
}
