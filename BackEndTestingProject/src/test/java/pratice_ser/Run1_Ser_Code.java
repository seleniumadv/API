   package pratice_ser;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class NFSGame implements Serializable{
	String name;
	int level;
	long score; 
	int life;
	public NFSGame(String name, int level, long score, int life) {
		super();
		this.name = name;
		this.level = level;
		this.score = score;
		this.life = life;
	}
}

public class Run1_Ser_Code {

	public static void main(String[] args) throws Exception {
		NFSGame userObj = new NFSGame("pranav", 10, 50000, 2);
		FileOutputStream fos = new FileOutputStream("./NFS.txt");
		
		ObjectOutputStream objOut = new ObjectOutputStream(fos);
		objOut.writeObject(userObj);
		System.out.println("====END====");
	}
}
