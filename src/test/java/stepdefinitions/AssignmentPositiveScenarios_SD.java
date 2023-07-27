package stepdefinitions;
import api.utilities.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import org.apache.poi.ss.usermodel.*;
//import org.json.simple.JSONObject;
import api.utilities.*;
import Global.GlobalVar;
import api.payload.AssignmentPayload;
import api.test.AssignmentTests;
import io.cucumber.java.en.*;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
public class AssignmentPositiveScenarios_SD {
	public static Response response;
	//public JSONObject jsonAssignment;
	public String assignmentName;
	public AssignmentPayload assignmentPayload;
	RequestSpecification requestSpec;
	AssignmentTests post = new AssignmentTests();
	
	@Given("User creates POST Request for the LMS API endpoint")
	public void User_creates_POST_Request_for_the_LMS_API_endpoint(){
		Loggerload.info("Assignment POST request with endpoint");
	}
	
	//@When("User sends request Body from excel <sheetNo> and <rowNum>")
	@When("User sends request Body from excel")
	public void user_sends_request_body_from_excel() throws IOException
			 {
		
		String strFilePath  = System.getProperty("user.dir") + 
				".\\testData\\Datadriventest.xlsx";
		ExcelReader.setFilePath(strFilePath);
		ExcelReader.setSheetNo(4);
		ExcelReader.setRowNo(1);
		Row row = ExcelReader.GetRowData();
		Random r = new Random(); 
		String dueDate;
	   
		LocalDateTime currentDate = LocalDateTime.now();
		//SimpleDateFormat formatter=new SimpleDateFormat("MM-dd-yyyy HH:mm:ss");//.format(DateTimeFormatter.ofPattern("yyyy-MMM-dd HH:mm:ss"))
		dueDate= currentDate.plusDays(1).toString();

		String desc = row.getCell(1).toString();
		String name = row.getCell(0).toString()+ r.nextInt();
		int batchId = GlobalVar.batchId;
		String comments = row.getCell(2).toString();

		String createdBy = row.getCell(3).toString();
	   	String graderId = GlobalVar.AdminIDUpdate;//row.getCell(4).toString();
		String path1 = row.getCell(5).toString();
		String path2 = row.getCell(6).toString();
		String path3 = row.getCell(7).toString();
		String path4 = row.getCell(8).toString();
		String path5 = row.getCell(9).toString();
		//batchid??again in excel sheet 
		post.TestPostAssignment(desc, name, batchId, comments, 
				createdBy, dueDate, graderId, path1, path2, 
				path3, path4, path5);
	}
		
	//@Then("User receives created Status with response body <id>")
	@Then("User receives created Status with response body")
	public void user_receives_created_status_with_response_body(){  
		//post.verifyStatus(201);
		post.verify_update_status(201);
	}
	
	@Given("User creates DELETE Request for the LMS API endpoint")
	public void User_creates_DELETE_Request_for_the_LMS_API_endpoint(){
		Loggerload.info("Assignment DELETE request with endpoint");
	}
	
    @When ("User calls the payload API with delete request by assignmentId")
    public void User_calls_the_payload_API_with_delete_request(){
		post.TestDeleteAssignment(GlobalVar.assignmentId);   	
	} 
    
    @Then ("Assignment gets deleted")
    public void Assignment_gets_deleted(){
//    	post.verifyStatus(200);
    	post.verify_delete_status(200);
	} 
	
	@Given("User creates GET Request for the LMS API endpoint")
	public void User_creates_GET_Request_for_the_LMS_API_endpoint(){
		Loggerload.info("Assignment GET request with endpoint");
	}
	
	@When("User calls the payload API with get request")
	public void user_calls_the_payload_api_with_get_request(){
		post.TestGetAllAssignments();
	}
		
	@Then("User gets data of all assignments in response")
	public void user_gets_data_of_all_assignments_in_response(){
//		post.verifyStatus(200);
		post.verify_get_status(200);
	}

	//@When ("User calls the payload API with get request by <assignmentId>")
	@When ("User calls the payload API with get request by assignmentId")
	public void User_calls_the_payload_API_with_get_request_by_assignment_id(){
    	post.TestGetAssignmentByAssignmentId(GlobalVar.assignmentId);
	} 
    @Then ("User gets data by assignment id in response")
    public void User_gets_data_by_assignment_id_in_response(){
 //   	post.verifyStatus(200);
    	post.verify_get_status(200);
	} 
    @When ("User calls the payload API with get request by batchId")
    public void User_calls_the_payload_API_with_get_request_by_batch_id(){
		post.TestGetAssignmentsByBatchId(GlobalVar.batchId);
    } 
    @Then ("User gets data by batch id in response")
    public void User_gets_data_by_batch_id_in_response(){
//    	post.verifyStatus(200);
    	post.verify_get_status(200);
   }
   
   	@Given("User creates PUT Request for the LMS API endpoint")
	public void User_creates_PUT_Request_for_the_LMS_API_endpoint(){
		Loggerload.info("Assignment PUT request with endpoint");
	}
	
    @When ("User calls the payload API with put request by assignmentId")
    public void User_calls_the_payload_API_with_put_request() throws IOException{
    	String strFilePath  = System.getProperty("user.dir") + 
    			".\\testData\\Datadriventest.xlsx";
		ExcelReader.setFilePath(strFilePath);
		ExcelReader.setSheetNo(4);
		ExcelReader.setRowNo(2);
		Row row = ExcelReader.GetRowData();
		Random r = new Random(); 
		Date dt = new Date();
//	    SimpleDateFormat dateFormat = 
//	    		new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
//	    String dueDate = dateFormat.format(dt);
////		Calendar cal = Calendar.getInstance();
////		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
////		String subdate=formatter.format(cal.getTime());
////		System.out.println("subdate is "+subdate);
////		
////		cal.add(Calendar.SECOND,120);
////		String dueDate= formatter.format(cal.getTime());
	    String dueDate;
		SimpleDateFormat dateFormat = 
	    		new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
	    Calendar cal = Calendar.getInstance();
	    
	    //***uncomment the below line for future date
	    //cal.add(Calendar.SECOND, 20);
	    //***uncomment the above line for future date
	    
	    dueDate = dateFormat.format(cal.getTime());

		cal.add(Calendar.HOUR,24);
		dueDate= dateFormat.format(cal.getTime());
	    int id = GlobalVar.assignmentId;
		String desc = row.getCell(1).toString();
		String name = row.getCell(0).toString()+ r.nextInt();
		int batchId = GlobalVar.batchId;
		String comments = row.getCell(2).toString();;
		String createdBy = row.getCell(3).toString();
	   	String graderId = GlobalVar.AdminIDUpdate;//row.getCell(4).toString();
		String path1 = row.getCell(5).toString();
		String path2 = row.getCell(6).toString();
		String path3 = row.getCell(7).toString();
		String path4 = row.getCell(8).toString();
		String path5 = row.getCell(9).toString();
    	//batchid assignment id
    	post.TestUpdateAssignment(id, desc, name, batchId, comments, 
				createdBy, dueDate, graderId, path1, path2, 
				path3, path4, path5);		
	} 
    @Then ("Assignment gets updated")   
    public void Assignment_gets_updated(){
//    	post.verifyStatus(200);
    	post.verify_update_status(200);
	}
}
