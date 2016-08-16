package Homework21;

public class Triangle extends Shape {

	private Point a;
	private Point b;
	private Point c;
	private boolean exist;

	public Triangle() {
		super();
		exist();
	}

	public Triangle(Point a, Point b, Point c) {
		super();
		this.a = a;
		this.b = b;
		this.c = c;

		exist();
	}

	public Point getA() {
		return a;
	}

	public Point getB() {
		return b;
	}

	public Point getC() {
		return c;
	}

	public boolean isExist() {
		return exist;
	}

	@Override
	double getPerimetr() {
		// TODO Auto-generated method stub
		double ab = a.getLengToPoint(b);
		double bc = b.getLengToPoint(c);
		double ca = c.getLengToPoint(a);

		return ab + bc + ca;
	}

	@Override
	double getArea() {
		// TODO Auto-generated method stub
		// Посчитаем площадь
		if (exist) {
			double ab = a.getLengToPoint(b);
			double bc = b.getLengToPoint(c);
			double ca = c.getLengToPoint(a);

			double p = (ab + bc + ca) / 2;
			double s = Math.sqrt(p * (p - ab) * (p - bc) * (p - ca));

			return s;
		}
		return -1; // Не понятно что вернуть если не существует

	}

	private void exist() {
		double ab = a.getLengToPoint(b);
		double bc = b.getLengToPoint(c);
		double ca = c.getLengToPoint(a);

		if ((ab < (bc + ca)) && (bc < (ab + ca)) && (ca < (ab + bc)))
			exist = true;

		else
			exist = false;

	}

	@Override
	public String toString() {
		return "Треугольник A" + a + " B" + b + " C" + c + (exist ? " Существует" : "Не существует");
	}

}
