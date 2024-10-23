package practice;

import org.testng.annotations.Test;

import com.backend.testing.chain_NS_demoA;

public class RunNS2 {

	@Test
	public void sampleTest() {
		chain_NS_demoA c = new chain_NS_demoA();
		c.a().b().c().d();
	}
}
