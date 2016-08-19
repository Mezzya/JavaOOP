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
		this.firsName = "����������";
		this.lastName = "����������";

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
			throw new IllegalArgumentException("���������� ���������� ������� ������ ��� �� ����");

		if (age < 0)
			throw new IllegalArgumentException("���������� ���������� ������� ������ ������ ����");
		if (age > 150)
			throw new IllegalArgumentException("������������� ������� ��� ��������");

		this.age = age;
	}

	@Override
	public String toString() {
		return lastName + " " + firsName + ", ���=" + (sex ? "�������" : "�������") + ", �������=" + age + "";
	}

}
