package Homework04;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// �������� ����
		Network netOne = new Network("��������");
		Network netTwo = new Network("���");

		// ������� ������ �� ������ � ������ ����
		netOne.addBillingNetwork(netTwo);

		// �������� ����� ���������

		Phone phoneOne = new Phone("+380671112233", "Nokia3210");
		Phone phoneTwo = new Phone("+380672223344", "Alcatel");
		Phone phoneThre = new Phone("+380504443333", "Motorola");

		// �������������� ��� �������� � ���� �������� � ������ � ���
		phoneOne.regNetwork(netOne);
		phoneTwo.regNetwork(netOne);
		netTwo.regPhone(phoneThre);

		// ������� �����c ��������� � �����
		System.out.println("-=INFO=-");
		System.out.println(phoneOne);
		System.out.println(phoneTwo);
		System.out.println(phoneThre);
		System.out.println(netOne);
		System.out.println(netTwo);
		System.out.println("-=INFO=-");

		// �������� �������� ����� ����
		phoneOne.call("+380672223344");

		// �������� �������� ������� ��������������� � ������ ���� � � ��������
		// � �����
		phoneOne.call("+380504443333");

		// �������� ��������������� ������
		phoneOne.call("+38063454545");

		// �������� �� ������������ ����� � ���� � ������� ���� �������

		phoneThre.call("+380672223344");

		// ���������������� ������� � ������ ����
		phoneThre.regNetwork(netOne);
		
		
		// �������� ������� ���� � ������� ��������
		phoneThre.call("+380672223344");
		
		
		
		
		
	}

}
