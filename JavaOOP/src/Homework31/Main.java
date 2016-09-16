package Homework31;

import java.util.Arrays;

import Homework31.Group.OutOfFreePlacesException;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub


		Student stu1 = new Student("Чак", "Норрис", true, 21, 3);
		Student stu2 = new Student("Шон", "Конери", true, 18, 5);
		Student stu3 = new Student("Майкл", "Дудиков", true, 16, 3);
		Student stu4 = new Student("Костя", "Дзю", true, 12, 1);
		Student stu5 = new Student("Арнольд", "Шварцнегер", true, 25, 3);
		Student stu6 = new Student("Брюс", "Виллис", true, 18, 4);
		Student stu7 = new Student("Джеки", "Чан", true, 18, 5);
		Student stu8 = new Student("Николас", "Кейдж", true, 21, 4);
		Student stu9 = new Student("Сильвестер", "Сталлоне", true, 19, 5);

		Student stu11 = new Student("Адольф", "Лунгрэнд", true, 18, 2);

		Group group = new Group("Группа №5", "КПИ");

		// Попытка создать студента с неправильным возрастом

		// Student stuTwo = new Student("Иванов", "Иван", true, -18);
		// Student stuTre = new Student("Иванов", "Иван", true, 160, 4);

		// Попытка создать студента с со средним баллом не попадающим в
		// промежуток от 0 до 5

		// Student stuTwo = new Student("Иванов", "Иван", true, 18, -4);
		// Student stuTwo = new Student("Иванов", "Иван", true, 18, 10);

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
			 // А можно и так добавить
//			group.addStudent(new Student("Лара", "Крофт", false, 16, 4));
			// А этот не влезит места нет
//			group.addStudent(stu11);
			
//			group.add(new AddStudentInteractive());

		} catch (OutOfFreePlacesException e) {
			System.out.println(e);

		}

//		Удалим студента
		group.delStudent(stu9);
		group.delStudent(stu9);

		group.delStudent(stu11);

//		Сортировка по полям (1-4 Имя, Фамилия, пол, возраст, средний балл)
		group.sort(4);
		
		
//		Военком
		System.out.println(Arrays.toString(group.getArrayForVoenkom()));
		
		System.out.println();
		
//		Вывод группы
		System.out.println(group);
//		Сохраним в файл
		group.save(new SaverToFile());
		
//		Загрузим группу из файла
		Group groupTwo = new SaverToFile().load();
		System.out.println();
		System.out.println(groupTwo);
		
		
//		Stream API
		System.out.println(groupTwo.findStudent("Ви"));

		
	}

}
