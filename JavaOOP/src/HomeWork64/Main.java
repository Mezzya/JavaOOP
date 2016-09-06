package HomeWork64;


import java.io.File;
import java.io.FileOutputStream;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {

	public static void main(String[] args) {

		File fileTarget = new File("/home/mezz/Documents/OUT");
		File dir = new File("/home/mezz/Documents/IN");

//		Генерируем фалы в папке с заданным количеством и размером
		genFiles(fileTarget, 100, 1024*1024);
		System.out.println("Сгенерировали фалы для копирования");

		// Получим список фалов не включая дириктории. Лямда это весч ))
		File[] files = fileTarget.listFiles((a) -> !a.isDirectory());

		// Создадим пулл на 8 потока
		ExecutorService exec = Executors.newFixedThreadPool(8);

		ArrayList<Future<String>> result = new ArrayList<>();

		for (int i = 0; i < files.length; i++) {
			result.add(exec.submit(new FileCopy(files[i], dir)));
		}

		for (Future<String> list : result) {
			try {
				System.out.println( list.get());
			} catch (InterruptedException | ExecutionException e) {
				System.out.println(e);
			}
		}
		exec.shutdown();
		
		System.out.println("END");

	}

	public static void genFiles(File dir, int col, int size) {
//		Генератор файликов в папке
		for (int i = 0; i < col; i++) {

			File file = new File(dir.getAbsolutePath() + File.separator + i + ".txt");
			byte b=7;
			byte[] buffer = new byte[size];
			for (int j = 0; j < buffer.length; j++) {
				buffer[j]=b;
			}
			try(FileOutputStream fos = new FileOutputStream(file))
			{
				fos.write(buffer);
				fos.flush();
				
			} catch(IOException e)
			{
				System.out.println(e);
			}
			

		}

	}

}
