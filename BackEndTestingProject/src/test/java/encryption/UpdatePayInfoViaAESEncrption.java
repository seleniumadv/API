package encryption;

import org.testng.annotations.Test;

import encryption.utility.EncryptAndDecryptUtility;
import static io.restassured.RestAssured.*;
import io.restassured.response.Response;

public class UpdatePayInfoViaAESEncrption {

	@Test
	public void sampleTest() throws Exception {
		String privateKey = "AcO3tEam@j!tu_#1";
		EncryptAndDecryptUtility ed = new EncryptAndDecryptUtility();
		
		String jbody = "{{ \"employee\": { \"empId\":\"NH_00026\", \"designation\": \"Software Engg\", \"dob\": \"12/05/1998\", \"email\": \"Ratp125@gmail.com\","
				+ " \"empName\": \"Petter\", \"experience\": 4," + " \"mobileNo\": \"7124589635\", \"project\": \"DemoRA\", \"role\": \"QE\","
						+ " \"username\": “Petter@123” }, \"basicPlusVda\": 0, \"hra\": 3000, \"insurance\": 5200, \"lta\": 5000, \"lwf\": 5000,"
						+ " \"netPay\": 5000, \"payroll_id\": 5000, \"pf\": 2500, \"pt\": 3000, \"stat_bonus\": 5000, \"status\": “Active” }}";
	
		String jReqBody = ed.encrypt(jbody, privateKey);
		System.out.println(jReqBody);
		
		Response res = given()
							.body(jReqBody)
					   .when()
					   		.put("http://49.249.28.218:8091/payroll");
						res.then()
							.log().all();
						
		String respBody = ed.decrypt(res.getBody().asString(), privateKey);
		System.out.println(respBody);
	}
}
