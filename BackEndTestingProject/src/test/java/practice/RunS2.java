package practice;

import org.testng.annotations.Test;

import static com.backend.testing.chain_S_demoA1.*;


public class RunS2 {

	@Test
	public void sampleTest() {
		a().b().c().d();
	}
}
