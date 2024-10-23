package reqChaining;

import static io.restassured.RestAssured.given;

import java.util.Random;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojoclass.utility.EmployeePojo;
import pojoclass.utility.PojoProject;

public class Scenario_2_AddEmployeeToProject {

	@Test
	public void postDataToServer() {
		
		//Create an Object to Pojo class
		Random random = new Random();
		int rannum = random.nextInt(5000);
		
		//API-1 ==> Add a Project in side server
		PojoProject pObj = new PojoProject("HRM_D_RA_"+rannum, "Created", "Pranav", 0);
		
		Response resp = given()
			.contentType(ContentType.JSON)
			.body(pObj)
		.when()
			.post("http://49.249.28.218:8091/addProject");
		resp.then()
			.assertThat().statusCode(201)
			.log().all();
		
		// Capture project name from the response
		String projectName = resp.jsonPath().get("projectName");
		System.out.println(projectName);
		System.out.println();
		
		//API-2 ==> Add Employee to same Project
		
		EmployeePojo empObj = new EmployeePojo("Software Engg", "08/04/1998", "apidemoproject@gmail.com", "Petter_"+rannum, 4,
				"9856741325", projectName , "ROLE_EMPLOYEE", "Petter@_"+rannum);
				given()
					.contentType(ContentType.JSON)
					.body(empObj)
				.when()
					.post("http://49.249.28.218:8091/employees")
				.then()
					.assertThat().statusCode(201)
					.log().all();
		
		
		
	}
}
