package HomeWork82;

import java.util.Arrays;


public class Stack {

	private Object[] stack = new Object[0];

	public Stack() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void add(Object object) {
		// Добавление в стек нового элемента

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

			for (Object object : stack) {
				System.out.println(object);
			}
		}

	}

}
