package Homework02;

public class Triangle {
	private double a;
	private double b;
	private double c;
	private boolean exist; // Признак существования треугольника

	public Triangle() {
		super();
	}

	public Triangle(double a, double b, double c) {
		super();
		this.a = a;
		this.b = b;
		this.c = c;
		exist();
	}

	public double getA() {
		return a;
	}

	public double getB() {
		return b;
	}

	public double getC() {
		return c;
	}

	private void exist() {
		// Проверим существование треугольника

		if ((a < (b + c)) && (b < (a + c)) && (c < (a + b))) {
			exist = true;
			System.out.println("Треугольник со сторонами A=" + a + " B=" + b + " C=" + c + " существует");
		} else
			System.out.println("Треугольник со сторонами A=" + a + " B=" + b + " C=" + c + " не существует");
	}

	public double square() {

		if (exist) {
			// Вычисляем площадь по формуле Герона
			double p = (a + b + c) / 2;
			double s = Math.sqrt(p * (p - a) * (p - b) * (p - c));
			return s;
		} else {
			System.out.println("Треугольник с такими сторонами не существует. Ну и площадь его тоже.");
			return 0;
		}

	}

}
