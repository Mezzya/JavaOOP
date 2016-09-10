package HomeWork72;

import java.io.File;

class Main {

	public static void main(String[] args) {
		File fileFrom = new File("/home/mezz/Documents/OUT/win7.iso");
		File fileTo = new File("/home/mezz/Documents/IN/");

		FileCopy fc = new FileCopy(fileFrom, fileTo);
		Thread trTwo = new Thread(new StatusBar(fc));
		Thread trOne = new Thread(fc);
		trOne.start();
		trTwo.start();

	}

}
