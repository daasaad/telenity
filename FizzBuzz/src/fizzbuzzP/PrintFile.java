package fizzbuzzP;

import java.io.File;
import java.io.BufferedWriter;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.IOException;

public class PrintFile implements Displayable {

	public static final String fileLoc = "/home/saadettins/output";

	public void display(String dispStr) {
		try {
			File file = new File(fileLoc);
			if (!file.exists()) {
				file.createNewFile();
			}
		/*	else
			{
				PrintWriter writer = new PrintWriter(file);
				writer.print("");
				writer.close();
			}*/
			PrintWriter out = new PrintWriter(new BufferedWriter(
					new FileWriter(file.getAbsoluteFile(), true)));
			out.print(dispStr);
			out.close();
		} catch (IOException e) {
		}
	}

	public void displayLine() {
		try {
			File file = new File(fileLoc);
			if (!file.exists()) {
				file.createNewFile();
			}
			PrintWriter out = new PrintWriter(new BufferedWriter(
					new FileWriter(file.getAbsoluteFile(), true)));
			out.println();
			out.close();
		} catch (IOException e) {
		}
	}
}