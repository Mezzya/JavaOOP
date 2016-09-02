package Homework31;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.TreeSet;

public class SaverToFile implements Saver {

	private File file;

	public SaverToFile() {
		super();
		file = new File("group.dat");

	}

	public SaverToFile(File file) {
		super();
		this.file = file;
	}

	@Override
	public void save(Group group) {
		// TODO Auto-generated method stub
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
			bw.write(group.getGroupName());
			bw.newLine();
			bw.write(group.getUniverName());
			bw.newLine();

			// Пройдемся по масиву студентов
			TreeSet<Student> set = group.getStudents();
			int sex;
			for (Student student : set) {
				if (student.isSex())
					sex = 1;
				else
					sex = 0;
				bw.write(student.getFirsName() + ";" + student.getLastName() + ";" + student.getAge() + ";" + sex + ";"
						+ student.getGpa());
				bw.newLine();

			}

			bw.flush();

		} catch (IOException e) {
			System.out.println(e);
		}

	}

	@Override
	public Group load() {
		// TODO Auto-generated method stub
		Group grope = new Group();
		Student student;
		String[] date;
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			String s;
			int i = 0;
			while ((s = br.readLine()) != null) {
				if (i == 0)
					grope.setGroupName(s);
				if (i == 1)
					grope.setUniverName(s);
				if (i > 1) {
					date = s.split(";");
					boolean sex = false;
					
					int age = Integer.parseInt(date[2]);
					double gpa = Double.parseDouble(date[4]);
					
					if (date[3].equals("1"))
						sex = true;
					try {
						grope.addStudent(new Student(date[0], date[1], sex, age, gpa));
					} catch (Exception e) {
						// TODO: handle exception
						System.out.println(e);
					}

				}

				i++;

			}

		} catch (IOException e) {

			System.out.println(e);
		}

		return grope;

	}

}
