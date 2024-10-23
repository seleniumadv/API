package panCardMock;

import org.mockito.Mockito;
import org.testng.Assert;

class PanCard {
	public String isvalid(String panCard) {
		if(panCard.matches("[A-Z]{5}[0-9]{4}[A-Z]{1}")==true) {
			return "is valid PanCard";
		}
		else {
			return "is invalid Pancard";
		}
	}
	
	public static PanCard getMockObject() {
		PanCard mocObj = Mockito.mock(PanCard.class);
				Mockito.when(mocObj.isvalid("ABCDE1254Z")).thenReturn("valid PAN Card");
				Mockito.when(mocObj.isvalid("ABCDE1254Y")).thenReturn("valid PAN Card");
				Mockito.when(mocObj.isvalid("ABCDE1254F")).thenReturn("Invalid PAN Card");
		return mocObj;
		
	}
}
public class MockingTest {

	public static void main(String[] args) {
		PanCard Obj = PanCard.getMockObject();
		Assert.assertEquals(Obj.isvalid("ABCDE1254H"), "valid PAN Card");
		//System.out.println(Obj.isvalid("ABCDE1254K"));
	}
}
