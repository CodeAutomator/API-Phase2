package stepdefinitions;
import io.cucumber.core.internal.com.fasterxml.jackson.databind.JsonNode;
import io.cucumber.core.internal.com.fasterxml.jackson.databind.util.JSONPObject;
import io.cucumber.java.en.*;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
//import static.io.hamcrest.*;
import  api.utilities.*;
//import api.utilities.*;

//import static io.restassured.response.Response;
import static io.restassured.RestAssured.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
//import com.fasterxml.jackson.dataformat.csv.CsvMapper;
//import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvException;
import com.opencsv.exceptions.CsvValidationException;

import Global.GlobalVar;
//import cucumber.runtime.junit.Assertions;
public class Positive_program_sd {
	String responseBody ;

	Response response;
   Response res;
   Response res1;
	ResponseBody body;
	//JSONObject requestParams;
	//RequestSpecification Id;
	//Map<String,String>  jsonAsMap;
		
	@Given("user is getting information")
	public void user_is_getting_information1() {
		Loggerload.info("*************Getting all records***************");
	    given().auth().none()
		 .header("Content-Type", "application/json");
		
		 Loggerload.info("In the Given by proram Id");
	}
	@When("we send base url")
	public void we_send_base_url() {
		Loggerload.info("*************Getting all records***************");
		/*res=when().get("https://lms-api-hackathon-june2023-930a8b0f895d.herokuapp.com/lms/allPrograms").prettyPeek();
			
		Loggerload.info(res.toString());*/
		res=prddTestcase.getall();
		Loggerload.info(res.toString());
		}
	@Then("validating status codes")
	public void validating_status_codes() {
		
		System.out.println(res.statusCode());
		System.out.println(res.getContentType());
		
		
	}

	@When("we send base ith post url")
	public void we_send_base_ith_post_url() throws IOException, Exception {
		Loggerload.info("*************POSt request***************");
	CSVReader csvReader = new CSVReader(new FileReader(".\\testData\\abd.csv"));
    List<String[]> csvData = csvReader.readAll();
    csvReader.close();

    // Assuming the first row in the CSV file is the header row
    String[] headers = csvData.get(0);
    for (int i = 1; i < csvData.size(); i++) {
        String[] dataRow = csvData.get(i);

        // Build the request body
        String requestBody = "{";
        for (int j = 0; j < headers.length; j++) {
            if (j > 0) {
                requestBody += ",";
            }
            requestBody += "\"" + headers[j] + "\":\"" + dataRow[j] + "\"";
        }
        requestBody += "}";
  
      
        // Send the POST request
        Response response = RestAssured.given().auth().none().contentType(ContentType.JSON)
                .body(requestBody)
                .post("https://lms-api-hackathon-june2023-930a8b0f895d.herokuapp.com/lms/saveprogram");
        Loggerload.info(response.toString());
		
	//	Response response=prddTestcase.postcodereader();
         System.out.println("Response code: " + response.getStatusCode());
        System.out.println("Response body: " + response.getBody().asString());
        
     //   String filePath = "response.json";
       responseBody = response.getBody().asString();
      // Globalval.responseBody=responseBody;
        // Write the response to the JSON file
       
        FileWriter fileWriter = new FileWriter(".\\src\\test\\resources\\Datafiles\\response.json");
            fileWriter.write(responseBody);
            fileWriter.close();
    }
    
}
	
      

	@Then("validating first post status codes")
	public void validating_first_post_status_codes() {
		System.out.println("Post code is validated");
		
	}

