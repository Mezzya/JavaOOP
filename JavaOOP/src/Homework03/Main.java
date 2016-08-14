package Homework03;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Vector3d a= new Vector3d(45,23,2);
		Vector3d b= new Vector3d(2,-69,45);
		Vector3d c=a.add(b);
		
		System.out.println(a);
		System.out.println(b);
		
		System.out.println("Сложение векторов A и B = "+c);
		
		Vector3d d = a.multiScalar(b);
		
		System.out.println("Скалярное произведение A и B = "+d);
		
	
		System.out.println("Векторное произведение A и B = "+a.multiVector(b));
		
		
		

	}

}
