package HomeWork73;

import java.io.File;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		new Thread(new SearchFile(new File("/home/mezz/Documents/OUT"), "test.txt")).start();
		

	}

}
