package Homework04;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Создадим сети
		Network netOne = new Network("Киевстар");
		Network netTwo = new Network("МТС");

		// Добавим билинг на звонки в другую сеть
		netOne.addBillingNetwork(netTwo);

		// Создадим парут телефонов

		Phone phoneOne = new Phone("+380671112233", "Nokia3210");
		Phone phoneTwo = new Phone("+380672223344", "Alcatel");
		Phone phoneThre = new Phone("+380504443333", "Motorola");

		// зарегистрируем два телефона в сети Киевстар а третий в МТС
		phoneOne.regNetwork(netOne);
		phoneTwo.regNetwork(netOne);
		netTwo.regPhone(phoneThre);

		// Выведем статуc телефонов и сетей
		System.out.println("-=INFO=-");
		System.out.println(phoneOne);
		System.out.println(phoneTwo);
		System.out.println(phoneThre);
		System.out.println(netOne);
		System.out.println(netTwo);
		System.out.println("-=INFO=-");

		// Позвоним абоненту своей сети
		phoneOne.call("+380672223344");

		// Позвоним абоненту который зарегистрирован в другой сети и в Биллинге
		// с нашей
		phoneOne.call("+380504443333");

		// Позвоним несузествующему номеру
		phoneOne.call("+38063454545");

		// Позвоним на существующий номер в сети с которой нету билинга

		phoneThre.call("+380672223344");

		// Перерегистрируем телефон в другую сеть
		phoneThre.regNetwork(netOne);
		
		
		// Позвоним абонету сети в которую перевели
		phoneThre.call("+380672223344");
		
		
		
		
		
	}

}
