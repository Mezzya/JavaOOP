package Homework01;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Cat catOne = new Cat("Мурка",1,1.0);
		Cat catTwo = new Cat("Васька",2,2.5);
		Cat catThree = new Cat("Неудачник",4,6.0);
//		Голос
		catOne.voice();
		catTwo.voice();
		
//		Убили кошку
		catOne.kill();
		catOne.voice();
		
//		Выведем посмотрим
		System.out.println();
		System.out.println(catOne);
		System.out.println(catTwo);
		System.out.println(catThree);
		
		
//		Второя поела чутка
		catTwo.eat(0.250);
		
//		Первая попробовала поесть
		catOne.eat(2);
		
//		Выведем посмотрим
		System.out.println();
		System.out.println(catOne);
		System.out.println(catTwo);
		System.out.println(catThree);
		
//		Попробуем сьесть мертвого кота
		catTwo.eat(catOne);
		
//		Попробуем сьесть себя
		catTwo.eat(catTwo);
		
//		Сьедим живого и поправимся
		
		catTwo.eat(catThree);
		

//		Выведем посмотрим
		System.out.println();
		System.out.println(catOne);
		System.out.println(catTwo);
		System.out.println(catThree);

	}

}
