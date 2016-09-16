package HomeWorkStream04;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {

			int max = Files.lines(Paths.get("d:\\stream.txt"))
					.mapToInt(x -> Integer.parseInt(x))
					.max()
					.orElse(0);
			System.out.println(max);

		} catch (IOException e) {
			System.out.println(e);
		}

	}

}
