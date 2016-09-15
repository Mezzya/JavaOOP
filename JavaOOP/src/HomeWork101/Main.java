package HomeWork101;

import java.io.File;

public class Main {

	public static void main(String[] args) {

		// Загружаем словарь из файла
		Slovar slovar = Slovar.load();

		// Создаем переводчик со словарем
		EngToUkr etu = new EngToUkr(slovar);

		// Переведем файл
		etu.translate(new File("d:\\java\\trans\\english.in"), new File("d:\\java\\trans\\ukrainian.out"));

		// Можем вывести словарь на экран
		slovar.print();
		// Можем добавить новые слова

		slovar.add("hello", "привіт");
		slovar.add("my", "моя");
		slovar.add("i", "я");
		slovar.add("live", "живу");

		
		// Не забываем сохранить словарь в файл
		slovar.save();

	}

}
