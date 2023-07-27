package api.utilities;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
public class prddTestcase {
	public static String requestBody;
	public static Response response;
	public static Response getall()
	{
         Response res=when().get("https://lms-api-hackathon-june2023-930a8b0f895d.herokuapp.com/lms/allPrograms").prettyPeek();
	
         return res;
}
	public static Response postcodereader() throws IOException, CsvException {
		CSVReader csvReader = new CSVReader(new FileReader("C:\\Users\\jayam\\eclipse-workspace\\API_cucumber\\src\\test\\resources\\Datafiles\\abd.csv"));
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
	        
	     
	
	
		Response response=RestAssured.given().auth().none().contentType(ContentType.JSON)
        .body(requestBody)
        .post("https://lms-api-hackathon-june2023-930a8b0f895d.herokuapp.com/lms/saveprogram");
		 //return response;
	}
		return response;	
	   
	}
}
