package Homework31;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.TreeSet;

public class SaverToFile implements Saver {
	
	private File fileto;
	

	public SaverToFile() {
		super();
		fileto = new File("group.dat");
		
	}

	public SaverToFile(File fileto) {
		super();
		this.fileto = fileto;
	}

	@Override
	public void save(Group group) {
		// TODO Auto-generated method stub
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(fileto) ))
		{
			bw.write(group.getGroupName());
			bw.newLine();
			bw.write(group.getUniverName());
			bw.newLine();
			
//			Пройдемся по масиву студентов
			TreeSet<Student> set = group.getStudentsSet();
			int sex;
			for (Student student : set) {
				if (student.isSex()) sex=1;
				 else sex=0;
				bw.write(student.getFirsName()+";"+student.getLastName()+";"+sex+";"+student.getGpa());
				bw.newLine();
				
				
			}
		
			
			bw.flush();
			
		} catch (IOException e)
		{
			System.out.println(e);
		}
		
	}

	@Override
	public void load(Group group) {
		// TODO Auto-generated method stub
		
	}

}
