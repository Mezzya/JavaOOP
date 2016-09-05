package HomeWork65;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

public class CheckFolder implements Runnable {

	File folder;
	
	
	public CheckFolder(File folder) {
		super();
		
		if (!folder.exists()||!folder.isDirectory()) throw new IllegalArgumentException("Директория не сществует или это файл");
		this.folder = folder;
	}
	
	

	@Override
	public void run() {
		// TODO Auto-generated method stub
		ArrayList<String> fileList;
		
		
		ArrayList<String> temp = new ArrayList<String>(Arrays.asList(folder.list()));
		
		
		
		
		while(true)
		{
			fileList = new ArrayList<String>(Arrays.asList(folder.list()));
			
			if (fileList.size()>temp.size())
			{
//			 	Добавились фалы в каталоге
				fileList.removeAll(temp);
				System.out.println("Появились "+fileList);
				temp = new ArrayList<String>(Arrays.asList(folder.list()));
		
//				Если появится файл exit.txt Завершить поток
				if(fileList.contains("exit.txt")){
					System.out.println("Завершаю работу");
					break;
				}
				
			} else
			if (temp.size()>fileList.size())
			{
//				Удалились фалы из каталога
				temp.removeAll(fileList);
				System.out.println("Исчезли "+temp);
				temp = new ArrayList<String>(Arrays.asList(folder.list()));
				
			} else
			if (temp.size()==fileList.size())
			{
				System.out.println("Без изменений. Мониторю...");

			}
			
//			Спим одну секуну
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
			
			
			
		}
		
		
	}
	
	

}
