package RomanNumerals;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import fizzbuzzP.Displayable;
import fizzbuzzP.PrintFile;
import fizzbuzzP.PrintScreen;

/**
 * Decimal Numbers to Roman Numerals 
 * validinput(0,3999)
 * Deneme, commit and push deneme 2!
 */
public class RomanNumerals {

	public static final int ONE = 1;
	public static final int TEN = 10;
	public static final int HUND = 100;
	public static final int THOU = 1000;
	
	public final static String LIMIT = "M";
	public final static int LIMITVALUE = THOU;
	
	public Displayable printer;
	public Scannable scanner;


	public RomanNumerals() {
	}

	public RomanNumerals(Displayable printer, Scannable scanner) {
		this.printer = printer;
		this.scanner = scanner;
	}

	public void callConverter() {

		List<Integer> data = new ArrayList<Integer>();

		data = scanner.scan();

		int i = 0;
		int j = data.size();

		Converter converter = new Converter();
		String[] resultList = converter.convertList(data);

		while (i < j) {
			printer.display(resultList[i]);
			printer.displayLine();
			i++;
		}
	}
	public static void main(String[] args) throws FileNotFoundException {

		Displayable printer = new PrintScreen();
		Scannable scanner = new ConsoleScanner();
		RomanNumerals romanNumerals = new RomanNumerals(printer, scanner);
		romanNumerals.callConverter();
	}
}
