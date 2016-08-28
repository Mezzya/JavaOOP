package Homework31;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import Homework31.Group.OutOfFreePlacesException;

public class AddStudentInteractive implements AddStudent  {

	@Override
	public void addstudent(Group group) {
		// TODO Auto-generated method stub
		String firstName = "";
		String lastName ="";
		String tempSex;
		boolean sex;
		int age, gpa;
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			try {
				System.out.print("������� ���:");
				firstName = reader.readLine();
				if (firstName != null && !firstName.equals(""))
					break;
			} catch (IOException e) {
				System.err.println("������� ������� ���. ��������� �������.");
			}
		}

		while (true) {
			try {
				System.out.print("������� �������:");
				lastName = reader.readLine();
				if (lastName != null && !lastName.equals(""))
					break;
			} catch (IOException e) {
				System.err.println("������� ������� �������. ��������� �������.");
			}
		}

		while (true) {
			try {
				System.out.print("������� ��� (�/�):");
				tempSex = reader.readLine();
				if (tempSex != null && !tempSex.equals(""))
				{
					if (tempSex.equalsIgnoreCase("�"))
					{
						sex=true;
						break;
					}
					if (tempSex.equalsIgnoreCase("�"))
					{
						sex=false;
						break;
					}
					
				}
				System.err.println("������� ������ ���. ��������� �������.");
					
			} catch (IOException e) {
				System.err.println("������� ������ ���. ��������� �������.");
			}
		}
		
		while (true) {
			try {
				System.out.print("������� �������:");
				
				age= Integer.parseInt(reader.readLine());
					if (age<0) 			{
						System.err.println("������� ������ ���� ������������� ������");
						continue;
					}
					if (age>120)
					{
						System.err.println("������� ������ ���� ������ 120 ���");
						continue;
					}
					
				
				break;
					
			} catch (IOException e) {
				System.err.println("������� ������ ���� ������. ���������� ��� ���.");
			}
		}
		
		while (true) {
			try {
				System.out.print("������� ������� ����:");
				
				gpa= Integer.parseInt(reader.readLine());
					if (gpa<0) 			{
						System.err.println("������� ���� ������ ���� ������������� ������");
						continue;
					}
					if (gpa>5)
					{
						System.err.println("������� ���� ������ ���� ������ 5");
						continue;
					}
					
				
				break;
					
			} catch (IOException e) {
				System.err.println("������� ���� ������ ���� ������. ���������� ��� ���.");
			}
		}
		
		try{
		group.addStudent(new Student(firstName, lastName, sex, age, gpa));
		}
		catch (OutOfFreePlacesException e)
		{
			System.out.println(e);
		}
		

	
		
	}
	
}
