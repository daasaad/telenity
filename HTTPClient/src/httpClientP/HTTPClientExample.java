package httpClientP;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;

public class HTTPClientExample {

	static final String MY_URL = "http://localhost:8080/HelloWorldServlet/servlet?user=ssad&passwd=pass123&msisdn=0394034993&text=Message123";
	public String url = null;

	public HTTPClientExample(String url) {
		this.url = url;
	}

	public void HttpClientExecute() {
		SmsServletClient client = new SmsServletClient();
		HttpGet request = (HttpGet) client.request(url);
		SmsServletResponser responser = new SmsServletResponser();
		HttpResponse response = responser.executeResponse(request);
		Parser parser = new Parser(response);
		SmsServletRequest data = new SmsServletRequest();
		data.setUser(parser.user);
		data.setPasswd(parser.passwd);
		data.setMSISDN(parser.msisdn);
		data.setText(parser.text);
		data.show();// just to check
	}

	public static void main(String[] args) throws Exception {
		HTTPClientExample example = new HTTPClientExample(MY_URL);
		example.HttpClientExecute();
	}

}
