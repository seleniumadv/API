package practice.responseValidation;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

import io.restassured.response.Response;

public class VerifyResponseTimeTest {

	@Test
	public void verifyResponseTime() {
		
		Response res = given()
				.get("http://49.249.28.218:8091/projects");
			res.then().log().all();
			
		long timeTaken = res.time();
		long timeTakenSec = res.timeIn(TimeUnit.SECONDS);
		
		System.out.println(timeTaken);
		System.out.println(timeTakenSec);
		
		//res.then().assertThat().time(Matchers.lessThan(900L));
		
		//res.then().assertThat().time(Matchers.greaterThan(300L));
		
		res.then().assertThat().time(Matchers.both(Matchers.lessThan(900L)).and(Matchers.greaterThan(300L)));
	}
	
}
