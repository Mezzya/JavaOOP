package Homework61;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = new int[1000000];
		
		
		for (int i = 0; i < array.length; i++) {
			array[i]=i;
		}
		
		int sum=0;
		
		long start= System.currentTimeMillis();
		for (int i = 0; i < array.length; i++) {
			sum+=array[i];
		}
		long end= System.currentTimeMillis();
		
		System.out.println("Реультат ="+sum);
		System.out.println("Время выполнения "+(end-start)+"мс.");
//		
		
		SumTread sumOne = new SumTread(10,20);
		Thread  trOne = new Thread(sumOne);
		
		System.out.println("Start x="+sumOne.start);
		trOne.start();
		try{
			trOne.join();	
		} catch (Exception e) {
			System.out.println(e);
		}
		
		System.out.println("End x="+sumOne.start);
		System.out.println(trOne.isAlive()+" "+trOne.getName());
		
	}
	
	
}
