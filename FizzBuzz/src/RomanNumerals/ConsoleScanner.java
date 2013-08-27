package RomanNumerals;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsoleScanner implements Scannable {
	public List<Integer> scan() {
		Scanner scan = new Scanner(System.in);
		List<Integer> data = new ArrayList<Integer>();
		data.add(scan.nextInt());
		scan.close();
		return data;
	}
}
