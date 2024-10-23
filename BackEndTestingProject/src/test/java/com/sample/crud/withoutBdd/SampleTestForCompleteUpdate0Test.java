package com.sample.crud.withoutBdd;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class SampleTestForCompleteUpdate0Test {

	@Test
	public void postDataToServer() {
		JSONObject jsonObj = new JSONObject();
			jsonObj.put("createdBy", "pranav");
			jsonObj.put("projectName", "DemoRA12");
			jsonObj.put("status", "Created");
			jsonObj.put("teamSize", 0);
		
		RequestSpecification req = RestAssured.given();
		req.contentType(ContentType.JSON);
		req.body(jsonObj.toJSONString());
		
		
		
	Response resp =	req.put("http://49.249.28.218:8091/project/NH_PROJ_031");
	//System.out.println(resp.prettyPrint());
	resp.then().assertThat().statusCode(200);
	resp.then().log().all();
	
	}
}
