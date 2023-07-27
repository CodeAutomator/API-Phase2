package api.test;
import api.endpoints.AssignmentEndPoints;
import api.payload.AssignmentPayload;
import api.utilities.Loggerload;
import io.restassured.RestAssured;
import io.restassured.filter.log.LogDetail;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
//import io.restassured.response.ValidatableResponse;
import io.restassured.http.Header;

import org.hamcrest.core.IsNull;
import org.testng.Assert;
import com.github.javafaker.Faker;
import Global.GlobalVar;
import java.io.IOException;
public class AssignmentTests {
	static Faker faker = new Faker();	 
	Response response;
	ValidatableResponse vResponse;
	Response getresponse;
	Response afterupdateresponse;
	Response afterdelresponse;
	
	public static int actualcode;
	public static int assignmentId;
 
//	public void verifyStatus(int code) {
//		//Assert.assertEquals(response.getStatusCode(), code);	
//		//System.out.println(response.getCode())
//		Assert.assertEquals(response.contentType(),"application/json");
//		Assert.assertEquals(response.header("Content-Type"),"application/json");
//		response.headers().get("Transfer-Encoding").equals("chunked");
//		Header value=response.headers().get("Connection");
//		System.out.println("header connections : "+value);
//		//Assert.assertEquals(value,"Connection=keep-alive");
//		System.out.println("header connections done");
//		long time = response.getTime();
//		System.out.println("time is------"+time);
//		//Assert.assertEquals(time,200);
//		System.out.println("----------"+response.getSessionId()+"------");
//		System.out.println("------"+response.cookie(""));
//		response.then().log().ifValidationFails(LogDetail.METHOD);
//		response.then().log().ifValidationFails(LogDetail.BODY);
//		RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
//		// To log request and response header
//		RestAssured.enableLoggingOfRequestAndResponseIfValidationFails(LogDetail.HEADERS);
//	}
	
//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ POST @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@//	
	public void TestPostAssignment(String desc, String name, int batchId,
			String comments, String createdBy, String dueDate, 
			String graderId, String path1, String path2, 
			String path3, String path4, String path5) throws IOException{
		
		AssignmentPayload assignmentPayload=new AssignmentPayload();		
		assignmentPayload.setAssignmentName(name);
		assignmentPayload.setCreatedBy(createdBy);
		assignmentPayload.setGraderId(graderId);
		assignmentPayload.setBatchId(batchId);
		assignmentPayload.setDueDate(dueDate);
		assignmentPayload.setComments(comments);
		assignmentPayload.setAssignmentDescription(desc);
		assignmentPayload.setPathAttachment1(path1);
		assignmentPayload.setPathAttachment2(path2);
		assignmentPayload.setPathAttachment3(path3);
		assignmentPayload.setPathAttachment4(path4);
		assignmentPayload.setPathAttachment5(path5);
		Loggerload.info("*********************** Creating Assignment *************");
		response= AssignmentEndPoints.createUser(assignmentPayload);		
		System.out.println(response.asString());
		String rbody = response.asString();
		JsonPath jp = new JsonPath( rbody );
		if (response.statusCode()== 201){
			GlobalVar.assignmentId = jp.getInt("assignmentId");
			Loggerload.info("*********************** Assignment is Created ****************");
			Loggerload.info(response.asString());
			actualcode=201;		
		}
		else {
			actualcode = 400;
		}
		response.then().log().all();
		
//		vResponse= AssignmentEndPoints.createUser(assignmentPayload);		
//		System.out.println("response is : " + vResponse.extract().statusCode());
//		//String rbody = vResponse.asString();
//		//JsonPath jp = new JsonPath( rbody );
//		if (vResponse.extract().statusCode()== 201){
//			System.out.println("Object created !! Inside......");
//			GlobalVar.assignmentId = 
//					vResponse.extract().path("assignmentId");
//			System.out.println(GlobalVar.assignmentId);
//			Loggerload.info("*********************** Assignment is Created ****************");
//			Loggerload.info(vResponse.toString());
//			actualcode=201;		
//		}
//		else {
//			actualcode = 400;
//		}
//		vResponse.log().all();
//		
//		//responseV.body(null, null) then().log().all();
	}