	@When("we send with programId")
	public void we_send_with_program_id() throws IOException, CsvException, ParseException {
		Loggerload.info("*************GET program byId***************");
	JSONParser js=new JSONParser();
    FileReader reader=new FileReader(".\\src\\test\\resources\\Datafiles\\response.json");
    Object obj=js.parse(reader);
    JSONObject program=(JSONObject)obj;
    String programId= program.get("programId").toString();
    Integer.parseInt(programId);
    String programName=program.get("programName").toString();
    GlobalVar.programId=Integer.parseInt(programId);
    GlobalVar.programName=programName;
    System.out.println(programId); 
  // System.out.println(programName);
     Response res1 = given().pathParam("programId", programId).when().
  	  get("https://lms-api-hackathon-june2023-930a8b0f895d.herokuapp.com/lms/programs/{programId}");
     Loggerload.info(res1.toString());
  	 res1.then().log().all();
  // System.out.println(res1); 
 
  	}
	@Then("validating GET BY Idstatus codes")
	public void validating_get_by_idstatus_codes() {
		System.out.println("respnse codeget by Id is validated");
		
	}
	@When("we send put url ByID")
	public void we_send_put_url_by_id() throws IOException, CsvException {
		Loggerload.info("************PUT program byId***************");
	    System.out.println("programId is"+GlobalVar.programId);
	    CSVReader csvReader = new CSVReader(new FileReader(".\\testData\\result.csv"));
	    List<String[]> csvData = csvReader.readAll();
	    csvReader.close();

	    // Assuming the first row in the CSV file is the header row
	    String[] headers = csvData.get(0);
	    for (int i = 1; i < csvData.size(); i++) {
	        String[] dataRow = csvData.get(i);

	        // Build the request body
	        String requestBody = "{";
	        for (int j = 0; j < headers.length; j++) {
	            if (j > 0) {
	                requestBody += ",";
	            }
	            requestBody += "\"" + headers[j] + "\":\"" + dataRow[j] + "\"";
	        }
	        requestBody += "}";
	    
	      
	        // Send the POST request
	        Response response = RestAssured.given().contentType(ContentType.JSON)
	        		.pathParam("programId", GlobalVar.programId)
	                .body(requestBody)
	                .put("https://lms-api-hackathon-june2023-930a8b0f895d.herokuapp.com/lms/putprogram/{programId}");
	        Loggerload.info(response.toString());      		

	         System.out.println("Response code: " + response.getStatusCode());
	        System.out.println("Response body: " + response.getBody().asString());
	        
	     //   String filePath = "response.json";
	      // responseBody = response.getBody().asString();
	       response.then().log().all();
	      // Globalval.responseBody=responseBody;
	        // Write the response to the JSON file
	       
	      /*  FileWriter fileWriter = new FileWriter("C:\\Users\\jayam\\eclipse-workspace\\API_cucumber\\src\\test\\resources\\Datafiles\\response.json");
	            fileWriter.write(responseBody);
	            fileWriter.close();*/
	   }
	  
	}
	

	@Then("validating PUT BY IDstatus codes")
	public void validating_put_by_i_dstatus_codes() {
		System.out.println("respnse codeput by Id is validated");
		
	}
	

	@When("we send DELETE ByID")
	public void we_send_delete_by_id() {
		Loggerload.info("************DELETE program byId***************");
		 Response res1 = given().pathParam("programId", GlobalVar.programId).when().
			  	 delete("https://lms-api-hackathon-june2023-930a8b0f895d.herokuapp.com/lms/deletebyprogid/{programId}");
			  	 res1.then().log().all();
			  	Loggerload.info(res1.toString());
			  // System.out.println(res1); 
	}
	@Then("validating DELETE BY ID status codes")
	public void validating_delete_by_id_status_codes() {
		System.out.println("REsponse code delete by Id is validated");
	}
	@When("we sendsecond base  post url")
	public void we_sendsecond_base_post_url() throws IOException, CsvException, ParseException {
		Loggerload.info("************POST second program ***************");
//		CSVReader csvReader = new CSVReader(new FileReader(".\\testData\\result.csv"));
//	    List<String[]> csvData = csvReader.readAll();
//	    csvReader.close();
//
//	    // Assuming the first row in the CSV file is the header row
//	    String[] headers = csvData.get(0);
//	    for (int i = 1; i < csvData.size(); i++) {
//	        String[] dataRow = csvData.get(i);
//
//	        // Build the request body
//	        String requestBody = "{";
//	        for (int j = 0; j < headers.length; j++) {
//	            if (j > 0) {
//	                requestBody += ",";
//	            }
//	            requestBody += "\"" + headers[j] + "\":\"" + dataRow[j] + "\"";
//	        }
//	        requestBody += "}";
//	    
//	      
//	        // Send the POST request
//	        Response response = RestAssured.given().contentType(ContentType.JSON)
//	                .body(requestBody)
//	                .post("https://lms-api-hackathon-june2023-930a8b0f895d.herokuapp.com/lms/saveprogram");
//	        Loggerload.info(response.toString());
//	         System.out.println("Response code: " + response.getStatusCode());
//	        System.out.println("Response body: " + response.getBody().asString());
//	        
//	     //   String filePath = "response.json";
//	       responseBody = response.getBody().asString();
//	       
//	      // Globalval.responseBody=responseBody;
//	        // Write the response to the JSON file
//	       
//	        FileWriter fileWriter = new FileWriter(".\\src\\test\\resources\\Datafiles\\response.json");
//	            fileWriter.write(responseBody);
//	            fileWriter.close();
//	            JSONParser js=new JSONParser();
//	            FileReader reader=new FileReader(".\\src\\test\\resources\\Datafiles\\response.json");
//	             Object obj=js.parse(reader);
//	           JSONObject program=(JSONObject)obj;
//	         String programName=program.get("programName").toString();
//	       	   GlobalVar.programName=programName;
//	       	   System.out.println("program name is"+programName);
		CSVReader csvReader = new CSVReader(new FileReader(".\\testData\\result.csv"));
	    List<String[]> csvData = csvReader.readAll();
	    csvReader.close();
	    // Assuming the first row in the CSV file is the header row
	    String[] headers = csvData.get(0);
	    for (int i = 1; i < csvData.size(); i++) {
	        String[] dataRow = csvData.get(i);
	        // Build the request body
	        String requestBody = "{";
	        for (int j = 0; j < headers.length; j++) {
	            if (j > 0) {
	                requestBody += ",";
	            }
	            requestBody += "\"" + headers[j] + "\":\"" + dataRow[j] + "\"";
	        }
	        requestBody += "}";
	        // Send the POST request
	        Response response = RestAssured.given().auth().none().contentType(ContentType.JSON)
	                .body(requestBody)
	                .post("https://lms-api-hackathon-june2023-930a8b0f895d.herokuapp.com/lms/saveprogram");
	        Loggerload.info(response.toString());
			
		//	Response response=prddTestcase.postcodereader();
	         System.out.println("Response code: " + response.getStatusCode());
	        System.out.println("Response body: " + response.getBody().asString());
	     //   String filePath = "response.json";
	       responseBody = response.getBody().asString();
	      // Globalval.responseBody=responseBody;
	        // Write the response to the JSON file
	        FileWriter fileWriter = new FileWriter(".\\src\\test\\resources\\Datafiles\\response.json");
	            fileWriter.write(responseBody);
	            fileWriter.close();
	    }
//	          
	    }
	
