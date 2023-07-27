package stepdefinitions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import api.endpoints.UserEndPoints;
import api.payload.User;
import api.payload.UserRole;
import api.test.UserTestcase;
import api.utilities.ExcelReader;
import api.utilities.PhoneNumberGeneration;
import Global.GlobalVar;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import api.payload.AssignUserProgram;
import api.payload.UpdateUser;
import api.payload.User;
import api.payload.UserBatchStatus;
import api.payload.UserRole;
import api.test.UserTestcase;
import api.utilities.ExcelReader;
import api.utilities.PhoneNumberGeneration;
import Global.GlobalVar;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
//import org.json.JSONObject;


import com.fasterxml.jackson.databind.ObjectMapper;

//import org.json.JSONArray;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
public class UserStepDefinition {
	private UserTestcase testcase= new UserTestcase();

	Response response;
	Response getresponse;
	GlobalVar sd;
	
	@Given(":User Post Request for the LMS API end point for user creation")
	public void user_post_request_for_the_lms_api_end_point_for_user_creation() {
	}
	@Given(":User create Get Request to get all users")
	public void user_create_get_request_to_get_all_users() {
	  
	}
	@Given(":User create Get Request for the LMS API end point with valid userID")
	public void user_create_get_request_for_the_lms_api_end_point_with_valid_user_id() {
	    
	}
	@Given(":User put request to update data for given userid")
	public void user_put_request_to_update_data_for_given_userid() {
	  
	}

	@Given(":User put request to assign program and batch to user")
	public void user_put_request_to_assign_program_and_batch_to_user() {
	   
	}
	
	@Given(":User delete request to delete the user")
	public void user_delete_request_to_delete_the_user() {
	   
	}
	
	@Given(":User create Get Request for the LMS API end point to getallstaff")
	public void user_create_get_request_for_the_lms_api_end_point_to_getallstaff() {
	    
	}

	@Given(":User create Get Request to the LMS API to retrieve users")
	public void user_create_get_request_to_the_lms_api_to_retrieve_users() {
	   
	}

	@Given(":User put request to update user data")
	public void user_put_request_to_update_user_data() {
	   
	}
	
	
/*--------------------------- Negative Scenarios Given ----------------------*/
	
	@Given(":User creates Post Request to the LMS API end point")
	public void user_creates_post_request_to_the_lms_api_end_point() {
		
	}
	@Given(":User create Get Request for the LMS API end point with invalid userID")
	public void user_create_get_request_for_the_lms_api_end_point_with_invalid_user_id() {
	   
		
	}
	
	@Given(":User put request to update data with Invalid userID")
	public void user_put_request_to_update_data_with_invalid_user_id() {
	   
	}
	
	@Given(":User put request to update data with missing mandatory fields")
	public void user_put_request_to_update_data_with_missing_mandatory_fields() {
	   
	}

	@Given(":User put request to assign program and batch to user with invalid ID")
	public void user_put_request_to_assign_program_and_batch_to_user_with_invalid_id() {
	    
	}

	@Given(":User put request to assign program and batch with user ID")
	public void user_put_request_to_assign_program_and_batch_with_user_id() {
	   
	}
	
	
	@Given(":User delete request to delete the user invalid UserId")
	public void user_delete_request_to_delete_the_user_invalid_user_id() {
	  
	}
	
/*------------------------------ Positive Scenarios When ----------------------------------------*/	
	
