package reqChaining;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

import io.restassured.response.Response;

public class Scenario_3_getPayRollInfo {

	@Test
	public void sampleTest() {

		//API-1 get Auth API-1
		Response resp = given()
						.formParam("client_id", "ninza-client")
						.formParam("client_secret", "gPQBf1Yxew5OMccMhzos1GefIyiSnXzM")
						.formParam("grant_type", "client_credentials")
					.when()
						.post("http://49.249.28.218:8180/auth/realms/ninza/protocol/openid-connect/token");
					resp.then()
						.log().all();
					
		// Capture the Token from the Response
					String token = resp.jsonPath().get("access_token");
		
		// API-2 Get Payroll Info
				given()
					.auth().oauth2(token)
					.get("http://49.249.28.218:8091/admin/payrolls")
				.then()
					.log().all();
	}
}
