package HomeWork104;

import java.io.File;

public class Main {
	public static void main(String[] args)
	{
	
		AsciiArt ascii = AsciiArt.loadFromFile(new File("ascii.txt"));
//		ascii.print('a');
		System.out.println();
		ascii.print("poll hunter");
		
		
		
		
	}
	
	
	
	
}
