package httpClientP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

public class HTTPClientExample {

public static void main(String[] args) throws Exception {
	HttpClient client = new DefaultHttpClient();
  HttpGet request = new HttpGet("http://localhost:8080/HelloWorldServlet/servlet?user=ssad&passwd=eferferf&msisdn=0394034993&text=dsdfkdkfsdsdfsdfadsaafaf");

HttpResponse response = null;
try {
	response = client.execute(request);
} catch (ClientProtocolException e) {
	e.printStackTrace();
} catch (IOException e) {
	e.printStackTrace();
}

BufferedReader rd = null;
try {
	rd = new BufferedReader (new InputStreamReader(response.getEntity().getContent()));
} catch (IllegalStateException e1) {
	e1.printStackTrace();
} catch (IOException e1) {
	e1.printStackTrace();
}

String line = "";
try {
	while ((line = rd.readLine()) != null)
	  System.out.println(line);
} catch (IOException e) {
	e.printStackTrace();
}
	


}
}