	@Then("validating Second POST BYID status check")
	public void validating_second_post_byid_status_check() {
	    System.out.println("post code is validates");
	}
	@When("we send put url By Name")
	public void we_send_put_url_by_name() throws IOException, CsvException {
		Loggerload.info("************PUT program BY NAME ***************");
		 CSVReader csvReader = new CSVReader(new FileReader(".\\testData\\result.csv"));
		    List<String[]> csvData = csvReader.readAll();
		    csvReader.close();

		    // Assuming the first row in the CSV file is the header row
		    String[] headers = csvData.get(0);
		    for (int i = 1; i < csvData.size(); i++) {
		        String[] dataRow = csvData.get(i);

		        // Build the request body
		        String requestBody = "{";
		        for (int j = 0; j < headers.length; j++) {
		            if (j > 0) {
		                requestBody += ",";
		            }
		            requestBody += "\"" + headers[j] + "\":\"" + dataRow[j] + "\"";
		        }
		        requestBody += "}";
		    
		      
		        // Send the POST request
		        Response response = RestAssured.given().contentType(ContentType.JSON)
		        		.pathParam("programName", GlobalVar.programName)
		                .body(requestBody)
		                .put("https://lms-api-hackathon-june2023-930a8b0f895d.herokuapp.com/lms/program/{programName}");
		        Loggerload.info(response.toString());      		

		         System.out.println("Response code: " + response.getStatusCode());
		        System.out.println("Response body: " + response.getBody().asString());
		        
		     //   String filePath = "response.json";
		      // responseBody = response.getBody().asString();
		       response.then().log().all();
		     //  Globalval.responseBody=responseBody;
		        // Write the response to the JSON file
		       
		     /*   FileWriter fileWriter = new FileWriter("C:\\Users\\jayam\\eclipse-workspace\\API_cucumber\\src\\test\\resources\\Datafiles\\response1.json");
		            fileWriter.write(responseBody);
		            fileWriter.close();*/
		   }
		  
	}
	@Then("validating PUT BY Name status codes")
	public void validating_put_by_name_status_codes() {
	   System.out.println("PUT by name is validated");
	}
	@When("we send url DELETE Name")
	public void we_send_url_delete_name() {
		Loggerload.info("************DELETE program BY NAME ***************");
			 Response res1 = given().pathParam("programName", GlobalVar.programName).when().
				  	delete("https://lms-api-hackathon-june2023-930a8b0f895d.herokuapp.com/lms/deletebyprogname/{programName}");
				//Loggerload.info(response.toString());  	 
				  	 res1.then().log().all();
	}
	@Then("validating DELTE BY NAME status codes")
	public void validating_delte_by_name_status_codes() {
	    System.out.println("validated delete status code");
	}
	


/*@Then("validating PUT BY IDstatus codes")
public void validating_put_by_i_dstatus_codes() {
    
}*/
	
}
