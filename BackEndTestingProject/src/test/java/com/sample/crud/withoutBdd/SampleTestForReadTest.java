package com.sample.crud.withoutBdd;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class SampleTestForReadTest {

	@Test
	public void getDataFromServer() {
	Response resp =	RestAssured.delete("http://49.249.28.218:8091/project/NH_PROJ_031");
	//System.out.println(resp.prettyPrint());
	
	resp.then().assertThat().statusCode(204);
	  
	resp.then().log().all();
	
	}
}
