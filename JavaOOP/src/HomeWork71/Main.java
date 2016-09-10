package HomeWork71;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random random = new Random();
		int colDocksInPort = 10; // Задаем количество доков в порту
		int colShips = 1000; // Задаем количество кораблей
		int colReqestsShips = 30; // количество кораблей запрашиваемых порт

		
		ExecutorService es = Executors.newFixedThreadPool(colReqestsShips);
		Dock[] docks = new Dock[colDocksInPort];
		for (int i = 0; i < colDocksInPort; i++) {
			docks[i] = new Dock(i);
		}
		System.out.println(Arrays.toString(docks));
		// Создадим порт
		Port port = new Port(docks);

		// ЗАпустим корабликик потоки
		for (int i = 0; i < colShips; i++) {
			es.submit(new Ship(i, random.nextInt(5) + 5, port));
		}

		// Не забываем закрывать екзекутер
		es.shutdown();

	}

}
