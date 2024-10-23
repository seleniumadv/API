package authTest;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class Pre_emptiveAuthTest3 {

	@Test
	public void sampleTest() {
		given()
			.auth().preemptive().basic("rmgyantra", "rmgy@9999")
			.log().all()
		.when()
			.get("http://49.249.28.218:8091/login")
		.then()
			.log().all();
			
	}
}
