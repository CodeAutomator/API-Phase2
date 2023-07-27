package api.endpoints;
//have only CURD requests operations

import static io.restassured.RestAssured.given;

import api.payload.Submissionpayload;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class AssignSubEndPoints {
public static int id;
	
public static Response createAssignsub(Submissionpayload payload)
	{
		Response response=given().auth().none().log().all()
			.contentType(ContentType.JSON) 
			.accept(ContentType.JSON)
						.body(payload)//like in postman request payload
		.when()
		.post(Routes.post_urls);
		
		return response;
		
	}
	
	public static ValidatableResponse getAllAssignments()
	{
		ValidatableResponse response=given().auth().none()
				.when()
				.get(Routes.get_url).then()
				.assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("assignmentsubschema.json"));// post request url here 
		
		return response;
		
	}
	
	public static Response getGradesbyuserid(String studeid) {
		Response response=given().auth().none()
				.pathParam("studentID",studeid)
		.get(Routes.getgradesbyid_url);// post request url here 
		
		return response;
	}
	public static Response getAllAssignmentsbyID(int id)
	{
		Response response=given().auth().none()
				.pathParam("assignmentId",id)
		.get(Routes.getassignmentid_url);// post request url here 
		
		return response;
		
	}
	
	public static Response updateAssignSub(int id,Submissionpayload payload)
	{
		Response response=given()
			.contentType(ContentType.JSON)//in swagger document header and content type is present that is passed here 
			.accept(ContentType.JSON)
			.auth().none()
			.pathParam("Id",id)
			.body(payload)//like in postman request payload
		.when()
		.put(Routes.put_submission);// post request url here 
		
		return response;
		
	}
	public static Response updategradeSub(int id,Submissionpayload payload)
	{
		Response response=given()
			.contentType(ContentType.JSON)//in swagger document header and content type is present that is passed here 
			.accept(ContentType.JSON)
			.body(payload)
			.auth().none()
			.pathParam("submissionId",id)
			.body(payload)//like in postman request payload
		.when()
		.put(Routes.putgrades_subid);// post request url here 
		
		return response;
		
	}
	
	public static Response deleteAssignsub(int int1)
	{
		Response response=given().auth().none()
				.pathParam("Id",int1)
			
		.when()
		.delete(Routes.del_url);// post request url here 
		
		return response;
		
	}

	public static Response getGradesbybatchid(int batchid) {
		Response response=given().auth().none()
				.pathParam("batchID",batchid)
		.get(Routes.batchid_url);// post request url here 
		
		return response;
		
	}

	public static Response getGradesbysubUserid(String subuserid) {
		Response response=given().auth().none()
				.pathParam("userId",subuserid)
		.get(Routes.subuserid_url);// post request url here 
		
		return response;
	}

	public static Response getGradesbysubUserid(int batchid) {
		Response response=given().auth().none()
				.pathParam("batchId",batchid)
		.get(Routes.subbatch_id);// post request url here 
		
		return response;
		
	}
}
