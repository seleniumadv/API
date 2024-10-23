package reqChaining;

import static io.restassured.RestAssured.given;

import java.util.Random;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojoclass.utility.PojoProject;

public class Scenario_1_Delete_Project {

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
		String projectID = resp.jsonPath().get("projectId");
		System.out.println(projectID);
		System.out.println();
		
		//API-2 Delete Project
			given()
				.delete("http://49.249.28.218:8091/project/"+projectID)
			.then()
				.log().all();
	}
}
