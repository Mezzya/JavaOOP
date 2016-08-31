package Homework51;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Arrays;


public class FileManager {

	
	private FileManager() {
		super();
		// Нехочу чтобы создавался экземпляр класса
	}

	
	public static void copyMaskNio(File out, File in, String[] mask, boolean replase) throws IOException {
		
//		Счетчики количества фалов
		int copyCount = 0;
		int notCopyCount = 0;
	
//		Проверим параметры
		checkArguments(out, in);
		if (mask==null) throw new IllegalArgumentException("Маска null");
		
		File[] files = out.listFiles((name) -> {
			for (String m : mask) {

				if (name.getName().toLowerCase().endsWith("." + m.toLowerCase()))
					return true;

			}

			return false;
		});
		
		System.out.println("Копирование NIO " + Arrays.toString(mask) + " из " + out.getCanonicalPath() + " в "
				+ in.getCanonicalPath());
// 		Время старта всего процесса копирования
		long start = System.currentTimeMillis();
		
		for (File file : files) {

			try {
//				Время старта копирования каждого файла
				long fileStart = System.currentTimeMillis();
				
//				Проверим флаг перезаписи вайлов
				if (replase)
					Files.copy(file.toPath(), Paths.get(in.getAbsolutePath() + File.separator + file.getName()));
				else
					Files.copy(file.toPath(), Paths.get(in.getAbsolutePath() + File.separator + file.getName()),
							StandardCopyOption.REPLACE_EXISTING);
				copyCount++;

				System.out.println("Скопирован " + file + " " + (System.currentTimeMillis() - fileStart) + "мс");

			} catch (IOException e) {
				System.out.println("Не удалось скопировать " + file);
				notCopyCount++;
			}

		}
		

		printResult(copyCount, notCopyCount, System.currentTimeMillis() - start);

	}

	public static void copyMaskIo(File out, File in, String[] mask) throws IOException {
//		Счетчики количества фалов
		int copyCount = 0;
		int notCopyCount = 0;
//		Проверим параметры
		checkArguments(out, in);
		
		File[] files = out.listFiles((name) -> {
			for (String m : mask) {

				if (name.getName().toLowerCase().endsWith("." + m.toLowerCase()))
					return true;

			}

			return false;
		});
		
		System.out.println("Копирование IO " + Arrays.toString(mask) + " из " + out.getCanonicalPath() + " в "
				+ in.getCanonicalPath());
		
// 		Время старта всего процесса копирования
		long start = System.currentTimeMillis();
	
		for (File file : files) {

			try (FileInputStream fis = new FileInputStream(file);
					FileOutputStream fos = new FileOutputStream(
							new File(out.getAbsolutePath() + File.pathSeparator + file.getName()))) {
				byte[] buff = new byte[1024];
				int colRead = 0;
				
//				Время старта копирования каждого файла
				long fileStart = System.currentTimeMillis();

				while ((colRead = fis.read(buff)) > 0) {
					fos.write(buff, 0, colRead);
				}
				copyCount++;
				System.out.println("Скопирован " + file + " " + (System.currentTimeMillis() - fileStart) + "мс");

			} catch (IOException e) {
				System.out.println("Не удалось скопировать " + file);
				notCopyCount++;
			}

		}

		printResult(copyCount, notCopyCount, System.currentTimeMillis() - start);

	}

	private static void checkArguments(File dirOut, File dirIn) {
		// Проверим сущетвование дирикторий и то что это не файлы
		
		if (!dirOut.exists()) {
			throw new IllegalArgumentException(dirOut + " не существует");
		}
		
		if (!dirOut.isDirectory()) {
			throw new IllegalArgumentException(dirOut + " не директория");
		}

		if (!dirIn.exists()) {
			throw new IllegalArgumentException(dirIn + " не существует");
		}
		
		if (!dirIn.isDirectory()) {
			throw new IllegalArgumentException(dirIn + " не директория");
		}

	}

	private static void printResult(int copied, int notCopied, long time) {

		System.out.println();
		System.out.println("Скопировано " + copied + " файл(ов)");
		System.out.println("Не скопировано " + notCopied + " файл(ов)");
		System.out.println("Время копирования : " + time + " мс.");
		System.out.println();

	}
}
