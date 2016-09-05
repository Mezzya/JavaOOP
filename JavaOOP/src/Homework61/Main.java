package Homework61;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = new int[20];

		for (int i = 0; i < array.length; i++) {
			array[i] = i;
		}

		int sum = 0;

		long startTime = System.currentTimeMillis();
		for (int i = 0; i < array.length; i++) {
			sum += array[i];
		}
		long endTime = System.currentTimeMillis();

		System.out.println("Реультат =" + sum);
		System.out.println("Время выполнения " + (endTime - startTime) + "мс.");
		//

		int threadCont = 4; // Количество потоков
		SumTread[] sumTreads = new SumTread[threadCont];

		int size = array.length / threadCont;
		
		int pos=0;
		while ((pos+size)<array.length)
		{
			System.out.println("sart=" + pos + " end=" + (pos+=size));
			pos+=1;
		}
		System.out.println("sart=" + (pos+1) + " end=" + array.length);
		
	
		
		
			
						
			
			
			


		
		
		
		
		
		
		
//		System.out.println("z=" + z + " k=" + k);

		
		
		
		
	}

}
