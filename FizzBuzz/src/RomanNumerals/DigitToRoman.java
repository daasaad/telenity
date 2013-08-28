package RomanNumerals;

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