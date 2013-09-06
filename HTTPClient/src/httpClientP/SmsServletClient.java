package httpClientP;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

public class SmsServletClient extends DefaultHttpClient {

	public HttpResponse processRequest(SmsServletRequest request) {
		
		String url = "http://localhost:8080/HelloWorldServlet/servlet?"
				+ "user=" + request.getUser() + "&passwd="
				+ request.getPasswd() + "&msisdn=" + request.getMSISDN()
				+ "&text=" + request.getText();
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
