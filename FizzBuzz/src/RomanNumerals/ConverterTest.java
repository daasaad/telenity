/**
 * 
 */
package RomanNumerals;

import java.util.HashMap;

import junit.framework.Assert;

import org.junit.Test;

/**
 * @author saad
 * 
 */
public class ConverterTest {

	@Test
	public void test() {

		StringScan stringScan = new StringScan();
		HashMap<Integer, String> romansMap = stringScan.scan();

		Converter converter = new Converter();
		int i;
		for (i = 1; i <= romansMap.size(); i++) {
			Assert.assertEquals(romansMap.get(i), Integer.toString(i) + "="
					+ converter.convert(i));
		}
	}

}
