package Homework31;

import java.util.Arrays;

import Homework31.Group.OutOfFreePlacesException;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Student stu1 = new Student("���", "������", true, 21, 3);
		Student stu2 = new Student("���", "������", true, 18, 5);
		Student stu3 = new Student("�����", "�������", true, 16, 3);
		Student stu4 = new Student("�����", "���", true, 12, 1);
		Student stu5 = new Student("�������", "����������", true, 25, 3);
		Student stu6 = new Student("����", "������", true, 18, 4);
		Student stu7 = new Student("�����", "���", true, 18, 5);
		Student stu8 = new Student("�������", "�����", true, 21, 4);
		Student stu9 = new Student("����������", "��������", true, 19, 5);

		Student stu11 = new Student("������", "��������", true, 18, 2);

		Group group = new Group("������ �5", "���");

		// ������� ������� �������� � ������������ ���������

		// Student stuTwo = new Student("������", "����", true, -18);
		// Student stuTre = new Student("������", "����", true, 160, 4);

		// ������� ������� �������� � �� ������� ������ �� ���������� �
		// ���������� �� 0 �� 5

		// Student stuTwo = new Student("������", "����", true, 18, -4);
		// Student stuTwo = new Student("������", "����", true, 18, 10);

		try {
			group.addStudent(stu1);
			group.addStudent(stu2);
			group.addStudent(stu3);
			group.addStudent(stu4);
			group.addStudent(stu5);
			group.addStudent(stu6);
			group.addStudent(stu7);
			group.addStudent(stu8);
			group.addStudent(stu9);
			 // � ����� � ��� ��������
//			group.addStudent(new Student("����", "�����", false, 16, 4));
			// � ���� �� ������ ����� ���
//			group.addStudent(stu11);
			
//			group.add(new AddStudentInteractive());

		} catch (OutOfFreePlacesException e) {
			System.out.println(e);

		}

//		������ ��������
		group.delStudent(stu9);
		group.delStudent(stu9);

		group.delStudent(stu11);

//		���������� �� ����� (1-4 ���, �������, ���, �������, ������� ����)
		group.sort(4);
		
		
//		�������
		System.out.println(Arrays.toString(group.getArrayForVoenkom()));
		
		System.out.println();
		
//		����� ������
		System.out.println(group);
		
//		Сохраним в файл
		group.save(new SaverToFile());

	}

}
