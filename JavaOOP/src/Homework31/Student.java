package Homework31;

public class Student extends Human {
	private double gpa; // Средний балл

	public Student() {
		super();
		// TODO Auto-generated constructor stub

	}

	public Student(String firsName, String lastName, boolean sex, int age, int gpa) {
		super(firsName, lastName, sex, age);
		setGpa(gpa);
	}

	public Student(String firsName, String lastName, boolean sex, int age) {
		super(firsName, lastName, sex, age);

		// TODO Auto-generated constructor stub
	}

	public double getGpa() {
		return gpa;
	}

	public void setGpa(int gpa) throws IllegalArgumentException {

		if (gpa < 0)
			throw new IllegalArgumentException("Средний балл не может быть меньше 0");
		if (gpa > 5)
			throw new IllegalArgumentException("Средний балл не может быть больше 5");

		this.gpa = gpa;
	}

	@Override
	public String toString() {
		return "Студент " + super.toString() + " gpa=" + gpa + "";
	}

}
