package Homework04;

import java.util.HashSet;
import java.util.Iterator;

public class Network {
	private String name;
	private HashSet<Phone> regPhones; // Зарегистрированные телефоны в этой сети
	private HashSet<Network> billingNetwork; // Сети на которые абоненты этой
												// сети смогу звонить. Биллинг.

	public Network() {
		super();
		regPhones = new HashSet<>();
		billingNetwork = new HashSet<>();
	}

	public Network(String name) {
		super();
		this.name = name;
		regPhones = new HashSet<>();
		billingNetwork = new HashSet<>();
	}

	public HashSet<Network> getBillingNetwork() {
		return billingNetwork;
	}

	public void addBillingNetwork(Network billingNetwork) {
		this.billingNetwork.add(billingNetwork);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;

	}

	public HashSet<Phone> getRegPhones() {
		return regPhones;
	}

	public boolean regPhone(Phone phone) {
		if (regPhones.contains(phone)) {
			// Уже данный телефон зарегистрирован
			System.out.println("Телефон " + phone.getModel() + ", номер " + phone.getNumber()
					+ " уже зарегистрирован в сети " + name);
			return false;
		}

		regPhones.add(phone);
		if (phone.getMyNetwork() != null) {
			phone.getMyNetwork().unregPhone(phone);
		}

		phone.setMyNetwork(this);

		System.out.println("Телефон " + phone.getModel() + ", номер " + phone.getNumber()
				+ " успешно зарегистрировался в сети " + name);

		return true;
	}

	public boolean unregPhone(Phone phone) {

		if (regPhones.contains(phone)) {
			regPhones.remove(phone);
			return true;
		} else
			return false;

	}

	public boolean isPhoneRegistered(Phone phone) {
		if (regPhones.contains(phone))
			return true;
		else
			return false;
	}

	public boolean isPhoneNumberOfContain(String number) {
		Iterator<Phone> it = regPhones.iterator();
		while (it.hasNext()) {
			if (it.next().getNumber().equals(number))
				return true;
		}
		return false;
	}

	@Override
	public String toString() {
		return "Network [name=" + name + ", regPhones=" + regPhones + "]";
	}

}
