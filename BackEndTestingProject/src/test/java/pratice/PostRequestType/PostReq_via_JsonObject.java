package pratice.PostRequestType;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;


public class PostReq_via_JsonObject {

	@Test
	public void postDataToServer() {
		JSONObject jsonObj = new JSONObject();
		
			jsonObj.put("createdBy", "pranav");
			jsonObj.put("projectName", "DemoRA12");
			jsonObj.put("status", "Created");
			jsonObj.put("teamSize", 0);
			
		given()
			.contentType(ContentType.JSON)
			.body(jsonObj.toJSONString())
		.when()
			.post("http://49.249.28.218:8091/addProject")
		.then()
			.assertThat().statusCode(201)
			.log().all();
		}
}
