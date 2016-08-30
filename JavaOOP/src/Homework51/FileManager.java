package Homework51;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.file.CopyOption;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Arrays;

import javax.sound.midi.Patch;

public class FileManager {

	private class Filter implements FilenameFilter {
		private String[] mask;

		public Filter() {
			super();
		}

		public Filter(String[] mask) {
			super();
			this.mask = mask;
		}

		public String[] getMask() {
			return mask;
		}

		@Override
		public boolean accept(File dir, String name) {
			// TODO Auto-generated method stub
			String lname = name.toLowerCase();

			for (String m : mask) {

				if (name.endsWith("." + m)) {
					// Содержит такое расширение
					return true;
				}
			}

			return false;
		}

	}

	public void copyMaskNio(File out, File in, String[] mask, boolean replase) throws IOException {
		File[] files = out.listFiles(new Filter(mask));

		System.out.println(Arrays.toString(files));

		// Копируем

//		System.out.println("Источник :" + out + " Путь " + out.toPath());
//		System.out.println("Получатель :" + in + " Путь " + in.toPath());
//
//		System.out.println("Что копировать :" + File.separator + out.getName());
			int copyCount=0;
			int notCopyCount=0;
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
		System.out.println();
		System.out.println("Скопировано "+copyCount+" файл(ов)");
		System.out.println("Не скопировано "+notCopyCount+" файл(ов)");
		

	}

}
