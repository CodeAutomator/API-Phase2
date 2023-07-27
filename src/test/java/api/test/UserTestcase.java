package api.test;
import java.util.List;
import org.testng.Assert;


import api.endpoints.UserEndPoints;
import api.payload.AssignUserProgram;
import api.payload.UpdateUser;
import api.payload.User;
import api.payload.UserRole;
import Global.GlobalVar;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
public class UserTestcase {
Response response,getresponse,putresponse;
	
	public static int actualstatus;
	public static String StudentId;
	public static String StaffId;
	public static String AdminId;
	public void postUserRequest(String userpayload)
	{	
		response= UserEndPoints.createUser(userpayload);
		response.then().log().all();
		actualstatus=response.getStatusCode();
		String responseID=response.then().contentType(ContentType.JSON).extract().path("userId");
		//System.out.println("UserID="+responseID);
		GlobalVar sd= new GlobalVar();
		sd.setStudentIdsession(responseID);;
		
	
	}
	
	public void verify_post_status(int code)

	{

		Assert.assertEquals(actualstatus, code);	

		//Loggerload.info("*********************** User details are Displayed *************");

	}	
	
	public void getAllusers()
	{
		getresponse=UserEndPoints.getUsers();
		getresponse.then().log().all();
		actualstatus=getresponse.getStatusCode();
		//Loggerload.info("*********************** All Users with their details are Displayed *************");
		
		
	}
	public void verify_get_status()

	{

		Assert.assertEquals(actualstatus, 200);	
		

		//Loggerload.info("*********************** User details are Displayed *************");

	}	
	public void getUserByID(String USERID)
	{
		getresponse=UserEndPoints.getUserByID(USERID);
		getresponse.then().log().all();
		actualstatus=getresponse.getStatusCode();
		
		//Loggerload.info("*********************** User details of given USERID are Displayed *************");
	}
	
	public void getAllStaff() {
		getresponse=UserEndPoints.getAllStaff();
		getresponse.then().log().all();
		actualstatus=getresponse.getStatusCode();
		//Loggerload.info("*********************** Staff Users details are Displayed *************");
	}
	public void getUserWithRoles()
	{
		getresponse=UserEndPoints.getUserWithRoles();
		getresponse.then().log().all();
		actualstatus=getresponse.getStatusCode();
		
		//Loggerload.info("*********************** User details with their Roles are Displayed *************");
	}
	
	public void putUserDataByID(String useridparam,UpdateUser userpayload) {
		
		putresponse = UserEndPoints.putUser(useridparam,userpayload);
		putresponse.then().log().all();
		actualstatus=putresponse.getStatusCode();
		
		//Loggerload.info("*********************** User details of given USERID are updated and  Displayed *************");
	}
	
	public void verify_put_status()

	{

		Assert.assertEquals(actualstatus, 200);	
		

		

	}
	
	public void putUserRoleStatus(String userid,String payload)
	{
		putresponse= UserEndPoints.putUserRole(userid,payload);
		putresponse.then().log().all();
		actualstatus=putresponse.getStatusCode();
		
		//Loggerload.info("*********************** Role ID is updated of given userid and details are Displayed *************");
		
	}
	
	public void putUserProgramBatch(String userid,String payload)
	{
		putresponse=UserEndPoints.putAssignUserProgram(userid, payload);
		putresponse.then().log().all();
		actualstatus=putresponse.getStatusCode();
		
		//Loggerload.info("*********************** Program and Batch is assigned successfully to the given UserID *************");
		
	}
	
	public void deleteUserById(String uid) {
		
		response=UserEndPoints.deleteUser(uid);
		response.then().log().all();
		actualstatus=response.getStatusCode();
		//Loggerload.info("***********************Given UserID is deleted successfully *************");
	}
	
	public void verify_delete_status(int code)

	{

		Assert.assertEquals(actualstatus, code);	
		

		

	}
}
