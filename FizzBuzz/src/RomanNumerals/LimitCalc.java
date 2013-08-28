package RomanNumerals;


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
			romanString = romanString.concat(RomanNumerals.LIMIT);
		return romanString;
	}

}