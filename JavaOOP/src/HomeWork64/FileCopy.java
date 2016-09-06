package HomeWork64;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.concurrent.Callable;

public class FileCopy implements Callable<String> {

	private File fileTarget;
	private File folder;

	public FileCopy(File fileTarget, File folder) {
		super();
		this.fileTarget = fileTarget;
		this.folder = folder;
	}

	private void copy() throws IOException {
		// Проверяем пути

		if (!fileTarget.exists() || fileTarget.isDirectory())
			throw new IllegalArgumentException("Файл не существует или он папка");
		if (!folder.exists() || !folder.isDirectory())
			throw new IllegalArgumentException("Папка назначения не существует или не папка");

		// Копируем файл

		Files.copy(fileTarget.toPath(),
				Paths.get(folder.getAbsolutePath() + File.separator + Paths.get(fileTarget.getName())),
				StandardCopyOption.REPLACE_EXISTING);

	}

	@Override
	public String call() throws Exception {

		copy();
		return Thread.currentThread() + " Копирование " + fileTarget.getName();

	}

}
