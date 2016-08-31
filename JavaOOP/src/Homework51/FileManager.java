package Homework51;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Arrays;
import java.util.Date;

public class FileManager {

	public void copyMaskNio(File out, File in, String[] mask, boolean replase) throws IOException {

		int copyCount = 0;
		int notCopyCount = 0;
		// Лямбдачка
		File[] files = out.listFiles((name) -> {
			for (String m : mask) {

				if (name.getName().toLowerCase().endsWith("." + m.toLowerCase()))
					return true;

			}

			return false;
		});
		System.out.println("Копирование NIO " + Arrays.toString(mask) + " из " + out.getCanonicalPath() + " в "
				+ in.getCanonicalPath());

		Date start = new Date();
		for (File file : files) {

			try {
				if (replase)
					Files.copy(file.toPath(), Paths.get(in.getAbsolutePath() + File.separator + file.getName()));
				else
					Files.copy(file.toPath(), Paths.get(in.getAbsolutePath() + File.separator + file.getName()),
							StandardCopyOption.REPLACE_EXISTING);
				copyCount++;
				System.out.println("Скопирован " + file);

			} catch (IOException e) {
				System.out.println("Не удалось скопировать " + file);
				notCopyCount++;
			}

		}
		Date end = new Date();

		printResult(copyCount, notCopyCount, end.getTime() - start.getTime());

	}

	public void copyMaskIo(File out, File in, String[] mask) throws IOException {

		int copyCount = 0;
		int notCopyCount = 0;

		// Лямбдачка
		File[] files = out.listFiles((name) -> {
			for (String m : mask) {

				if (name.getName().toLowerCase().endsWith("." + m.toLowerCase()))
					return true;

			}

			return false;
		});
		System.out.println("Копирование IO " + Arrays.toString(mask) + " из " + out.getCanonicalPath() + " в "
				+ in.getCanonicalPath());
		Date start = new Date();
		for (File file : files) {

			try (FileInputStream fis = new FileInputStream(file);
					FileOutputStream fos = new FileOutputStream(
							new File(out.getAbsolutePath() + File.pathSeparator + file.getName()))) {
				byte[] buff = new byte[1024];
				int colRead = 0;

				while ((colRead = fis.read(buff)) > 0) {
					fos.write(buff, 0, colRead);
				}
				copyCount++;
				System.out.println("Скопирован " + file);

			} catch (IOException e) {
				System.out.println("Не удалось скопировать " + file);
				notCopyCount++;
			}

		}
		
		Date end = new Date();

		printResult(copyCount, notCopyCount, end.getTime() - start.getTime());
		
	}

	
	private void printResult(int copied, int notCopied, long time) {
	
		System.out.println();
		System.out.println("Скопировано " + copied + " файл(ов)");
		System.out.println("Не скопировано " + notCopied + " файл(ов)");
		System.out.println("Время копирования : " + time + " мс.");
		System.out.println();

	}
}
