package encryption;

import org.testng.annotations.Test;

import encryption.utility.EncryptAndDecryptUtility;

public class AESEnpTest {

	@Test
	public void sampleTest() throws Exception {
		
		String privateKey = "AcO3tEam@j!tu_#1";
		String data = "{\"name\" : \"pranav\" , \"id\" : \"tp-04\"}";
		
		EncryptAndDecryptUtility ed = new EncryptAndDecryptUtility();
		String encode = ed.encrypt(data, privateKey);
		System.out.println(encode);
		
		System.out.println(ed.decrypt(encode, privateKey));
	}
}
