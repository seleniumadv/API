package pratice.PostRequestType;

import org.testng.annotations.Test;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.*;
import java.util.Random;
import pojoclass.utility.PojoProject;

public class PostReq_via_PojoClass {

	@Test
	public void postDataToServer() {
		
		//Create an Object to Pojo class
		Random random = new Random();
		int rannum = random.nextInt(5000);
		PojoProject pObj = new PojoProject("DemoPC_RA_"+rannum, "Created", "Pranav", 0);
		
		given()
			.contentType(ContentType.JSON)
			.body(pObj)
		.when()
			.post("http://49.249.28.218:8091/addProject")
		.then()
			.assertThat().statusCode(201)
			.log().all();
	}
}
