package Homework52;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class FindDublicate {

	private ArrayList<String> first = new ArrayList<>();
	private ArrayList<String> second = new ArrayList<>();
	
	public void load(File fileOne, File fileTwo) {
		
		loadFromFileToArray(fileOne, first);
		loadFromFileToArray(fileTwo, second);
		printArrays(first);
		printArrays(second);
		

	}

	public void loadFromFileToArray(File fileFrom, ArrayList<String> listTo) {

		try (BufferedReader bfOne = new BufferedReader(new FileReader(fileFrom))) {
			String s;
			String[] slova;
			while ((s = bfOne.readLine()) != null) {
				slova=s.split("[,;:.!?\\s]+");
				
				listTo.addAll(Arrays.asList(slova));
				
			}

		} catch (IOException e) {
			System.out.println(e);
		}

	}
	
	public void printArrays(ArrayList<String> list)
	{
		int i=0;
		
		System.out.println("START ");
		for (String string : list) {
			
			System.out.println(((i<10)?"0":"")+i+": "+string);
			i++;
		}
		System.out.println("END ");
		
		
		
		
		
		
	}

}
