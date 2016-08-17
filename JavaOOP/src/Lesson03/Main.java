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
		int[] array = new int[5 + rn.nextInt(11)];
		for (int i = 0; i < array.length; i++) {
			array[i] = rn.nextInt(10);
		}
		return array;

	}

	
public static int getSum(int[] a, int[] b, int[] c) {

		for (int i = 0, j = 0, sum = 0;; i++) {
			try {
				sum += a[i];
			} catch (IndexOutOfBoundsException e) {
				System.out.println("Количество " + i);

				if (j == 2) {

					return sum;
				}

				if (j == 1) {
					j++;
					a = c;
				}
				if (j == 0) {
					a = b;
					j++;

				}
				i = -1;

			}

		}
	}


}
