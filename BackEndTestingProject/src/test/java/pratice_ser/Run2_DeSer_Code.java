package pratice_ser;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class Run2_DeSer_Code {

	
	public static void main(String[] args) throws Exception {
		FileInputStream fis = new FileInputStream("./NFS.txt");
		
		ObjectInputStream objIn = new ObjectInputStream(fis);
		NFSGame userObj = (NFSGame) objIn.readObject();
	
	System.out.println(userObj.name);
	System.out.println(userObj.level);
	System.out.println(userObj.score);
	System.out.println(userObj.life);
	
	}
}
