package HomeWork71;

public class Ship implements Runnable {
	private int boxes;
	private int number;
	private Port port;

	public Ship() {
		super();
	}

	public Ship(int number, int boxes, Port port) {
		super();
		this.number = number;
		this.boxes = boxes;
		this.port = port;
	}

	public int getNumber() {
		return number;
	}

	public void dowloadOneBox() {
		boxes--;
	}

	public int getBoxes() {
		return boxes;
	}

	@Override
	public void run() {
	
		// Получим свободный док из Порта
		Dock dock = port.getFreeDock(this);
		
		System.out.println("Корабль №" + number + " получил Док №" + dock.getNumber());
		
		while (boxes > 0) {
			// Пытаюсь разгрузить ящики

			dock.unload(this);

		}

		System.out.println("Разгрузка корабля №" + number + " завершена");

	}

}