	@When(":User sends request body for creating user from excel {string} and {int}")
	public void user_sends_request_body_for_creating_user_from_excel_and(String SheetName, Integer RowNumber) throws Exception, IOException {
	    
	    
	    ExcelReader reader=new ExcelReader();

	  		List<Map<String,String>> testData=reader.getData(".\\testData\\Datadriventest.xlsx",SheetName);
	  		User users=new User();
	  		PhoneNumberGeneration phone= new PhoneNumberGeneration();
	  		users.setUserComments(testData.get(RowNumber).get("userComments"));
	  		//String userComments=testData.get(RowNumber).get("userComments");
	  		 users.setUserEduPg(testData.get(RowNumber).get("userEduPg"));
	  		users.setUserEduUg(testData.get(RowNumber).get("userEduUg"));
	  		users.setUserFirstName(testData.get(RowNumber).get("userFirstName"));
	  		users.setUserId(testData.get(RowNumber).get("userId"));
	  		users.setUserLastName(testData.get(RowNumber).get("userLastName"));
	  		users.setUserLinkedinUrl(testData.get(RowNumber).get("userLinkedinUrl"));
	  		users.setUserLocation(testData.get(RowNumber).get("userLocation"));
	  		users.setUserMiddleName(testData.get(RowNumber).get("userMiddleName"));
	  		//users.setUserPhoneNumber(testData.get(RowNumber).get("userPhoneNumber"));
	  		users.setUserPhoneNumber(phone.getPhoneNumber());
	  		users.setUserTimeZone(testData.get(RowNumber).get("userTimeZone"));
	  		users.setUserVisaStatus(testData.get(RowNumber).get("userVisaStatus"));
	  	  List<UserRole> userRoleMaps = new ArrayList<UserRole>();
	  	    UserRole userRole = new UserRole();
	  	    userRole.setRoleId(testData.get(RowNumber).get("roleId"));
	  	    userRole.setUserRoleStatus(testData.get(RowNumber).get("userRoleStatus"));
	  	    
			
				GlobalVar sd = new GlobalVar();
			
	  	    sd.setStudentRoleID(testData.get(RowNumber).get("roleId"));
	  	   System.out.println("RoleID in step definition="+testData.get(RowNumber).get("roleId"));
	  	   
	  	    userRoleMaps.add(userRole);
	  	    
	  	    users.setUserRoleMaps(userRoleMaps);
	  	    
	  	  ObjectMapper mapper = new ObjectMapper();
	        String nestedJsonPayload = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(users);
	        System.out.println(nestedJsonPayload);
	  	   testcase.postUserRequest(nestedJsonPayload);
	}

	@When(":User sends put request with body having programId and batchId and RoleId and UserId")
	public void user_sends_put_request_with_body_having_program_id_and_batch_id_and_role_id_and_user_id() throws Exception {
		
	AssignUserProgram userProgBatch = new AssignUserProgram();
	UserBatchStatus userStatus = new UserBatchStatus();
	
	
	userProgBatch.setProgramId(GlobalVar.programId);
	userProgBatch.setRoleId(GlobalVar.RoleId);
	userProgBatch.setUserId(GlobalVar.StudentIdsession);
	userStatus.setBatchId(GlobalVar.batchId);
	userStatus.setUserRoleProgramBatchStatus("Active");
	 List<UserBatchStatus> userRoleProgramBatches = new ArrayList<UserBatchStatus>();
	 userRoleProgramBatches.add(userStatus);
	 userProgBatch.setUserRoleProgramBatches(userRoleProgramBatches);
	ObjectMapper mapper=new ObjectMapper();
	String nestedJsonPayload=mapper.writerWithDefaultPrettyPrinter().writeValueAsString(userProgBatch);
	 System.out.println(nestedJsonPayload);
	
	 testcase.putUserProgramBatch(GlobalVar.StudentIdsession, nestedJsonPayload);
	
	}
	
	@When(":User sends Get request")
	public void user_sends_get_request() {
	    testcase.getAllusers();
	}

	@When(":User sends request with valid user id to get response")
	public void user_sends_request_with_valid_user_id_to_get_response() {
	    testcase.getUserByID(GlobalVar.AdminIDUpdate);
	}
	
	@When(":User sends request to get all staff")
	public void user_sends_request_to_get_all_staff() {
	    testcase.getAllStaff();
	}

	@When(":User sends request to get all users with their roles")
	public void user_sends_request_to_get_all_users_with_their_roles() {
	  testcase.getUserWithRoles();
	}
	
