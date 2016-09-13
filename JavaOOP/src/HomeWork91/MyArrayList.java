package HomeWork91;

import java.util.ArrayDeque;
import java.util.Deque;

public class MyArrayList<T> {

	Deque<T> list = new ArrayDeque<>();

	public MyArrayList() {
		super();

	}

	public void add(T date) {

		list.addLast(date);
	}

	public void delThoFirstAndLast() {
		if (list.size() < 3)
			throw new IllegalArgumentException("В списке меньше трех эллементов");
		list.removeFirst();
		list.removeFirst();

		list.removeLast();

	}

	@Override
	public String toString() {
		return "MyList [list=" + list + "]";
	}

}
