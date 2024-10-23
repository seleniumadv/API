package practice.responseValidation;

import static io.restassured.RestAssured.*;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.jayway.jsonpath.JsonPath;

import io.restassured.response.Response;

public class VerifyData_ComplexJsonxpath {

	@Test
	public void sampleTest() {
		Response res = given()
				.get("http://49.249.28.218:8091/projects-paginated");
	//	res.then().log().all();
	
		List<String> lst = JsonPath.read(res.asString(), ".content[*].projectName");
		//System.out.println(lst);
		for (String data : lst) {
			System.out.println(data);
		}
		
		List<String> list = JsonPath.read(res.asString(), ".content[*].[?(@.projectName=='tp126')].projectId");
		String actProjectId = list.get(0);
		
		Assert.assertEquals(actProjectId, "NH_PROJ_164");
		
	}
}
