package httpClientP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;

public class Parser {

	public String user = null;
	public String passwd = null;
	public String msisdn = null;
	public String text = null;

	public ResponseCodes returnError() {

		boolean invalidMSISDN = false;
		try {
			Integer.parseInt(msisdn.substring(0, 9));
			Integer.parseInt(msisdn.substring(9));
		} catch (NumberFormatException e) {
			invalidMSISDN = true;
			System.out.println("catch" + msisdn);
		}
		
		if (user.isEmpty() || passwd.isEmpty())
			return ResponseCodes.MISSING_PARAMETER;
		else if (invalidMSISDN)
			return ResponseCodes.INVALID_MSISDN;
		else if (!user.contentEquals("ssad") || !passwd.contentEquals("pass123")) {
			return ResponseCodes.AUTHENTICATION_FAILED;
		} else
			return ResponseCodes.OK;
	}

	public String parseLine(String line) {
		int subIndex = line.indexOf('=');
		return (String)line.substring(subIndex + 2);
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

		try {
			user = rd.readLine();
			user = parseLine(user);

			passwd = rd.readLine();
			passwd = parseLine(passwd);

			msisdn = rd.readLine();
			msisdn = parseLine(msisdn);

			text = rd.readLine();
			text = parseLine(text);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
