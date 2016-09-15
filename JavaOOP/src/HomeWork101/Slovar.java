package HomeWork101;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Slovar implements Serializable {

	private static final long serialVersionUID = 1L;
	private Map<String, String> map = new HashMap<>();

	public Slovar() {
		super();
	}

	public String getPerevod(String eng) {
		return map.get(eng);
	}

	public void add(String key, String val) {
		map.put(key, val);
	}

	public void dell(String key) {
		map.remove(key);
	}

	public void print() {
		System.out.println(map);
	}

	public void save() {

		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("slovar.obj"))) {
			oos.writeObject(this);

		} catch (IOException e) {
			// TODO: handle exception
			System.out.println("Error save Slovar to file!!!");
		}

	}

	
	public static Slovar load() {

		Slovar sl = null;
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("slovar.obj"))) {
			sl = (Slovar) ois.readObject();
			return sl;

		} catch (IOException | ClassNotFoundException e) {
			// TODO: handle exception
			System.out.println("Error load slovar from file!!!");
		}
		return null;
	}

}
