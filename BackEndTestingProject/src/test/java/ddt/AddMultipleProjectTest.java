package ddt;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import excel.utility.ExcelUtility;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class AddMultipleProjectTest {

	@Test(dataProvider = "getData")
	public void sampleTest(String pName , String status) {
		
		String reqBody = "{\r\n"
				+ "  \"createdBy\": \"Pranav\",\r\n"
				+ "  \"projectName\": \""+pName+"\",\r\n"
				+ "  \"status\":\""+status+"\",\r\n"
				+ "  \"teamSize\": 0\r\n"
				+ "}";
		
		given()
			.contentType(ContentType.JSON)
			.body(reqBody)
		.when()
			.post("http://49.249.28.218:8091/addProject")
		.then()
			.log().all();
	}
	
	@DataProvider
	public Object[][] getData() throws Exception{
		ExcelUtility elib = new ExcelUtility();
		int count = elib.getRowCount("cData");
		Object[][] objarr = new Object[count][2];
		/*
		 * objarr[0][0] = "Avenger_2"; objarr[0][1] = "Created";
		 * 
		 * objarr[1][0] = "Avenger_3"; objarr[1][1] = "Created";
		 * 
		 * objarr[2][0] = "Avenger_4"; objarr[2][1] = "Created";
		 */
		
		for(int i=0; i<count; i++) {
			objarr[i][0] = elib.getDataFromExcel("cData", i+1, 0);
			objarr[i][1] = elib.getDataFromExcel("cData", i+1, 1);
		}
		return objarr;
	}
}
