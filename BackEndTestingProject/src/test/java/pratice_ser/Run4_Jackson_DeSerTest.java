package pratice_ser;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Run4_Jackson_DeSerTest {
	
	public static void main(String[] args) throws Exception{
		
		ObjectMapper obj = new ObjectMapper();
		
		Project pObj = obj.readValue(new File("./project.json"), Project.class); //Converting into Json to javaObject
		
		System.out.println(pObj.getProjectName());
		System.out.println(pObj.getCreatedBy());
		System.out.println(pObj.getStatus());
		System.out.println(pObj.getTeamSize());
	}

}
