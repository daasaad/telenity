package RomanNumerals;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class StringScan {

	public static final String fileLoc = "/home/saadettins/input";
	File file;
	Scanner scanner;

	public HashMap<Integer, String> scan() {
		int i = 1;
		
		String alfa;
		HashMap<Integer, String> data = new HashMap<Integer, String>();
		try {
			file = new File(fileLoc);
			scanner = new Scanner(file);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		while (scanner.hasNextLine()) {
			alfa = scanner.nextLine();
			data.put(i, alfa);
			i++;

		}

		scanner.close();
		return data;
	}
}