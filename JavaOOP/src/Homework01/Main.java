package Homework01;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Cat catOne = new Cat("�����",1,1.0);
		Cat catTwo = new Cat("������",2,2.5);
		Cat catThree = new Cat("���������",4,6.0);
//		�����
		catOne.voice();
		catTwo.voice();
		
//		����� �����
		catOne.kill();
		catOne.voice();
		
//		������� ���������
		System.out.println();
		System.out.println(catOne);
		System.out.println(catTwo);
		System.out.println(catThree);
		
		
//		������ ����� �����
		catTwo.eat(0.250);
		
//		������ ����������� ������
		catOne.eat(2);
		
//		������� ���������
		System.out.println();
		System.out.println(catOne);
		System.out.println(catTwo);
		System.out.println(catThree);
		
//		��������� ������ �������� ����
		catTwo.eat(catOne);
		
//		��������� ������ ����
		catTwo.eat(catTwo);
		
//		������ ������ � ����������
		
		catTwo.eat(catThree);
		

//		������� ���������
		System.out.println();
		System.out.println(catOne);
		System.out.println(catTwo);
		System.out.println(catThree);

	}

}
