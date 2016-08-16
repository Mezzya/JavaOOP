package Homework21;

public class Doska {

	private Shape[] doska = new Shape[4];

	public Doska() {
		super();
	}

	public void addShape(Shape shape) {
		if (!shape.isExist()) {
			// Как это мы засунем несуществующуюю фигуру

			System.out.println("Такая фигура не существует, Положить не могу");
			return;
		}

		for (int i = 0; i < doska.length; i++) {

			if (doska[i] == null) {
				// Есть свободное место. Положим сюда
				doska[i] = shape;
				System.out.println("Нашли место для фигуры и разместили");
				return;
			}

		}
		System.out.println("Нет свободного места на доске");
	}

	public void delShape(Shape shape) {

		for (int i = 0; i < doska.length; i++) {
			if (shape.equals(doska[i])) {
				// Первая найденная на доске фигурка. Ее и удалим.
				
				System.out.println("Удалили фигуру с доски");
				doska[i] = null;
				return;
			}

		}
		System.out.println("Такая фигура на доске не найдена");

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
		System.out.println("Суммарная площадь фигур на доске :" + getAllArea());
		System.out.println();
	}

	@Override
	public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append("Доска содержит:" + sb.append(System.lineSeparator()));
		for (int i = 0; i < doska.length; i++) {
			sb.append(i + 1 + ". ");
			if (doska[i] == null)
				sb.append("Пусто");
			else
				sb.append(doska[i]);
			sb.append(System.lineSeparator());
		}

		return sb.toString();
	}

}
