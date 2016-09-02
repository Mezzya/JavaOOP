package Homework52;

import java.io.File;


public class Main {

	

public static void main(String[] args)
{

	File fileOne = new File("d:\\temp\\fileone.txt");
	File fileTwo = new File("d:\\temp\\filetwo.txt");
	FindDublicate fd = new FindDublicate();
	
	fd.load(fileOne, fileTwo);
	

}
	
	
}
