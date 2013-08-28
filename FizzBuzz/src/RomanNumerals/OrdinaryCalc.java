package RomanNumerals;


public class OrdinaryCalc extends DigitToRoman {
	public void set(int digitValue) {
		switch (digitValue) {
		case RomanNumerals.ONE:
			I = "I";
			V = "V";
			X = "X";
			break;
		case RomanNumerals.TEN:
			I = "X";
			V = "L";
			X = "C";
			break;
		case RomanNumerals.HUND:
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