package Lesson04;

import java.io.File;

public class Main {

	public static void main(String[] args)
	{
		Human humanOne = new Human("Alexandr", "Ts", 35);
		Human humanTwo = new Human("Victor", "Tss", 45);
		
		humanOne.save(new SaveToCSV(new File("human.csv")));
		humanTwo.save(new SaveToCSV(new File("humanTwo.csv")));
		
		
		Human HumanThree = Human.load(new SaveToCSV(new File("humanTwo.csv")));
		
		System.out.println(HumanThree);
		
		
	}
	
}
