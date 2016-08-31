package Homework51;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.sql.Time;
import java.util.Arrays;
import java.util.Date;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		File dirOut = new File("DIROUT");
		File dirIn = new File("DIRIN");

		// Проверим сущетвование дирикторий и то что это не файлы
		if (!dirOut.exists()) {
			System.err.println(dirOut + " не существует");
			return;
		}
		if (!dirOut.isDirectory()) {
			System.err.println(dirOut + " не директория");
			return;
		}

		if (!dirIn.exists()) {
			System.err.println(dirIn + " не существует");
			return;
		}
		if (!dirIn.isDirectory()) {
			System.err.println(dirIn + " не директория");
			return;
		}


		FileManager fm = new FileManager();
		String[] arg = { "txt", "bmp", "jpg" };
		try {
		
			fm.copyMaskNio(dirOut, dirIn, arg, false);
			
		
			
			fm.copyMaskIo(dirOut, dirIn, arg);
			
			
			
		} catch (IOException e) {
			System.out.println(e);
		}

		
		
	}

}
