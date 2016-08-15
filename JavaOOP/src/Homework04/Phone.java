package Homework04;

import java.util.Iterator;

public class Phone {
	private String number;
	private String model;
	private Network myNetwork; // В какой сети зарегистрирован

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
		// Регистрация в новой сети

		if (myNetwork == null) {
			// Регистрация в новой сети

			if (network.regPhone(this))
				myNetwork = network;
		}

		else {
			// Отвязка от старой сети и регистрация в новой
			if (myNetwork.unregPhone(this)) {
				if (network.regPhone(this))
					myNetwork = network;
			}

		}

	}

	public void call(String number) {

		// Проверим не себе ли звоним и попробуем поискать абонента в своей сети
		if (this.number.equals(number)) {
			System.out.println("Вызываю сам себя. Обычно занято");
			return;
		}
		if (myNetwork.isPhoneNumberOfContain(number)) {
			System.out.println("Вызываю абонента своей сети с номером " + number);
			return;
		} else {
			System.out.println("Абонент с номером " + number + " не зарегистрирован в сети " + myNetwork.getName());
			System.out.println("Поищем в билинге...");
		}

		// Ищем абонента в сетях билинга
		Iterator<Network> it = myNetwork.getBillingNetwork().iterator();
		Network temp;
		while (it.hasNext()) {
			temp = it.next();
			if (temp.isPhoneNumberOfContain(number)) {
				System.out.println("Звонок по билингу оператору " + temp.getName() + " на номер абонента " + number);
				return;
			}
		}
		System.out.println("Абонент с номером " + number + " В сетях билинга не найден");

	}

	@Override
	public String toString() {
		return "Phone [number=" + number + ", model=" + model + ", myNetwork=" + myNetwork.getName() + "]";
	}

}
