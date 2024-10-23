package com.sample.crud.withBdd;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class SampleTestForPartialUpdateTest {

	@Test
	public void postDataToServer() {
		JSONObject jsonObj = new JSONObject();
			
			jsonObj.put("projectName", "DemoRA123");
		
			given()
				.contentType(ContentType.JSON)
				.body(jsonObj.toString())
			.when()
				.patch("http://49.249.28.218:8091/project/NH_PROJ_037")
			.then()
				.log().all();
	
	}
}
