package Lesson03;
import java.util.Arrays;
import java.util.Random;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] a = generateArray();
		int[] b = generateArray();
		int[] c = generateArray();

		System.out.println(Arrays.toString(a));
		System.out.println(Arrays.toString(b));
		System.out.println(Arrays.toString(c));
		System.out.println(getSum(a, b, c));

	}

	public static int[] generateArray() {
		Random rn = new Random();
		int[] array = new int[1 + rn.nextInt(5)];
		for (int i = 0; i < array.length; i++) {
			array[i] = rn.nextInt(10);
		}
		return array;

	}

	
public static int getSum(int[]... a) {

	
		for (int i = 0, j=0, sum=0; ; i++) {
			
			try{
				int temp=a[j][0];
			}
			catch (IndexOutOfBoundsException e)
			{
				System.out.println("Закочились масивы в масиве");
				return sum;
			}
			
			try {
				sum += a[j][i];
				
			} catch (IndexOutOfBoundsException e) {
				
				System.out.println("Конец масива №"+i);
				j++;
				i=-1;
			}

		}
	}


}