	@When(":User sends Put request body to update from excel {string} and {int}")
	public void user_sends_put_request_body_to_update_from_excel_and(String SheetName, Integer RowNumber) throws InvalidFormatException, IOException {
		 ExcelReader reader=new ExcelReader();

	  		List<Map<String,String>> testData=reader.getData(".\\testData\\Datadriventest.xlsx",SheetName);

	  		UpdateUser userupdate=new UpdateUser();
	  		
	  		userupdate.setUserComments(testData.get(RowNumber).get("userComments"));
	  		 userupdate.setUserEduPg(testData.get(RowNumber).get("userEduPg"));
	  		userupdate.setUserEduUg(testData.get(RowNumber).get("userEduUg"));
	  		userupdate.setUserFirstName(testData.get(RowNumber).get("userFirstName"));
	  		userupdate.setUserId(testData.get(RowNumber).get("userId"));
	  		String useridparam =testData.get(RowNumber).get("userId");
	  		userupdate.setUserLastName(testData.get(RowNumber).get("userLastName"));
	  		userupdate.setUserLinkedinUrl(testData.get(RowNumber).get("userLinkedinUrl"));
	  		userupdate.setUserLocation(testData.get(RowNumber).get("userLocation"));
	  		userupdate.setUserMiddleName(testData.get(RowNumber).get("userMiddleName"));
	  		userupdate.setUserPhoneNumber(testData.get(RowNumber).get("userPhoneNumber"));
	  		userupdate.setUserTimeZone(testData.get(RowNumber).get("userTimeZone"));
	  		userupdate.setUserVisaStatus(testData.get(RowNumber).get("userVisaStatus"));
	  	
	        testcase.putUserDataByID(useridparam,userupdate);
	  	   
	}
	@When(":User sends Put request body having Roleid and RoleStatus and Userid")
	public void user_sends_put_request_body_having_roleid_and_role_status_and_userid() throws JsonProcessingException {
		UserRole userrole = new UserRole();
		userrole.setRoleId(GlobalVar.RoleIdForUpdate);
		userrole.setUserRoleStatus(GlobalVar.RoleStatusForUpdate);
		 ObjectMapper mapper = new ObjectMapper();
	        String nestedJsonPayload = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(userrole);
	        System.out.println(nestedJsonPayload);
		testcase.putUserRoleStatus(GlobalVar.StaffIDDelete, nestedJsonPayload);
		
		
	 
	}

	@When(":User send delete request with userid")
	public void user_send_delete_request_with_userid() {
		testcase.deleteUserById(GlobalVar.StaffIDDelete);
		//SessionData.InvalidUserId=SessionData.AdminIDUpdate;
		
		
	}

	
/*--------------------------- Negative Scenarios When -------------------------*/

	@When(":User sends request with invalid user id to get response")
	public void user_sends_request_with_invalid_user_id_to_get_response() {
		
		testcase.getUserByID(GlobalVar.InvalidUserId);
	    
	}
	
	@When(":User sends Put request body having Roleid and RoleStatus and Invalid Userid")
	public void user_sends_put_request_body_having_roleid_and_role_status_and_invalid_userid() throws Exception {
		UserRole userrole = new UserRole();
		userrole.setRoleId(GlobalVar.RoleIdForUpdate);
		userrole.setUserRoleStatus(GlobalVar.RoleStatusForUpdate);
		 ObjectMapper mapper = new ObjectMapper();
	        String nestedJsonPayload = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(userrole);
	        System.out.println(nestedJsonPayload);
	        testcase.putUserRoleStatus(GlobalVar.InvalidUserId, nestedJsonPayload);
		
	}
	
	@When(":User sends Put request body having Roleid and Userid")
	public void user_sends_put_request_body_having_roleid_and_userid() throws Exception {
		UserRole userrole = new UserRole();
		userrole.setRoleId(GlobalVar.RoleIdForUpdate);
		//userrole.setUserRoleStatus(SessionData.RoleStatusForUpdate);
		 ObjectMapper mapper = new ObjectMapper();
	        String nestedJsonPayload = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(userrole);
	        System.out.println(nestedJsonPayload);
		testcase.putUserRoleStatus(GlobalVar.InvalidUserId, nestedJsonPayload);
	}

