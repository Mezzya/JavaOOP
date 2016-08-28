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
				System.out.print("Введите имя:");
				firstName = reader.readLine();
				if (firstName != null && !firstName.equals(""))
					break;
			} catch (IOException e) {
				System.err.println("Неверно введено имя. Повторите попытку.");
			}
		}

		while (true) {
			try {
				System.out.print("Введите фамилию:");
				lastName = reader.readLine();
				if (lastName != null && !lastName.equals(""))
					break;
			} catch (IOException e) {
				System.err.println("Неверно введена Фамилия. Повторите попытку.");
			}
		}

		while (true) {
			try {
				System.out.print("Введите пол (м/ж):");
				tempSex = reader.readLine();
				if (tempSex != null && !tempSex.equals(""))
				{
					if (tempSex.equalsIgnoreCase("м"))
					{
						sex=true;
						break;
					}
					if (tempSex.equalsIgnoreCase("ж"))
					{
						sex=false;
						break;
					}
					
				}
				System.err.println("Неверно введен пол. Повторите попытку.");
					
			} catch (IOException e) {
				System.err.println("Неверно введен пол. Повторите попытку.");
			}
		}
		
		while (true) {
			try {
				System.out.print("Введите возраст:");
				
				age= Integer.parseInt(reader.readLine());
					if (age<0) 			{
						System.err.println("Возраст должен быть положительным числом");
						continue;
					}
					if (age>120)
					{
						System.err.println("Возраст должен быть меньше 120 лет");
						continue;
					}
					
				
				break;
					
			} catch (IOException e) {
				System.err.println("Возраст должен быть числом. Попробуйте еще раз.");
			}
		}
		
		while (true) {
			try {
				System.out.print("Введите средний балл:");
				
				gpa= Integer.parseInt(reader.readLine());
					if (gpa<0) 			{
						System.err.println("Средний балл должен быть положительным числом");
						continue;
					}
					if (gpa>5)
					{
						System.err.println("Средний балл должен быть меньше 5");
						continue;
					}
					
				
				break;
					
			} catch (IOException e) {
				System.err.println("Средний балл должен быть числом. Попробуйте еще раз.");
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
