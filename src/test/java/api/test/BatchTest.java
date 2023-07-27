package api.test;
import java.io.IOException;

import org.junit.Assert;

import com.github.javafaker.Faker;
import Global.GlobalVar;
import api.endpoints.BatchEndPoints;
import api.utilities.Loggerload;
import io.restassured.RestAssured;
import io.restassured.filter.log.LogDetail;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import api.payload.Batchpayload;
public class BatchTest {
	static Faker faker = new Faker();
	 
	public static Response response;
	
	Response getresponse;
	public static String extractresponse;

	Response afterupdateresponse;

	Response afterdelresponse;
	
	ValidatableResponse vResponse;
	
 public static int actualcode;
 public static int batchId;
 public static int id;
 public static int batchNoOfClasses;
//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ POST @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@//
 
	public void TestPostBatch(String batchDescription,String batchName,int batchNoOfClasses,String batchStatus,int programId,String programName)throws IOException
	{
		Batchpayload usePayload=new Batchpayload();
		
		
		usePayload.setBatchDescription(batchDescription);
		usePayload.setBatchName(batchName);
		usePayload.setBatchNoOfClasses(batchNoOfClasses);
		usePayload.setBatchStatus(batchStatus);
		usePayload.setProgramId(programId);
		usePayload.setProgramName(programName);
		
	   Loggerload.info("*********************** Creating Batch **************************");
	   
	   response= BatchEndPoints.createBatch(usePayload);
	    response.then().log().all();
		actualcode=response.getStatusCode();
		extractresponse=response.then().log().all().extract().response().asString();
		System.out.println("response body is "+extractresponse);
		JsonPath js=new JsonPath(extractresponse);
		if (response.statusCode()== 201){
			System.out.println("Object created !! Inside......");
			int batchid=js.getInt("batchId");
			System.out.println("value of id"+batchid);
			GlobalVar.batchId=batchid;	
			
	   
		
	   Loggerload.info("*********************** Batch is Created ***********************");
	
	   Loggerload.info(response.asString());
		}
	}
	
	

  


	public void verify_post_status(int int1) {
		

Assert.assertEquals(actualcode,int1);
		
		Loggerload.info("*********************** status is been verified ****************");
	}
//		//Assert.assertEquals(actualcode,int1);
//		
//		if(int1==201) {
//		Assert.assertEquals(response.contentType(),"application/json");
//		Assert.assertEquals(response.header("Content-Type"),"application/json");
//		response.headers().get("Transfer-Encoding").equals("chunked");
//		response.then().log().ifValidationFails(LogDetail.METHOD);
//		response.then().log().ifValidationFails(LogDetail.BODY);	
//		RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
//		// To log request and response header
//		RestAssured.enableLoggingOfRequestAndResponseIfValidationFails(LogDetail.HEADERS);
//		
//		Loggerload.info("*********************** status is been verified ****************");
	//}
	
		
	//@@@@@@@@@@@@@@@@@@@@@@ GET @@@@@@@@@@@@@@@@@@@@@@@@@@@@//

	public void TestGetBatch()

	{

		Loggerload.info("*********************** Retrieving All Batches *************");
		
		response= BatchEndPoints.getAllBatch();
	   // Loggerload.info(getresponse.toString());
		actualcode = response.getStatusCode();
		response.then().log().all();
	}

	public void TestGetBatchById(int batchId)

	{

		Loggerload.info("*********************** Retriving Batch *************");
		response= BatchEndPoints.getAllBatchById(batchId);
		Loggerload.info(response.toString());
		actualcode = response.getStatusCode();
		response.then().log().all();	
		
	}
	public void verify_get_by_id(int batchId)

	{

		Assert.assertEquals(response.getStatusCode(), 200);

		Loggerload.info("*********************** Batch details are Displayed *************");

		
	}

	public void TestGetBatchByName(String batchName)

	{

		Loggerload.info("*********************** Retrieving Batch *************");
		response= BatchEndPoints.getAllBatchByName(batchName);
		Loggerload.info(response.toString());
		actualcode = response.getStatusCode();
		response.then().log().all();
	}
	public void verify_get_by_name(String batchName)

	{

		Assert.assertEquals(getresponse.getStatusCode(), 200);	

		Loggerload.info("*********************** Batch details are Displayed *************");

		
	}

	public void TestGetBatchByProgramId(int programId)

	{

		Loggerload.info("*********************** Retriving Batch *************");
		response= BatchEndPoints.getAllBatchByProgramId(programId);
		Loggerload.info(response.toString());
		actualcode = response.getStatusCode();
		response.then().log().all();	
		
	}

	public void verify_get_by_programid(int programId)

	{
		response=BatchEndPoints.getAllBatchByProgramId(programId);
		Assert.assertEquals(response.getStatusCode(), 200);	

		Loggerload.info("*********************** Batch details are Displayed *************");

		}

	//@@@@@@@@@@@@@@@@@@@@@@@ UPDATE @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@//
		
		public void TestUpdateBatch(String batchDescription,int batchId,String batchName,int batchNoOfClasses,String batchStatus,int programId,String programName)throws IOException
		{
			Batchpayload usePayload=new Batchpayload();
			
			usePayload.setBatchDescription(batchDescription);
			usePayload.setBatchId(batchId);
			usePayload.setBatchName(batchName);
			usePayload.setBatchNoOfClasses(batchNoOfClasses);
			usePayload.setBatchStatus(batchStatus);
			usePayload.setProgramId(programId);
			usePayload.setProgramName(programName);

		Loggerload.info("*********************** Updating Batch*************");

		response= BatchEndPoints.updateBatch(batchId,usePayload);

		response.then().log().all();

		//Assert.assertEquals(response.getStatusCode(), 200);

		Loggerload.info("*********************** Batch details Updated ****************");

		Loggerload.info("*********************** Retriving Batch Details after Update *************");

		afterupdateresponse= BatchEndPoints.getAllBatchById(batchId);
		Loggerload.info(afterupdateresponse.toString());
		afterupdateresponse.then().log().all();

	}

		public void VerifyUpdate_status(int batchId)

		{

			//Assert.assertEquals(actualcode, batchId);	
			if(actualcode==200) {
		Loggerload.info("*********************** Batch details Updated *************");
	
	}
		}

		//@@@@@@@@@@@@@@@@@@@@@@@ DELETE @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@//

		public void TestDeleteBatch(int id )

		{

			Loggerload.info("*********************** Deleting Batch *************");
			response= BatchEndPoints.deleteBatch(id);
			Loggerload.info(response.toString());
	
		}

		
        public void verify_del_status(int id)

		{

        	Assert.assertEquals(actualcode, id);	
    		if(actualcode==200) {	
			Loggerload.info("*********************** Deletion Successful *************");

		}
		}
}
