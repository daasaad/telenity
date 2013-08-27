package RomanNumerals;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileScanner implements Scannable {

	public static final String fileLoc = "/home/saadettins/input";
	File file;
	Scanner scanner;

	public List<Integer> scan() {
		List<Integer> data = new ArrayList<Integer>();
		try {
			file = new File(fileLoc);
			scanner = new Scanner(file);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		while (scanner.hasNextInt()) {
			try {
				data.add(Integer.parseInt(scanner.nextLine()));
			} catch (NumberFormatException e) {
				e.printStackTrace();
			}
		}
		
		scanner.close();

		return data;
	}
}