package HomeWork91;

import java.util.Random;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MyArrayList<String> mylist = new MyArrayList<>();

		for (int i = 0; i < 10; i++) {
			mylist.add(new String("Text " + (i + 1)));
		}
		System.out.println(mylist);
		mylist.delThoFirstAndLast();

		System.out.println(mylist);

		MyArrayList<Integer> mylistInt = new MyArrayList<>();
		for (int i = 0; i < 10; i++) {
			mylistInt.add(new Random().nextInt(10));
		}

		System.out.println(mylistInt);
		mylistInt.delThoFirstAndLast();

		System.out.println(mylistInt);

	}

}
