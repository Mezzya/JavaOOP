package Homework51;

import java.io.File;
import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

		File dirOut = new File("/home/mezz/Documents/OUT");
		File dirIn = new File("/home/mezz/Documents/IN");

		String[] arg = { "txt", "bmp", "jpg" };

		try {

			FileManager.copyMaskNio(dirOut, dirIn, arg, false);
			FileManager.copyMaskIo(dirOut, dirIn, arg);

		} catch (IOException e) {
			System.out.println(e);
		}
		
		System.out.println(File.separator);

	}

}
