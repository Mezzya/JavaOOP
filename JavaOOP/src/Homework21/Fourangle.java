package Homework21;

public class Fourangle extends Shape {

	private Point a;
	private Point b;
	private Point c;
	private Point d;
	private boolean exist;

	public Fourangle(Point a, Point b, Point c, Point d) {
		super();
		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;
		exist();
	}

	public Fourangle() {
		super();
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

	public Point getD() {
		return d;
	}

	@Override
	boolean isExist() {
		// TODO Auto-generated method stub

		return exist;
	}

	@Override
	double getPerimetr() {
		// TODO Auto-generated method stub
		if (exist)
			return a.getLengToPoint(b) + b.getLengToPoint(c) + c.getLengToPoint(d) + d.getLengToPoint(a);
		else
			return -1;

	}

	@Override
	double getArea() {
		// TODO Auto-generated method stub
		// Посчитаем площадь
		if (exist) {
			double ab = a.getLengToPoint(b);
			double bc = b.getLengToPoint(c);
			double cd = c.getLengToPoint(d);
			double da = d.getLengToPoint(a);

			double p = (ab + bc + cd + da) / 2;
			double s = Math.sqrt(p * (p - ab) * (p - bc) * (p - cd) * (p - da));

			return s;
		}
		return -1; // Не понятно что вернуть если не существует

	}

	private void exist() {
		double ab = a.getLengToPoint(b);
		double bc = b.getLengToPoint(c);
		double cd = c.getLengToPoint(d);
		double da = d.getLengToPoint(a);

		if ((ab < (bc + cd + da)) && (bc < (ab + cd + da)) && (cd < (ab + bc + da)) && (da < (ab + bc + cd)))
			exist = true;

		else
			exist = false;

	}

	@Override
	public String toString() {
		return "Четырехугольник A" + a + " B" + b + " C" + c + " D" + d + " "
				+ (exist ? " Существует" : "Не существует");
	}

}
