package Homework04;

import java.util.Iterator;

public class Phone {
	private String number;
	private String model;
	private Network myNetwork; // � ����� ���� ���������������

	public Phone() {
		super();
	}

	public Phone(String number, String model) {
		super();
		this.number = number;
		this.model = model;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getModel() {
		return model;
	}

	public Network getMyNetwork() {
		return myNetwork;
	}

	public void setMyNetwork(Network myNetwork) {

		if (myNetwork.isPhoneRegistered(this))
			this.myNetwork = myNetwork;
		else
			regNetwork(myNetwork);
	}

	public void regNetwork(Network network) {
		// ����������� � ����� ����

		if (myNetwork == null) {
			// ����������� � ����� ����

			if (network.regPhone(this))
				myNetwork = network;
		}

		else {
			// ������� �� ������ ���� � ����������� � �����
			if (myNetwork.unregPhone(this)) {
				if (network.regPhone(this))
					myNetwork = network;
			}

		}

	}

	public void call(String number) {

		// �������� �� ���� �� ������ � ��������� �������� �������� � ����� ����
		if (this.number.equals(number)) {
			System.out.println("������� ��� ����. ������ ������");
			return;
		}
		if (myNetwork.isPhoneNumberOfContain(number)) {
			System.out.println("������� �������� ����� ���� � ������� " + number);
			return;
		} else {
			System.out.println("������� � ������� " + number + " �� ��������������� � ���� " + myNetwork.getName());
			System.out.println("������ � �������...");
		}

		// ���� �������� � ����� �������
		Iterator<Network> it = myNetwork.getBillingNetwork().iterator();
		Network temp;
		while (it.hasNext()) {
			temp = it.next();
			if (temp.isPhoneNumberOfContain(number)) {
				System.out.println("������ �� ������� ��������� " + temp.getName() + " �� ����� �������� " + number);
				return;
			}
		}
		System.out.println("������� � ������� " + number + " � ����� ������� �� ������");

	}

	@Override
	public String toString() {
		return "Phone [number=" + number + ", model=" + model + ", myNetwork=" + myNetwork.getName() + "]";
	}

}
