package httpClientP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;

public class Parser {
	public String user=null;
	public String passwd=null;
	public String msisdn=null;
	public String text=null;

	public String parseLine(String line) {
		int subIndex = line.indexOf('=');
		return line.substring(subIndex + 2);

	}

	public Parser(HttpResponse response) {

		BufferedReader rd = null;
		try {
			rd = new BufferedReader(new InputStreamReader(response.getEntity()
					.getContent()));
		} catch (IllegalStateException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		String line = "";
		try {
			while ((line = rd.readLine()) != null)
				if (line == "<body>") {

					user = rd.readLine();
					user = parseLine(user);

					passwd = rd.readLine();
					passwd = parseLine(passwd);

					msisdn = rd.readLine();
					msisdn = parseLine(msisdn);

					text = rd.readLine();
					text = parseLine(text);
					break;
				}
			if (line == null) {
				user = null;
				passwd = null;
				msisdn = null;
				text = null;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