	@When(":User sends put request with body having programId and batchId and RoleId and  Invalid UserId")
	public void user_sends_put_request_with_body_having_program_id_and_batch_id_and_role_id_and_invalid_user_id() throws Exception {
	    
		AssignUserProgram userProgBatch = new AssignUserProgram();
		UserBatchStatus userStatus = new UserBatchStatus();
		
		
		userProgBatch.setProgramId(GlobalVar.programId);
		userProgBatch.setRoleId(GlobalVar.RoleId);
		userProgBatch.setUserId(GlobalVar.StudentIdsession);
		userStatus.setBatchId(GlobalVar.batchId);
		userStatus.setUserRoleProgramBatchStatus("Active");
		 List<UserBatchStatus> userRoleProgramBatches = new ArrayList<UserBatchStatus>();
		 userRoleProgramBatches.add(userStatus);
		 userProgBatch.setUserRoleProgramBatches(userRoleProgramBatches);
		ObjectMapper mapper=new ObjectMapper();
		String nestedJsonPayload=mapper.writerWithDefaultPrettyPrinter().writeValueAsString(userProgBatch);
		 System.out.println(nestedJsonPayload);
		
		 testcase.putUserProgramBatch(GlobalVar.InvalidUserId, nestedJsonPayload);
		
		
		
	}
	
	@When(":User sends put request with body having programId and batchId and UserId")
	public void user_sends_put_request_with_body_having_program_id_and_batch_id_and_user_id() throws Exception {
		AssignUserProgram userProgBatch = new AssignUserProgram();
		UserBatchStatus userStatus = new UserBatchStatus();
		
		
		userProgBatch.setProgramId(GlobalVar.programId);
		//userProgBatch.setRoleId(SessionData.RoleId);
		userProgBatch.setUserId(GlobalVar.StudentIdsession);
		userStatus.setBatchId(GlobalVar.batchId);
		userStatus.setUserRoleProgramBatchStatus("Active");
		 List<UserBatchStatus> userRoleProgramBatches = new ArrayList<UserBatchStatus>();
		 userRoleProgramBatches.add(userStatus);
		 userProgBatch.setUserRoleProgramBatches(userRoleProgramBatches);
		ObjectMapper mapper=new ObjectMapper();
		String nestedJsonPayload=mapper.writerWithDefaultPrettyPrinter().writeValueAsString(userProgBatch);
		 System.out.println(nestedJsonPayload);
		
		 testcase.putUserProgramBatch(GlobalVar.InvalidUserId, nestedJsonPayload); 
	}

	

	@When(":User send delete request with  invalid userid")
	public void user_send_delete_request_with_invalid_userid() {
	   
		testcase.deleteUserById(GlobalVar.InvalidUserId);
	}
	

/*------------------------- Positive Scenarios Then -------------------------------------------*/
	
	@Then(":User receives {int} Created Status with response message")
	public void user_receives_created_status_with_response_message(Integer code) {
		testcase.verify_post_status(code);
	//	Assert.assertEquals(actualcode, code);	
		
	  
	}


	@Then(":User receives {int} OK with message User status updated")
	public void user_receives_ok_with_message_user_status_updated(Integer int1) {
		testcase.verify_put_status();
	}
	
	@Then(":User receives {int} OK Status with response message")
	public void user_receives_ok_status_with_response_message(Integer int1) {
	  testcase.verify_put_status();
	}

	@Then(":User receives {int} OK with updated user response body")
	public void user_receives_ok_with_updated_user_response_body(Integer int1) {
		testcase.verify_get_status();
	}

	@Then(":User receive {int} OK with message User has been assigned to Program and Batch")
	public void user_receive_ok_with_message_user_has_been_assigned_to_program_and_batch(Integer int1) {
		testcase.verify_put_status();
	}
	
	@Then(":User receives {int} OK with message")
	public void user_receives_ok_with_message(Integer code) {
	   testcase.verify_delete_status(code); 
	}
/*-------------------------------------Negative Scenarios----------------------------------------*/
	
	@Then(":User receives {int} Bad Request Status with message")
	public void user_receives_bad_request_status_with_message(Integer code) {
	    testcase.verify_post_status(code);
	}
	
	@Then(":User receives {int} Not Found message")
	public void user_receives_not_found_message(Integer code) {
		testcase.verify_post_status(code);
	}

	@Then(":User receives {int} Not Found message userid doesnot exist")
	public void user_receives_not_found_message_userid_doesnot_exist(Integer code) {
		testcase.verify_delete_status(code); 
	}
}
