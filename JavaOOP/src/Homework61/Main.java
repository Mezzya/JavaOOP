package Homework61;

import java.io.IOException;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = new int[10];

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
		sum=0;

		int threadCont = 5; // Количество потоков
		SumTread[] sumTreads = new SumTread[threadCont];

		int size = array.length / threadCont;
		
		int pos=0;
		int count=0;
		startTime = System.currentTimeMillis();
		while ((pos+size)<array.length)
		{
//			System.out.println("sart=" + pos + " end=" + (pos+=size));
			sumTreads[count]=new SumTread(pos, pos+=size, array);
			sumTreads[count].getTr().start();
			pos+=1;
			count++;
		}
		
		sumTreads[count]=new SumTread(pos, array.length-1, array);
		sumTreads[count].getTr().start();
		
		for (int i = 0; i < sumTreads.length; i++) {
			try{
				sumTreads[i].getTr().join();		
			} catch(InterruptedException e)
			{
				System.out.println(e);
			}
			
		
		}
		
		
		for (int i = 0; i < sumTreads.length; i++) {
			
			sum+=sumTreads[i].getSum();
		}
		endTime = System.currentTimeMillis();
		
//		System.out.println("sart=" + (pos) + " end=" + (array.length-1));
		

	
		System.out.println("Реультат с потоками =" + sum);
		System.out.println("Время выполнения потоками " + (endTime - startTime) + "мс.");
		
//		System.out.println("sart=" + (pos+1) + " end=" + array.length);
			
						
			
			
			


		
		
		
		
		
		
		
//		System.out.println("z=" + z + " k=" + k);

		
		
		
		
	}

}
