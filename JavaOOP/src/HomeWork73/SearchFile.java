package HomeWork73;

import java.io.File;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class SearchFile implements Callable<String> {

	private File dir;
	private String filename;
	private File[] dirs;
	private ExecutorService exec;
	private ArrayList<Future<String>> result = new ArrayList<>();

	public SearchFile() {
		super();
	}

	public SearchFile(File dir, String filename, ExecutorService exec) {
		super();
		this.dir = dir;
		this.filename = filename;
		this.exec = exec;
	}

	
	@Override
	public String call() {

		dirs = dir.listFiles();
		for (File file : dirs) {
			if (file.isFile() && file.getName().equals(filename)) {
				// Нашли файлик
				return "Файл " + filename + " найден в " + dir;
			}

			if (file.isDirectory()) {
				// Ищем в директории
				result.add(exec.submit(new SearchFile(file, filename, exec)));
			}

		}

		for (Future<String> res : result) {
			String tmp = "";
			try {
				tmp = res.get();
			} catch (InterruptedException e) {
		
				e.printStackTrace();
			} catch (ExecutionException e) {
				
				e.printStackTrace();
			}
			if (tmp != null)
				System.out.println(tmp);
		}
		return null;

	}

}
