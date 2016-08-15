package Lesson02;

public class Cat extends Animal {

	private String name;
	private String type;
	public Cat(int age, String color, boolean sex, String racion, String name, String type) {
		super(age, color, sex, racion);
		this.name = name;
		this.type = type;
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "Cat [name=" + name + ", type=" + type + "]"+super.toString();
	}
	@Override
	public void getVoice() {
		// TODO Auto-generated method stub
		System.out.println("Ìÿó-Ìÿó.");
	}
	
	
	
}
