package practice;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class SampleTestUsingMtdChainingTest {

	@Test
	public void getRequestTest() {
		//RestAssured.get("https://reqres.in/api/users?page=2").prettyPrint();
		
// If we make import as static then no need to call RestAssured mtd we can directly access.
		//get("https://reqres.in/api/users?page=2").prettyPrint();
		
		
//  If we using then() , log() ,all() instead of prettyPrint() then we will get the header and body as well
		get("https://reqres.in/api/users?page=2")
		.then()
		.log()
		.all();
		
	}
}
