package Homework52;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class FindDublicate {

	private static HashSet<String> set = new HashSet<>();

	

	private FindDublicate() {
		super();
		// Не надо меня создавать
	}

	public static void findAndWrite(File fileOne, File fileTwo, File fileResult) {

		try (BufferedReader bfOne = new BufferedReader(new FileReader(fileOne));
				BufferedReader bfTwo = new BufferedReader(new FileReader(fileTwo));
				BufferedWriter bfResult = new BufferedWriter(new FileWriter(fileResult))) {
			String s;
			// Считаем из первого файла в set
			String[] slova;

			while ((s = bfOne.readLine()) != null) {
				slova = s.split("[-,;:.!?\\s]+");

				set.addAll(Arrays.asList(slova));

			}
//			Можем вывести на экран сет для себя
			printSet(set);

			// Читаем из второго проверяем наличие в сете и записываем в result

			while ((s = bfTwo.readLine()) != null) {
				slova = s.split("[-,;:.!?\\s]+");

				for (int i = 0; i < slova.length; i++) {
					if (set.contains(slova[i])) {
						// Есть вхождение. запишем
						bfResult.write(slova[i]);
						bfResult.newLine();
					}
				}

			}
			bfResult.flush();

		} catch (IOException e) {
			System.out.println(e);
		}

	}

	private static void printSet(HashSet<String> set) {
		int i = 0;

		System.out.println("START ");
		for (String string : set) {

			System.out.println(((i < 10) ? "0" : "") + i + ": " + string);
			i++;
		}
		System.out.println("END ");

	}

}
