package Homework21;

public class Circle extends Shape {
	private Point a;
	private Point r;
	private boolean exist;

	public Circle() {
		super();
		exist();
	}

	public Circle(Point a, Point r) {
		super();
		this.a = a;
		this.r = r;
		exist();
	}
	
	

	public Point getA() {
		return a;
	}

	public Point getR() {
		return r;
	}

	@Override
	double getPerimetr() {
		// TODO Auto-generated method stub
		
		if (exist) return 2*Math.PI*a.getLengToPoint(r);
		else return -1;
	}

	@Override
	double getArea() {
		// TODO Auto-generated method stub
		if (exist) return Math.PI*Math.pow(a.getLengToPoint(r), 2);
		else return -1;
	}

	@Override
	boolean isExist() {
		// TODO Auto-generated method stub
		return exist;
	}

	private void exist() {
		if (a.getLengToPoint(r) > 0) {
			exist = true;
		} else
			exist = false;
	}
	
	@Override
	public String toString() {
		
		if (exist) return "Окружность A" + a+" Радиус "+a.getLengToPoint(r);
		else return "Окружность не существует";
	}
	

}