	public void verify_post_status(int code){
		Assert.assertEquals(actualcode,code);
		if(code==201) {
		Assert.assertEquals(response.contentType(),"application/json");
		Assert.assertEquals(response.header("Content-Type"),"application/json");
		response.headers().get("Transfer-Encoding").equals("chunked");
//		Header value=response.headers().get("Connection");
//		Assert.assertEquals(value,"Connection=keep-alive");
//		long time = response.getTime();
//		System.out.println("time is------"+time);
//		Assert.assertEquals(time,200);
		response.then().log().ifValidationFails(LogDetail.METHOD);
		response.then().log().ifValidationFails(LogDetail.BODY);	
		RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
		// To log request and response header
		RestAssured.enableLoggingOfRequestAndResponseIfValidationFails(LogDetail.HEADERS);
		}
		Loggerload.info("*********************** status is been verified ****************");
	}
//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ GET @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@//
	public void TestGetAllAssignments() {
		Loggerload.info("*********************** Retrieving All Assignments *************");
		response= AssignmentEndPoints.readAllAssignments();
		Loggerload.info(response.toString());
		actualcode = response.getStatusCode();
		response.then().log().all();
	}
	
	public void TestGetAssignmentsByBatchId(int id) {
		Loggerload.info("*********************** Retrieving Assignment *************");
		response= AssignmentEndPoints.readAssignmentsByBatchId(id);
		Loggerload.info(response.toString());
		actualcode = response.getStatusCode();
		response.then().log().all();	}
	
	public void TestGetAssignmentByAssignmentId(int id){
		Loggerload.info("*********************** Retrieving Assignment *************");
		response= AssignmentEndPoints.readAssignmentByAssignmentId(id);
		Loggerload.info(response.toString());
		actualcode = response.getStatusCode();
		response.then().log().all();
	}

	public void verify_get_status(int code){
		Assert.assertEquals(actualcode, code);
		Loggerload.info("*********************** Assignment details are Displayed *************");
	}	

//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ UPDATE @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@//

	public void TestUpdateAssignment(int id, String desc, String name, int batchId,
			String comments, String createdBy, String dueDate, 
			String graderId, String path1, String path2, 
			String path3, String path4, String path5){
		
		AssignmentPayload assignmentPayload=new AssignmentPayload();
		
		assignmentPayload.setAssignmentName(name);
		assignmentPayload.setCreatedBy(createdBy);
		assignmentPayload.setGraderId(graderId);
		assignmentPayload.setBatchId(batchId);
		assignmentPayload.setDueDate(dueDate);
		assignmentPayload.setComments(comments);
		assignmentPayload.setAssignmentDescription(desc);
		assignmentPayload.setPathAttachment1(path1);
		assignmentPayload.setPathAttachment2(path2);
		assignmentPayload.setPathAttachment3(path3);
		assignmentPayload.setPathAttachment4(path4);
		assignmentPayload.setPathAttachment5(path5);
		Loggerload.info("*********************** Updating assignment *************");
		
		response= AssignmentEndPoints.updateAssignment(id, assignmentPayload);
		response.then().log().all();
		actualcode = response.getStatusCode();
		if(actualcode == 200) {
			//Assert.assertEquals(response.getStatusCode(), 200);
			Loggerload.info("*********************** Assignment details Updated ****************");
	
			Loggerload.info("*********************** Retrieving assignment Details after Update *************");
			afterupdateresponse= AssignmentEndPoints.readAssignmentByAssignmentId(id);
			Loggerload.info(afterupdateresponse.toString());
			afterupdateresponse.then().log().all();
		}
	}

	public void verify_update_status(int code)	{
		Assert.assertEquals(actualcode, code);	
		if(actualcode==200) {
			Loggerload.info("*********************** Assignment details Updated *************");
		}
	}


	//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ DELETE @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@//
	public void TestDeleteAssignment(int id) {
		Loggerload.info("*********************** Deleting Assignment *************");
		response= AssignmentEndPoints.deleteAssignment(id);
		Loggerload.info(response.toString());
	}
		
	public void verify_delete_status(int code) {
		Assert.assertEquals(actualcode, code);	
		if(actualcode==200) {		
			Loggerload.info("*********************** Deletion Successful *************");
		}
	}
}
