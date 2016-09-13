package HomeWork94;

import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

	public static void main(String[] args) {
		Deque<String> set = new ArrayDeque<>();
		
		// Инициализация
		set.addLast(new String("Sheldon"));
		set.addLast(new String("Leonard"));
		set.addLast(new String("Volovitc"));
		set.addLast(new String("Kutrapalli"));
		set.addLast(new String("Penny"));

		// Вывод начальной очереди		
		System.out.println(set);
		
		// Колличество стаканов выданных автоматом
		int count = 7;

		for (int i = 0; i < count; i++) {
			set.addLast(set.pollFirst());
			set.addLast(new String(set.getLast()));
		}
		
		// Вывод результата
		System.out.println(set);

	}

}
