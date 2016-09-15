package HomeWork101;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class EngToUkr {
	private Slovar slovar;

	private EngToUkr() {
		super();
	}

	public EngToUkr(Slovar slovar) {
		super();
		this.slovar = slovar;
	}

	public void translate(File engIn, File ukrOut) {
		try (BufferedReader brEng = new BufferedReader(new FileReader(engIn));
				BufferedWriter brUkr = new BufferedWriter(new FileWriter(ukrOut))) {
			String eng;
			while ((eng = brEng.readLine()) != null) {
				eng = eng.toLowerCase();
				String[] str = eng.split(" ");
				String transl = "";
				for (String string : str) {
					if (slovar.getPerevod(string)!=null) {
						transl += slovar.getPerevod(string) + " ";
					} else {
						transl += string + " ";
					}
				}
				brUkr.write(transl);
				brUkr.newLine();

			}

		} catch (IOException e) {
			// TODO: handle exception
			System.out.println(e);
		}

	}

}
