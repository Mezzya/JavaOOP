package HomeWorkStream03;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String string = "Hello, Java";


		int[] mas = string.chars()
				.map(x -> new Integer(x))
				.toArray();

		System.out.println(Arrays.toString(mas));
	}

}
