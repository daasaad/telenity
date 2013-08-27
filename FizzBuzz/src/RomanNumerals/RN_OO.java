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
 */
public class RN_OO {

	public static final int ONE = 1;
	public static final int TEN = 10;
	public static final int HUND = 100;
	public static final int THOU = 1000;
	
	public final static String LIMIT = "M";
	public final static int LIMITVALUE = THOU;
	
	public Displayable printer;
	public Scannable scanner;



	public RN_OO(Displayable printer, Scannable scanner) {
		this.printer = printer;
		this.scanner = scanner;
	}

	public void callConverter() {

		List<Integer> data = new ArrayList<Integer>();

		data = scanner.scan();

		int i = 0;
		int j = data.size();

		Converter converter = new Converter(data);

		while (i < j) {
			printer.display(converter.resultList[i]);
			printer.displayLine();
			i++;
		}
	}

	public class Converter {

		public String result = "";
		public String[] resultList;

		public Converter(List<Integer> numList) {
			int i = numList.size();
			resultList = new String[i];
			do {
				i--;
				convert(numList.get(i));
				resultList[i] = result;
			} while (i != 0);
		}

		public void convert(int number) {

			result = "";
			int i = this.getMaxValue(number);

			LimitCalc limitCalc = new LimitCalc();
			result = limitCalc.giveRomanString(number/LIMITVALUE);

			OrdinaryCalc ordinaryCalc = new OrdinaryCalc();
			for (i = LIMITVALUE / 10; i >= ONE; i = i / 10) {
				ordinaryCalc.set(i);
				result = result.concat(ordinaryCalc.giveRomanString(getDigit(i,
						number)));
			}
		}

		public int getMaxValue(int number) {

			int i = number;
			int digitValue = 1;
			while (i / 10 != 0) {
				i = i / 10;
				digitValue *= 10;
			}
			System.out.println(digitValue);
			return digitValue;
		}

		public int getDigit(int digitValue, int number) {
			int i = number / digitValue;
			return i % 10;
		}

		public abstract class DigitToRoman {

			public String I, V, X;

			public String giveRomanString(int digit) {

				int i = digit;
				String romanString = "";
				if (digit == 9)
					romanString = I + X;
				else if (digit == 4)
					romanString = I + V;
				else {
					if (digit >= 5) {
						romanString = V;
						i = i - 5;
					}
					while (i-- != 0)
						romanString = romanString.concat(I);
				}
				return romanString;
			}

		}

		public class OrdinaryCalc extends DigitToRoman {
			public void set(int digitValue) {
				switch (digitValue) {
				case ONE:
					I = "I";
					V = "V";
					X = "X";
					break;
				case TEN:
					I = "X";
					V = "L";
					X = "C";
					break;
				case HUND:
					I = "C";
					V = "D";
					X = "M";
					break;
				// case THOU:
				default:
					I = "";
					V = "";
					X = "";

				}
			}
		}

		public class LimitCalc extends DigitToRoman {

			public String giveRomanString(int digit) {

				try {
					if (digit > 3)
						throw new IllegalArgumentException("");
				} catch (IllegalArgumentException e) {
					System.exit(0);
				}

				String romanString = "";
				int i = digit;
				while (i-- != 0)
					romanString = romanString.concat(LIMIT);
				return romanString;
			}

		}
	}

	public static void main(String[] args) throws FileNotFoundException {

		Displayable printer = new PrintScreen();
		Scannable scanner = new ConsoleScanner();
		RN_OO romanNumerals = new RN_OO(printer, scanner);
		romanNumerals.callConverter();
	}
}
