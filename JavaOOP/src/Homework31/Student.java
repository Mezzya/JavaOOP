package Homework31;

public class Student extends Human {
	private double gpa; // ������� ����

	public Student() {
		super();
		// TODO Auto-generated constructor stub

	}

	public Student(String firsName, String lastName, boolean sex, int age, double gpa) {
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

	public void setGpa(double gpa) throws IllegalArgumentException {

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		long temp;
		temp = Double.doubleToLongBits(gpa);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (Double.doubleToLongBits(gpa) != Double.doubleToLongBits(other.gpa))
			return false;
		return true;
	}
	
	

}
