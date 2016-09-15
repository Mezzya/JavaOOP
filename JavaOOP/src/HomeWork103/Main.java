package HomeWork103;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<Integer, Integer> map = new HashMap<>();

		int[] arr = new int[10];
		Random random = new Random();

		// Заполним рандомно масив
		for (int i = 0; i < arr.length; i++) {

			arr[i] = random.nextInt(5);
		}

		System.out.println(Arrays.toString(arr));
		// Бежим по масиву и если есть инкриментируем значение. Если нет создаем
		// новый
		for (int i : arr) {

			if (!map.containsKey(i)) {
				map.put(i, 1);
			} else {
				map.put(i, (map.get(i)) + 1);
			}
		}
		System.out.println(map);

	}

}
