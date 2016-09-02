package Homework52;

import java.io.File;


public class Main {

	

public static void main(String[] args)
{

	File fileOne = new File("/home/mezz/Documents/IN/fileone.txt");
	File fileTwo = new File("/home/mezz/Documents/IN/filetwo.txt");
	File fileResult = new File("/home/mezz/Documents/IN/result.txt");
	
	
	FindDublicate.findAndWrite(fileOne, fileTwo, fileResult);
	

}
	
	
}
