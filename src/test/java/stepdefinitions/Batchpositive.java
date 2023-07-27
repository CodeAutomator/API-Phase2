package stepdefinitions;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import Global.GlobalVar;
import api.test.BatchTest;
import api.utilities.ExcelReader;
import api.utilities.Loggerload;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


import io.cucumber.java.en.*;
import java.util.Random;
public class Batchpositive {
	BatchTest post=new BatchTest();
	@When(": Post in batch by excel {string} and {int}")
	public void post_in_batch_by_excel_and(String SheetName,int RowNumber) throws IOException, InvalidFormatException {
		ExcelReader reader=new ExcelReader();

		List<Map<String,String>>testData=reader.getData(".\\testData\\Batchmodule.xlsx", SheetName);
		
		String batchDescription=testData.get(RowNumber).get("batchDescription");
		Random r=new Random();
		
		String batchName=testData.get(RowNumber).get("batchName")+r.nextInt();
		int batchNoOfClasses=GlobalVar.batchNoOfClasses;
		String batchStatus=testData.get(RowNumber).get("batchStatus");
		int programId=GlobalVar.programId;
        String programName=testData.get(RowNumber).get("programName");
System.out.println("--------printing details********");
System.out.println(batchDescription+"--"+batchName+"---"+batchNoOfClasses+"---"+batchStatus+"---"+programId+"---"+programName);

		post.TestPostBatch(batchDescription,batchName,batchNoOfClasses,batchStatus,programId,programName);
		
	}

	@Then(": Status {int} created.")
	public void status_created(int int1) {
		post.verify_post_status(int1);
		
	}

	@When(": get request for all batches")
	public void get_request_for_all_batches() {
		post.TestGetBatch();
	}

	@Then(": Response body status is verified.")
	public void response_body_status_is_verified() {
		Loggerload.info("-----status is verified------");
	}

	@When(": get request for batch {int}")
	public void get_request_for_batch(int int1) {
		 int1=GlobalVar.batchId;
		post.TestGetBatchById(int1);
	}

	@When(": get request for batch by {string}")
	public void get_request_for_batch_by(String batchname) {
		post.TestGetBatchByName(batchname);
	}

	@When(": get request for batch by program {int}")
	public void get_request_for_batch_by_program(int int1) {
		int1=GlobalVar.programId;
		post.verify_get_by_programid(int1);
	}

	@When(": Put request for batch by excel in {string} and {int}")
	public void put_request_for_batch_by_excel_in_and(String SheetName,int RowNumber) throws IOException, InvalidFormatException {
		ExcelReader reader=new ExcelReader();
		
				List<Map<String,String>> testData=reader.getData(".\\testData\\Batchmodule.xlsx", SheetName);
				Random r=new Random();
				String batchDescription=testData.get(RowNumber).get("batchDescription");
				String batchName=testData.get(RowNumber).get("batchName")+r.nextInt();
				int batchNoOfClasses=GlobalVar.batchNoOfClasses;
				String batchStatus=testData.get(RowNumber).get("batchStatus");
				int programId=GlobalVar.programId;
		        String programName=testData.get(RowNumber).get("programName");
	post.TestUpdateBatch(batchDescription,GlobalVar.batchId,batchName,batchNoOfClasses,batchStatus,programId,programName);
	}

	@Then(": Response body for put status is verified.")
	public void response_body_for_put_status_is_verified() {
		post.VerifyUpdate_status(200);
	}

	@When(": delete request for batch {int}")
	public void delete_request_for_batch(int int1) {
	    int1=GlobalVar.batchId;
	    post.TestDeleteBatch(int1);
	}

	@Then(": batch id data gets deleted")
	public void batch_id_data_gets_deleted() {
		post.verify_del_status(200);
	}


}
