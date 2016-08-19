package Homework31;

import java.util.Comparator;
import java.util.TreeSet;

public class Group {
	private TreeSet<Student> set = new TreeSet<Student>(new Sort());
	private String groupName;
	private String univerName;

	public Group(String groupName, String univerName) {
		super();
		this.groupName = groupName;
		this.univerName = univerName;
	}

	public Group() {
		super();
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getUniverName() {
		return univerName;
	}

	public void setUniverName(String univerName) {
		this.univerName = univerName;
	}

	public void addStudent(Student student) throws OutOfFreePlacesException {
		if (set.size() < 10) {
			// Свободно место в группе есть. Зачисляем
			set.add(student);
			System.out.println(student + " зачислен в " + groupName);
			return;
		}

		// Похоже мест свободных нету

		throw new OutOfFreePlacesException();

	}

	private class Sort implements Comparator<Student> {
		public int compare(Student a, Student b) {
			return a.getLastName().compareTo(b.getLastName());

		}
	}

	public void delStudent(Student student) {
		if (set.contains(student)) {
			// Нашли и удаляем его
			set.remove(student);
			System.out.println(student + " успешно отчислен");
			return;

		}

		System.out.println(student + " в группе не найден");

	}

	// Наше исключение
	class OutOfFreePlacesException extends Exception {

		@Override
		public String getMessage() {
			// TODO Auto-generated method stub
			return "Группа переполнена";
		}

	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		int i = 0, k = 0;
		double s = 0;

		StringBuilder sb = new StringBuilder();
		sb.append("Университет " + getUniverName() + " " + groupName);
		sb.append(System.lineSeparator());
		sb.append("Состав группы " + set.size() + " из 10 : " + System.lineSeparator() + System.lineSeparator());

		for (Student student : set) {
			sb.append(student);
			if (student.getGpa() == 5)
				i++;
			if (student.getGpa() == 1)
				k++;
			s += student.getGpa();
			sb.append(System.lineSeparator());
		}
		sb.append(System.lineSeparator());

		sb.append("Отличники: " + i + System.lineSeparator() + "Двоечники: " + k + System.lineSeparator()
				+ "Средний балл в группе: " + s / set.size());

		return sb.toString();
	}

}
