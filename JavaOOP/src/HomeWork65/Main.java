package HomeWork65;

import java.io.File;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Thread trOne = new Thread(new CheckFolder(new File("/home/mezz/Documents/IN2")));
		trOne.start();
		try {
			trOne.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
