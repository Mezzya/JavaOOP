package Homework01;

public class Cat {
	private String name;
	private int age;
	private double weight;
	private boolean alive; // Признак жизнедеятельности

	public Cat() {
		super();
	}

	public Cat(String name, int age, double weight) {
		super();
		this.name = name;
		this.age = age;
		// Кошка рождается живой
		alive = true;
		this.weight = weight;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public boolean isAlive() {
		return alive;
	}

	public void voice() {
		if (alive)
			System.out.println(name + " - Мяу-мяу");
		else
			System.out.println(name + " - Неполучается мяукнуть. Сдохла я");

	}

	public void eat(double weight) {
		if (alive)
			this.weight += weight;
		else
			System.out.println(name + " - Мертвые не едят");
	}

	public void eat(Cat cat) {
		if (!isAlive()){
			System.out.println(name + " - Мертвые не едят");
			return;
		}
		if (cat.equals(this)) {
			System.out.println(name + " - Нее. Себя есть не буду");
			return;
		}
		if (cat.isAlive()) {
			this.weight += cat.weight;
			cat.kill();
			System.out.println(name + " - съел " + cat.name + ". Есть то хочется... ");
		} else
			System.out.println(name + " - Вредно есть мертвых котов");

	}

	public void kill() {
		if (isAlive()) {
			alive=false;
			System.out.println(name+" - Всем пока. Умерла я.");
		} 
		else System.out.println(name+" - Я уже мертвая.");
	}

	@Override
	public String toString() {
		return name + ", age=" + age + ", weight=" + weight + ", alive=" + alive + "]";
	}

}
