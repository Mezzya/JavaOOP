package Lesson02;

public class Rabit extends Animal {

	private String name;
	private String taste;
	public Rabit(int age, String color, boolean sex, String racion, String name, String taste) {
		super(age, color, sex, racion);
		this.name = name;
		this.taste = taste;
	}
	public Rabit(int age, String color, boolean sex, String racion) {
		super(age, color, sex, racion);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTaste() {
		return taste;
	}
	public void setTaste(String taste) {
		this.taste = taste;
	}
	@Override
	public String toString() {
		return "Rabit [name=" + name + ", taste=" + taste + "]"+super.toString();
	}
	@Override
	
	public void getVoice() {
		// TODO Auto-generated method stub
		System.out.println("ѕи-пи");
	};
	
	
	
}
