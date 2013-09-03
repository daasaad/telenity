package httpClientP;

import org.apache.http.client.methods.HttpGet;

public class SmsServletClient {

	public HttpGet request(String url) {
		HttpGet request = new HttpGet(url);
		return request;
	}

}
