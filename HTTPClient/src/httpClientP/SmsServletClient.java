package httpClientP;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

public class SmsServletClient extends DefaultHttpClient {

	public HttpResponse processRequest(String user, String passwd, String msisdn, String text) {

		String url = "http://localhost:8080/HelloWorldServlet/servlet?"
				+ "user=" + user + "&passwd=" + passwd + "&msisdn=" + msisdn
				+ "&text=" + text;
		HttpGet httpGet = new HttpGet(url);
		HttpResponse response = null;
		try {
			response = super.execute(httpGet);
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return response;
	}

}
