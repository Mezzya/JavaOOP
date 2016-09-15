package HomeWork104;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class AsciiArt {

	private Map<Character, String[]> map = new HashMap<>();

	private AsciiArt(Map<Character, String[]> map) {
		super();
		this.map = map;
	}

	static AsciiArt loadFromFile(File file) {

		
		Map<Character, String[]> map = new HashMap<>();

		try (BufferedReader br = new BufferedReader(new FileReader(file))) {

			String str;
			String[] art = new String[7];
			int count = 0;
			char bukva = 'a';
			while ((str = br.readLine()) != null) {

				art[count] = str;

				count++;
				if (count == 7) {

					map.put(bukva, art);
					art = new String[7];

					count = 0;
					bukva++;
				}
			}

			return new AsciiArt(map);

		} catch (IOException e) {

			System.out.println("Error load ASCII form file");
		}

		return null;
	}

	public void print(char bukva) {

		if (map.containsKey(bukva)) {
			String[] art = map.get(bukva);

			for (String string : art) {
				System.out.println(string);
			}
		} else
			System.out.println(bukva);
	}

	public void print(String str) {
		char[] chars = str.toLowerCase().toCharArray();
		String[] output = new String[7];

		for (int i = 0; i < output.length; i++) {
			output[i] = "";
		}

		for (char ch : chars) {
			if (map.containsKey(ch)) {
				// Есть такая буква в алфавите
				String[] get = map.get(ch);
				for (int i = 0; i < output.length; i++) {
					output[i] += get[i];
				}
			} else {
				// Псевдовывов
				for (int i = 0; i < output.length - 1; i++) {
					output[i] += " ";
				}
				output[output.length - 1] += "" + ch;
			}
		}

		for (String st : output) {
			System.out.println(st);
		}

	}

}
