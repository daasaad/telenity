package fizzbuzzP;

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

	public void processFizzBuzz(int param1, int param2) {
		String strI;
		boolean fizzy = false;
		
		while (++i < COUNTLIMIT) {
			strI = Integer.toString(i);
			if (fizzy = makeFizzBuzz(strI, param1))
				printer.display(FIZZ);
			if (makeFizzBuzz(strI, param2))
				printer.display(BUZZ);
			else if (!fizzy)
				printer.display(strI);
			printer.displayLine();
		}
	}

	public static void main(String[] args) {
		Displayable printer = new PrintScreen();
		FizzBuzzWithDispInterface example = new FizzBuzzWithDispInterface(
				printer);
		example.processFizzBuzz(PARAM1, PARAM2);
	}

}