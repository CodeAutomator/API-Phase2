package api.endpoints;
import static io.restassured.RestAssured.given;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import api.payload.Batchpayload;
import static io.restassured.RestAssured.given;
//import global.GlobalVar;
import api.payload.Batchpayload;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
//import pojo.Batchpayload;
public class BatchEndPoints {
	
		public static Response createBatch(Batchpayload usePayload)
		{
			Response response=given()
			   .contentType(ContentType.JSON)
			   .accept(ContentType.JSON)
			   .body(usePayload)
			   .when()
			   .post(Routes.post_url);
			
			return response;
		}
		
		public static Response getAllBatch()
		{
			Response response=given().get(Routes.getAll_url);
			
			return response;
			   
		}
		
		public static Response getAllBatchById(int batchId)
		{
			Response response=given().auth().none().pathParam("batchId", batchId).when().get(Routes.getById_url);
			
			return response;
			   
		}
		public static Response getAllBatchByName(String batchName)
		{
			Response response=given().auth().none().pathParam("batchName", batchName). when().get(Routes.getByName_url);
			
			return response;
			   
		}
		
		public static Response getAllBatchByProgramId(int programId)
		{
			Response response=given().auth().none().pathParam("programId", programId).when().get(Routes.getByProgram_url);
			
			return response;
			   
		}
		public static Response updateBatch(int batchId,Batchpayload usePayload)
		
		{
			 Response response=given()
				   .contentType(ContentType.JSON)
				   .accept(ContentType.JSON)
				   .pathParam("batchId",batchId)
				   .body(usePayload)
				   .when()
				   .put(Routes.update_url);
				
				return response;
				   
			}
		
		public static Response deleteBatch(int id)
		{
			Response response=given().auth().none().pathParam("id",id).when().delete(Routes.delete_url);
			
			return response;
			   
		}
	}

