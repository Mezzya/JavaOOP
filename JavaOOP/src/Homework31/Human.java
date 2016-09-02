package Homework31;

/**
 * @author User
 *
 */
public class Human {
	private String firsName;
	private String lastName;
	private boolean sex;
	private int age;

	public Human(String firsName, String lastName, boolean sex, int age) {
		super();
		this.firsName = firsName;
		this.lastName = lastName;
		this.sex = sex;
		setAge(age);
	}

	public Human() {
		super();
		this.firsName = "Неизвестно";
		this.lastName = "Неизвестно";

	}

	public String getFirsName() {
		return firsName;
	}

	public void setFirsName(String firsName) {
		this.firsName = firsName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public boolean isSex() {
		return sex;
	}

	public void setSex(boolean sex) {
		this.sex = sex;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) throws IllegalArgumentException {
		if (age < this.age)
			throw new IllegalArgumentException("Невозможно установить возраст меньше чем он есть");

		if (age < 0)
			throw new IllegalArgumentException("Невозможно установить возраст меньше меньше ноля");
		if (age > 150)
			throw new IllegalArgumentException("Маловероятный возраст для человека");

		this.age = age;
	}

	@Override
	public String toString() {
		return lastName + " " + firsName + ", Пол=" + (sex ? "Мужской" : "Женский") + ", Возраст=" + age + "";
	}

}
