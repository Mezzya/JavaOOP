package HomeWork73;

import java.io.File;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ExecutorService exec = Executors.newCachedThreadPool();

		String tmp = "";

		try {
			if ((tmp = exec.submit(new SearchFile(new File("/home/mezz/Documents/OUT"), "test.txt", exec))
					.get()) != null) {
				System.out.println(tmp);
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
