package Lesson04;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class SaveToCSV implements Saver {
	private File file;

	public SaveToCSV() {
		super();
	}

	public SaveToCSV(File file) {
		super();
		this.file = file;
	}

	@Override
	public void save(Human human) {
		// TODO Auto-generated method stub

		try (PrintWriter pw = new PrintWriter(this.file)) {
			pw.println(human.getName() + ";" + human.getLastName() + ";" + human.getAge());
		} catch (IOException e) {
			System.out.println(e);
		}

	}

	@Override
	public Human load() {
		// TODO Auto-generated method stub
		try (BufferedReader br = new BufferedReader(new FileReader(this.file))) {
			String humanText = br.readLine();
			String[] humanProperties = humanText.split(";");
			String name = humanProperties[0];
			String lastName = humanProperties[1];
			int age = Integer.valueOf(humanProperties[2]);
			return new Human(name, lastName, age);

		} catch (IOException e) {
			System.out.println(e);
			return null;
		}

	}

}
