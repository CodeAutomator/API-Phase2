package stepdefinitions;
import io.cucumber.java.en.Given;
import java.util.Random;
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

public class NegativeassignSubmit {
	
		
		DDtestcase post=new DDtestcase();

		@Given(": {string} Request to {string} the data for negative scenario")
		public void request_to_the_data_for_negative_scenario(String string, String string2) {
		    
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
		

		
		@When(": payload by excel {string} and {int}")
		public void payload_by_excel_and(String SheetName,int RowNumber) throws InvalidFormatException, IOException {
			ExcelReader reader=new ExcelReader();

			List<Map<String,String>> testData=reader.getData(".\\testData\\Datadriventest.xlsx", SheetName);
			
			
			

			String desc=testData.get(RowNumber).get("subDesc");
	
			String postcomment=testData.get(RowNumber).get("subComments");

			String subpath1=testData.get(RowNumber).get("subPathAttach1");

			String subpath2=testData.get(RowNumber).get("subPathAttach2");

			String subpath3=testData.get(RowNumber).get("subPathAttach3");

			String subpath4=testData.get(RowNumber).get("subPathAttach4");

			String subpath5=testData.get(RowNumber).get("subPathAttach5");
			if(SheetName.equals("negpost"))
			{
				Random r=new Random();
				int assignid=GlobalVar.assignmentId;
				String userid="U"+r.nextInt();
			post.TestPostUserneg(assignid,userid,desc,postcomment,subpath1,subpath2,subpath3,subpath4,subpath5);
			}

			else if(SheetName.equals("Negputscenario"))
			{
				post.TestputUpdate(desc,postcomment,subpath1,subpath2,subpath3,subpath4,subpath5);
			}
			
			else
			{
				post.Testputgrade(desc,postcomment,subpath1,subpath2,subpath3,subpath4,subpath5);
			}
			
		
		}
	

	
		@Then(": user recieves the list of data which can be validated for negative scenario.")
		public void user_recieves_the_list_of_data_which_can_be_validated_for_negative_scenario() {
		   post.Testnegscenario();
		}

		@When(": data is retrieved using {int}  get request")
		public void data_is_retrieved_using_get_request(int int1) {
			
			int1=GlobalVar.assignmentId;
			post.testgetAssignmentbyid(int1);
		   		}

		@When(": user data from get request by {string}")
		public void user_data_from_get_request_by(String userid) {
		  Random ruser=new Random();
		  userid="U"+ruser.nextInt();
			post.TestgetgradesbyuserID(userid);
		}

	
		@When(": grade using batch {int} by get request")
		public void grade_using_batch_by_get_request(int batchid) {
			Random rbatch=new Random();
			batchid=rbatch.nextInt();
			post.TestgetgradesbybatchID(batchid);
		}

		@When(":  submission by using user {string} with get request")
		public void submission_by_using_user_with_get_request(String uid) {
		    Random ruid=new Random();
		    uid="U"+ruid.nextInt();
			post.TestgetgradesbysubUserID(uid);
		}

		@When(":  submission by using batch {int} request")
		public void submission_by_using_batch_request(int bid) {
		   Random rbid=new Random();
		   bid=rbid.nextInt();
			post.TestgetgradesbysubBatchID(bid);
		}

		@When(":  submission by using submission {int} with delete request")
		public void submission_by_using_submission_with_delete_request(int int1) {
		   
		   int1=GlobalVar.varforsubid;
			post.TestDeleteAssignsub(int1);
		}





		

	}

