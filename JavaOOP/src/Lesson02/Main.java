package Lesson02;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		HouseZoo hz = new HouseZoo();
		
		hz.addAnimal(new Cat(2, "blue", true, "Молоко", "Васька", "Сиамский"));
		hz.addAnimal(new Cat(2, "blue", true, "Молоко", "Петька", "Сиамский"));
		hz.addAnimal(new Rabit(3, "white", true, "morkovka"));
		
		System.out.println(hz);
		
		for (int i = 0; i < 10; i++) {
			hz.addAnimal(new Rabit(3, "white", true, "morkovka"));
			
			
		}
		
	}
	
	

}
