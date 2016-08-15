package Lesson02;

public class Animal {
	
	private int age;
	private String color;
	private boolean sex;
	private String racion;
	public Animal(int age, String color, boolean sex, String racion) {
		super();
		this.age = age;
		this.color = color;
		this.sex = sex;
		this.racion = racion;
	}
	public Animal() {
		super();
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public boolean isSex() {
		return sex;
	}
	public void setSex(boolean sex) {
		this.sex = sex;
	}
	public String getRacion() {
		return racion;
	}
	public void setRacion(String racion) {
		this.racion = racion;
	}
	@Override
	public String toString() {
		return "Animal [age=" + age + ", color=" + color + ", sex=" + sex + ", racion=" + racion + "]";
	}
	
	public void getVoice()
	{
		
	}
	

}
