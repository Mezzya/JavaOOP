package Homework21;

public class Point {
	private double x;
	private double y;

	public Point(double x, double y) {
		super();
		this.x = x;
		this.y = y;
	}

	public Point() {
		super();
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public double getLengToPoint(Point a) {
		// Вычисление растояния между поинтами
		return Math.sqrt(Math.pow((a.x - this.x), 2) + Math.pow((a.y - this.y), 2));
	}

	@Override
	public String toString() {
		return "(" + x + ", " + y + ")";
	}

}
