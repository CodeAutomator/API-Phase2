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

public class Negative_program_sd {
	private static final String String = null;


	String responseBody ;

	@When("we send base url validating  post url")
	public void we_send_base_url_validating_post_url() throws IOException, CsvException {
		CSVReader csvReader = new CSVReader(new FileReader(".\\testData\\Ng_data.csv"));
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
	    
	      
	       // java.lang.String requestBody1 = "ansdbhf";
			// Send the POST request
	        Response response = RestAssured.given().contentType(ContentType.JSON)
	            .body(requestBody)
	                .post("https://lms-api-hackathon-june2023-930a8b0f895d.herokuapp.com/lms/saveprogram");

	         System.out.println("Response code: " + response.getStatusCode());
	        System.out.println("Response body: " + response.getBody().asString());
	        
	     //   String filePath = "response.json";
	       responseBody = response.getBody().asString();
	      // Globalval.responseBody=responseBody;
	        // Write the response to the JSON file
	       
	      /*  FileWriter fileWriter = new FileWriter("C:\\Users\\jayam\\eclipse-workspace\\API_cucumber\\src\\test\\resources\\Datafiles\\response.json");
	            fileWriter.write(responseBody);
	            fileWriter.close();*/
	    }
	    
	    
	}

	@When("we send with invalid programId")
	public void we_send_with_invalid_program_id() throws IOException, CsvException {
		// java.lang.String programId = "123";
		//System.out.println("programId is"+programId);
		    CSVReader csvReader = new CSVReader(new FileReader(".\\testData\\Ng_data.csv"));
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
		                		

		         System.out.println("Response code: " + response.getStatusCode());
		        System.out.println("Response body: " + response.getBody().asString());
	}}

	@When("we send put url By invalid ID")
	public void we_send_put_url_by_invalid_id() throws IOException, CsvException {
		// java.lang.String programId = "123";
	//	System.out.println("programId is"+programId);
		    CSVReader csvReader = new CSVReader(new FileReader(".\\testData\\Ng_data.csv"));
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
		        		.pathParam("programId",GlobalVar.programId)
		                .body(requestBody)
		                .put("https://lms-api-hackathon-june2023-930a8b0f895d.herokuapp.com/lms/putprogram/{programId}");
		                		

		         System.out.println("Response code: " + response.getStatusCode());
		        System.out.println("Response body: " + response.getBody().asString());  }
	}

	@When("we send put url BY invalid programName")
	public void we_send_put_url_by_invalid_program_name() throws IOException, CsvException {
		CSVReader csvReader = new CSVReader(new FileReader(".\\testData\\Ng_data.csv"));
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
	    
	      
	       // Object programName = "abc";
			// Send the POST request
	        Response response = RestAssured.given().contentType(ContentType.JSON)
	        		.pathParam("programName",GlobalVar.programName)
	               //.body(requestBody)
	                .put("https://lms-api-hackathon-june2023-930a8b0f895d.herokuapp.com/lms/program/{programName}");
	                		

	         System.out.println("Response code: " + response.getStatusCode());
	        System.out.println("Response body: " + response.getBody().asString());
	    }
	}

	@When("we send put url Byinvalid programName")
	public void we_send_put_url_byinvalid_program_name() throws IOException, CsvException {
		CSVReader csvReader = new CSVReader(new FileReader(".\\testData\\Ng_data.csv"));
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
	    
	      
	       // Object programName = "fgd";
			// Send the POST request
	        Response response = RestAssured.given().contentType(ContentType.JSON)
	        		.pathParam("programName", GlobalVar.programName)
	              // .body(requestBody)
	                .put("https://lms-api-hackathon-june2023-930a8b0f895d.herokuapp.com/lms/program/{programName}");
	                		

	         System.out.println("Response code: " + response.getStatusCode());
	        System.out.println("Response body: " + response.getBody().asString());
	    }
	}

	@When("we send DELETE By invalid ID")
	public void we_send_delete_by_invalid_id() {
		{
			// Object programId = 123;
			Response res1 = given().pathParam("programId",GlobalVar.programId).when().
				  	 delete("https://lms-api-hackathon-june2023-930a8b0f895d.herokuapp.com/lms/deletebyprogid/{programId}");
				  	 res1.then().log().all();
				  // System.out.println(res1); 
		}

	}

	@When("we send url DELETE invalid Name")
	public void we_send_url_delete_invalid_name() {

		// Object programName = "abs";
		Response res1 = given().pathParam("programName", GlobalVar.programName).when().
			  	delete("https://lms-api-hackathon-june2023-930a8b0f895d.herokuapp.com/lms/deletebyprogname/{programName}");
			  	 res1.then().log().all();
	}



  

}
