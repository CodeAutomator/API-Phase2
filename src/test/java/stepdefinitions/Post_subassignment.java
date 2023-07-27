package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import Global.GlobalVar;
import api.test.DDtestcase;

import api.utilities.ExcelReader;
import api.utilities.Loggerload;
public class Post_subassignment {
	
	DDtestcase post=new DDtestcase();

	@Given(": {string} Request to {string} the data")
	public void request_to_the_data(String string, String string2) {
	    if(string.equalsIgnoreCase("post")&& string2.equalsIgnoreCase("create"))
	    {
	    	Loggerload.info("------- post request with endpoint------------------");
	   	 
	    }
	    else if(string.equalsIgnoreCase("put")&& string2.equalsIgnoreCase("update"))
	    {
	    	Loggerload.info("------- put request with endpoint------------------");
		   	 
	    }
	    else if(string.equalsIgnoreCase("get")&& string2.equalsIgnoreCase("retrieve"))
	    
	    { 
	    	Loggerload.info("------- get request with endpoint------------------");
	    }
	    else {
	    	Loggerload.info("------- delete request with endpoint------------------");
	    }
	}

	
	
	@When(": User sends request Body from excel {string} and {int}")
		public void user_sends_request_body_from_excel_and(String SheetName,int RowNumber) throws InvalidFormatException, IOException {
		
		ExcelReader reader=new ExcelReader();

		List<Map<String,String>> testData=reader.getData(".\\testData\\Datadriventest.xlsx", SheetName);
	
		String desc=testData.get(RowNumber).get("subDesc");

		String postcomment=testData.get(RowNumber).get("subComments");

		String subpath1=testData.get(RowNumber).get("subPathAttach1");

		String subpath2=testData.get(RowNumber).get("subPathAttach2");

		String subpath3=testData.get(RowNumber).get("subPathAttach3");

		String subpath4=testData.get(RowNumber).get("subPathAttach4");

		String subpath5=testData.get(RowNumber).get("subPathAttach5");
		
		System.out.println("sheetname is "+ SheetName);
		if(SheetName.equals("postassign"))
		{
		post.TestPostSub(desc,postcomment,subpath1,subpath2,subpath3,subpath4,subpath5);
		}

		else if(SheetName.equals("put"))
		{
		post.TestputUpdate(desc,postcomment,subpath1,subpath2,subpath3,subpath4,subpath5);
		}
		
		else
		{
			post.Testputgrade(desc,postcomment,subpath1,subpath2,subpath3,subpath4,subpath5);
		}
		
		}


	
	@Then(": :User receives {int} Created Status with response body.")
	public void user_receives_created_status_with_response_body(Integer code) {
		post.verify_post_status(code);
	}
	@Given(": User has get request to retrieve the data")
	public void user_has_get_request_to_retrieve_the_data() {
	    Loggerload.info("-----user is going to retireve the by get request---------- ");
	}

	@When(": User sends get request")
	public void user_sends_get_request() {
	   post.TestGetAllSub();
	}

	@Then(": user recieves the list of data which can be validated.")
	public void user_recieves_the_list_of_data_which_can_be_validated() {
	   post.verify_get_status();
	   //post.verify_post_status(201);
	}
	
	@When(": data is retrieved using {int} by get request")
	public void data_is_retrieved_using_by_get_request(int id) {
		id=GlobalVar.assignmentId;
		post.testgetAssignmentbyid(id);
		    
	}
	@When(": grade is retrieved using {string} by get request")
	public void grade_is_retrieved_using_by_get_request(String studeid) {
	    studeid=GlobalVar.StudentIdsession;
		post.TestgetgradesbyuserID(studeid);
	    
	}
	
	@When(": grade is retrieved using batch {int} by get request")
	public void grade_is_retrieved_using_batch_by_get_request(int batchid)
	{	 batchid=GlobalVar.batchId;
		 post.TestgetgradesbybatchID(batchid);
		   
	}
	@When(":  get submission by using user {string} request")
	public void get_submission_by_using_user_request(String subuserid) {
		subuserid=GlobalVar.StudentIdsession;
		post.TestgetgradesbysubUserID(subuserid);
	    
	}
	@When(":  get submission by using batch {int} request")
	public void get_submission_by_using_batch_request(int batchid) {
		 batchid=GlobalVar.batchId;
		post.TestgetgradesbysubBatchID(batchid);
	   
	}
	@When(":  delete the  submission by using submission {int} request")
	public void delete_the_submission_by_using_submission_request(int int1) {
	    int1=GlobalVar.varforsubid;
		post.TestDeleteAssignsub(int1);
	}


	

}
