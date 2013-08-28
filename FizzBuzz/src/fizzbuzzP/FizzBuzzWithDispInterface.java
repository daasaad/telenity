package fizzbuzzP;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * FizzBuzz w/ Casting, Parameters, Display Interface
 * 
 * @author saadettins
 */
public class FizzBuzzWithDispInterface {

	public static final String FIZZ = "Fizz";
	public static final String BUZZ = "Buzz";

	public static final int PARAM1 = 3;
	public static final int PARAM2 = 5;

	public static final Integer COUNTLIMIT = 101;

	public static int i = 0;

	public Displayable printer;

	public FizzBuzzWithDispInterface(Displayable printer) {
		this.printer = printer;
	}

	public boolean makeFizzBuzz(String strI, int param) {
		return ((i % param) == 0) || strI.contains("param");
	}

	public List<String> processFizzBuzz(int param1, int param2) {
		List<String> output = new ArrayList<String>();
		String strI;
		String fizzbuzz;
		boolean fizzy = false;
		
		while (++i < COUNTLIMIT) {
			strI = Integer.toString(i);
			fizzbuzz = "";
			if (fizzy = makeFizzBuzz(strI, param1))
				fizzbuzz = FIZZ;
			if (makeFizzBuzz(strI, param2))
				fizzbuzz = fizzbuzz.concat(BUZZ);
			else if (!fizzy)
				fizzbuzz = strI;
			output.add(fizzbuzz);
		}
		return output;
	}
	
	public void printArray(List<String> array) {
		final int size=array.size();
		int i=0;
		while (i<size){
			printer.display(array.get(i));
			printer.displayLine();
			i++;
		}
	}

	public static void main(String[] args) {
		Displayable printer = new PrintScreen();
		FizzBuzzWithDispInterface example = new FizzBuzzWithDispInterface(
				printer);
		example.printArray(example.processFizzBuzz(PARAM1, PARAM2));

	}

}