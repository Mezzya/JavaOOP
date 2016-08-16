package Homework21;

public class Doska {

	private Shape[] doska = new Shape[4];

	public Doska() {
		super();
	}

	public void addShape(Shape shape) {
		if (!shape.isExist()) {
			// ��� ��� �� ������� ��������������� ������

			System.out.println("����� ������ �� ����������, �������� �� ����");
			return;
		}

		for (int i = 0; i < doska.length; i++) {

			if (doska[i] == null) {
				// ���� ��������� �����. ������� ����
				doska[i] = shape;
				System.out.println("����� ����� ��� ������ � ����������");
				return;
			}

		}
		System.out.println("��� ���������� ����� �� �����");
	}

	public void delShape(Shape shape) {

		for (int i = 0; i < doska.length; i++) {
			if (shape.equals(doska[i])) {
				// ������ ��������� �� ����� �������. �� � ������.
				
				System.out.println("������� ������ � �����");
				doska[i] = null;
				return;
			}

		}
		System.out.println("����� ������ �� ����� �� �������");

	}

	public double getAllArea() {
		double allArea = 0;
		for (int i = 0; i < doska.length; i++) {
			if (doska[i] != null) {
				allArea += doska[i].getArea();
			}
		}
		return allArea;
	}

	public void printDoska() {
		System.out.println(this);
		System.out.println("��������� ������� ����� �� ����� :" + getAllArea());
		System.out.println();
	}

	@Override
	public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append("����� ��������:" + sb.append(System.lineSeparator()));
		for (int i = 0; i < doska.length; i++) {
			sb.append(i + 1 + ". ");
			if (doska[i] == null)
				sb.append("�����");
			else
				sb.append(doska[i]);
			sb.append(System.lineSeparator());
		}

		return sb.toString();
	}

}
