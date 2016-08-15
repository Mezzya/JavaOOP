package Homework02;

public class Triangle {
	private double a;
	private double b;
	private double c;
	private boolean exist; // ������� ������������� ������������

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
		// �������� ������������� ������������

		if ((a < (b + c)) && (b < (a + c)) && (c < (a + b))) {
			exist = true;
			System.out.println("����������� �� ��������� A=" + a + " B=" + b + " C=" + c + " ����������");
		} else
			System.out.println("����������� �� ��������� A=" + a + " B=" + b + " C=" + c + " �� ����������");
	}

	public double square() {

		if (exist) {
			// ��������� ������� �� ������� ������
			double p = (a + b + c) / 2;
			double s = Math.sqrt(p * (p - a) * (p - b) * (p - c));
			return s;
		} else {
			System.out.println("����������� � ������ ��������� �� ����������. �� � ������� ��� ����.");
			return 0;
		}

	}

}
