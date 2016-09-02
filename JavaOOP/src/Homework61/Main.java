package Homework61;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = new int[7];

		for (int i = 0; i < array.length; i++) {
			array[i] = i;
		}

		int sum = 0;

		long start = System.currentTimeMillis();
		for (int i = 0; i < array.length; i++) {
			sum += array[i];
		}
		long end = System.currentTimeMillis();

		System.out.println("Реультат =" + sum);
		System.out.println("Время выполнения " + (end - start) + "мс.");
		//

		int threadCont = 4; // Количество потоков
		SumTread[] sumTreads = new SumTread[threadCont];

		int z = array.length / threadCont;
		int k = array.length % threadCont;

		System.out.println("z=" + z + " k=" + k);

		
		
		
		
	}

}
