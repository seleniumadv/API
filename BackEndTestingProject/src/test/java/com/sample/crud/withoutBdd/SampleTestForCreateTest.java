package com.sample.crud.withoutBdd;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class SampleTestForCreateTest {

	@Test
	public void postDataToServer() {
		JSONObject jsonObj = new JSONObject();
			jsonObj.put("createdBy", "pranav");
			jsonObj.put("projectName", "DemoRA01");
			jsonObj.put("status", "Created");
			jsonObj.put("teamSize", 0);
		
		RequestSpecification req = RestAssured.given();
		req.contentType(ContentType.JSON);
		req.body(jsonObj.toJSONString());
		
		
		
	Response resp =	req.post("http://49.249.28.218:8091/addProject");
	//System.out.println(resp.prettyPrint());
	resp.then().assertThat().statusCode(201);
	resp.then().log().all();
	
	}
}
