package Homework61;

import java.io.IOException;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Random;

public class Main {
	static int[] array = new int[100000000];
	static int threadCount;
	static BigInteger sum;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		randomFillArray();
		oneThreadSum();

		int threadCount = 16; // Количество потоков

		multThreadSum();

		//

	}

	static void randomFillArray() {
		
		Random r = new Random();
		for (int i = 0; i < array.length; i++) {
			array[i] = r.nextInt(100)*10000;
		}

	}

	static void oneThreadSum() {
		sum = new BigInteger("0");

		long startTime = System.currentTimeMillis();
		for (int i = 0; i < array.length; i++) {
			sum=sum.add(new BigInteger(""+array[i]));
			
		}
		long endTime = System.currentTimeMillis();

		System.out.println("Реультат =" + sum.toString());
		System.out.println("Время выполнения " + (endTime - startTime) + "мс.");
	}

	static void multThreadSum() {
		
		sum = new BigInteger("0");

		int threadCount = 16;
		SumTread[] sumTreads = new SumTread[threadCount];

		int size = array.length / threadCount;

		System.out.println("");
		System.out.println("Размер блока=" + size);

		if (size < 2)
			throw new IllegalArgumentException("Диапазон разбития меньше двух элементов");

		// Разбиваем на диапазон на количество потоков и создаем их и запускаем
		int start = 0;
		int end = 0;
		long startTime = System.currentTimeMillis();

		for (int i = 0; i < threadCount; i++) {
			if (i == 0) {
				start = 0;
				end += size + (array.length % threadCount - 1);
			} else {
				start = end + 1;
				end += size;
			}

			// System.out.println("start="+start+" end="+end);
			sumTreads[i] = new SumTread(start, end, array);
			sumTreads[i].getTr().start();
		}

		// Ждем мейнов все потоки
		for (int i = 0; i < sumTreads.length; i++) {
			try {
				sumTreads[i].getTr().join();
			} catch (InterruptedException e) {
				System.out.println(e);
			}

		}

		// Посчет результатов и вывод
		for (int i = 0; i < sumTreads.length; i++) {

			sum = sum.add(sumTreads[i].getSum());
		}
		long endTime = System.currentTimeMillis();

		System.out.println("Реультат с потоками =" + sum);
		System.out.println("Время выполнения потоками " + (endTime - startTime) + "мс.");

	}

}
