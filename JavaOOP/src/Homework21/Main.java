package Homework21;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Point a = new Point(5, 2);
		Point b = new Point(-5, -16);
		Point c = new Point(8, -1);
		Point d = new Point(80, 20);

		Doska doska = new Doska();

		Triangle triOne = new Triangle(a, b, c);

		Fourangle fourOne = new Fourangle(a, b, c, d);

		Fourangle fourTwo = new Fourangle(new Point(0, 1), new Point(0, 3), new Point(0, 5), new Point(0, 9));

		Circle cirOne = new Circle(a, a);

		Circle cirTwo = new Circle(a, b);

		doska.addShape(triOne);
		doska.addShape(triOne);
		doska.delShape(triOne);
		doska.addShape(fourOne);

		// Не существующий четырехугольник не ложится
		doska.addShape(fourTwo);
		// Не существующий кружочек не ложится
		doska.addShape(cirOne);
		doska.addShape(cirTwo);
		System.out.println("!!!!" + cirTwo);

		doska.addShape(fourOne);
		// Нет места ложить
		doska.addShape(fourOne);

		// Выведем на экран
		doska.printDoska();

	}

}
