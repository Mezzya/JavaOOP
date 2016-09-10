package HomeWork73;

import java.io.File;

public class SearchFile implements Runnable {

	private File dir;
	private String filename;
	private File[] dirs;

	

	public SearchFile() {
		super();
	}

	public SearchFile(File dir, String filename) {
		super();
		this.dir = dir;
		this.filename = filename;
	}

	@Override
	public void run() {

		dirs = dir.listFiles();

		for (File file : dirs) {
			if (file.isFile() && file.getName().equals(filename)) {
				// Нашли файлик
				System.out.println("Файл " + filename + " найден в " + dir);
			}

			if (file.isDirectory()) {
				// Ищем в директории
				new Thread(new SearchFile(file, filename)).start();

			}

		}

	}

}
