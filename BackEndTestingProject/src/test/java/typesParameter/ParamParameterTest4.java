package typesParameter;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class ParamParameterTest4 {

	@Test
	public void sampleTest() {
		given()
			.param("teamSize", 0)
			.log().all()
		.when()
			.post("http://49.249.28.218:8091/project")
		.then()
			.log().all();
	}
}
