package HomeWork93;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

	public static void main(String[] args) {

		ArrayList<CharCount> list = new ArrayList<>();

		char[] buffer = new char[1024];
		long size = 0;
		File file = new File("e:\\big.txt");

		try (BufferedReader bf = new BufferedReader(new FileReader(file))) {
			int i = 0;

			while ((i = bf.read(buffer)) > 0) {

				for (int k = 0; k < i; k++) {
					char bukva = buffer[k];
					if (bukva == 10 || bukva == 13) {
						// Исключим символы перевод строки и конец файла
						size--;
					}

					if ((bukva >= 65 && bukva <= 90) || (bukva >= 97 && bukva <= 122)) {
						// Символ в диапазоне английского алфавита
						size++;
						CharCount temp = new CharCount(bukva);
						if (list.contains(temp)) {
							list.get(list.indexOf(temp)).inc();
						} else {
							list.add(temp);
						}

					}

				}

			}

		} catch (IOException e) {
			System.out.println(e);
		}
// 		Посчитаем относительную частоту
		for (CharCount cc : list) {
			cc.calcrelFrec(size);
		}

//		Отсортируем
		Collections.sort(list, (a, b) -> (int) (b.getRelFrec() - a.getRelFrec()));

//		Выведем результат
		System.out.printf("%n%5s%15s%15s%n", "Сивол", "Абс. частота", "Отн. частота");
		for (CharCount cc : list) {

			System.out.printf("%4s%12d%17.2f%n", cc.getBukva(), cc.getCount(), cc.getRelFrec());

		}
	}

}
