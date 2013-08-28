package RomanNumerals;

import java.util.List;

public class Converter {

	public String[] convertList(List<Integer> numList) {
		int i = numList.size();
		String[] resultList = new String[i];
		do {
			i--;
			resultList[i] = convert(numList.get(i));
		} while (i != 0);
		return resultList;
	}

	public String convert(int number) {

		String result = "";
		int i = this.getMaxValue(number);

		LimitCalc limitCalc = new LimitCalc();
		result = limitCalc.giveRomanString(number/RomanNumerals.LIMITVALUE);

		OrdinaryCalc ordinaryCalc = new OrdinaryCalc();
		for (i = RomanNumerals.LIMITVALUE / 10; i >= RomanNumerals.ONE; i = i / 10) {
			ordinaryCalc.set(i);
			result = result.concat(ordinaryCalc.giveRomanString(getDigit(i,
					number)));
		}
		return result;
	}

	public int getMaxValue(int number) {

		int i = number;
		int digitValue = 1;
		while (i / 10 != 0) {
			i = i / 10;
			digitValue *= 10;
		}
		return digitValue;
	}

	public int getDigit(int digitValue, int number) {
		int i = number / digitValue;
		return i % 10;
	}
}