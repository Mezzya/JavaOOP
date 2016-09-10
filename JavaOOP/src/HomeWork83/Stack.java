package HomeWork83;

import java.util.Arrays;

public class Stack {

	private Object[] stack = new Object[0];
	private Class<?>[] blacklist = new Class[0];

	public Stack() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void addToBlackList(Class<?> clas) {
		// Добавление в blackList нового элемента

		// Проверим может уже есть в списке
		for (Class<?> class1 : blacklist) {
			if (class1.equals(clas)) {
				System.out.println("BlackList уже содержит " + clas);
				return;
			}

		}

		Class<?>[] temp = blacklist.clone();
		blacklist = new Class[blacklist.length + 1];

		blacklist[0] = clas;

		for (int i = 1; i < blacklist.length; i++) {
			blacklist[i] = temp[i - 1];
		}

	}

	public void add(Object object) {
		// Добавление в стек нового элемента

		// Проверим не в черном ли списке
		for (Class<?> class1 : blacklist) {
			if (class1.equals(object.getClass())) {
				System.out.println("Ошибка добавления. Класс объекта находится в BlackList");
				return;
			}
		}
		Object[] temp = stack.clone();
		stack = new Object[stack.length + 1];

		stack[0] = object;

		for (int i = 1; i < stack.length; i++) {
			stack[i] = temp[i - 1];
		}

	}

	public Object get() {
		// Просто возвращение элемента
		if (stack.length == 0)
			return null;
		else
			return stack[0];

	}

	public boolean isInBlacklist(Object object) {
//		Проверка объекта в блеклисте
		for (Class<?> class1 : blacklist) {
			if (class1.equals(object.getClass()))
				return true;
		}
		return false;

	}

	public Object getAndDel() {
		// Возвращение с удалением из стека

		if (stack.length == 0)
			return null;

		Object result = stack[0];

		stack = Arrays.copyOfRange(stack, 1, stack.length);

		return result;

	}

	public void printStack() {
		if (stack.length == 0)
			System.out.println("Стек пуст.");
		else {
			System.out.println("Вывод стека на экран");
			for (Object object : stack) {
				System.out.println(object);
			}
		}
		System.out.println();

	}

	public void printBlackList() {
		if (blacklist.length == 0)
			System.out.println("BlackList пуст.");
		else {
			System.out.println("Вывод содержимого BlascList: ");
			for (Class<?> clas : blacklist) {
				System.out.println(clas);
			}
		}
		System.out.println();

	}

}
