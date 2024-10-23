package pratice.PostRequestType;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import java.io.File;
import io.restassured.http.ContentType;


public class PostReq_via_JsonFileTest {

	@Test
	public void postDataToServer() {
		
		File fileObj = new File("./proj.json");
			
		given()
			.contentType(ContentType.JSON)
			.body(fileObj)
		.when()
			.post("http://49.249.28.218:8091/addProject")
		.then()
			.assertThat().statusCode(201)
			.log().all();
		}
}
