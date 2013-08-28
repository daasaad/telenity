package fizzbuzzP;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.junit.Test;

public class FizzBuzzWithDispInterfaceTest {

	public static final int PARAM1 = 3;
	public static final int PARAM2 = 5;

	@Test
	public void test() {
		List<String> output = new ArrayList<String>();
		FizzBuzzWithDispInterface fizzbuzz = new FizzBuzzWithDispInterface(null);
		output = fizzbuzz.processFizzBuzz(PARAM1, PARAM2);
		int size = output.size();
		int i = 0;
		while (i < size) {
			if ((i+1) % 15 == 0)
				Assert.assertEquals(Integer.toString(i+1), "FizzBuzz",
						output.get(i));
			else if ((i+1) % 3 == 0)
				Assert.assertEquals("Fizz", output.get(i));
			else if ((i+1) % 5 == 0)
				Assert.assertEquals("Buzz", output.get(i));
			else
				Assert.assertEquals(Integer.toString(i+1), output.get(i));
			i++;
		}
		
	}
}
