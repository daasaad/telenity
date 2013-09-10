package httpClientP;

import org.apache.http.HttpResponse;

public class HTTPClientExample {

	static final String USER = "ssad";
	static final String PASSWD = "pass123";
	static final String MSISDN = "123456789012";
	static final String TEXT = "Buanukkagueeagnab446";
	private String user;
	private String passwd;
	private String msisdn;
	private String text;
	public Holdable holdable;
	
	public HTTPClientExample(String user, String passwd, String msisdn, String text, Holdable holdable) {
		this.holdable = holdable;
		this.user = user;
		this.passwd = passwd;
		this.msisdn = msisdn;
		this.text = text;
	}

	public ResponseCodes HttpClientExecute() {
		
		SmsServletRequest request = new SmsServletRequest();
		request.setUser(user);
		request.setPasswd(passwd);
		request.setMSISDN(msisdn);
		request.setText(text);
		
		SmsServletClient client = new SmsServletClient();
		HttpResponse response = client.processRequest(request);
		Parser parser = new Parser(response);
		
		holdable.get(parser.user, parser.passwd, parser.msisdn, parser.text);
		
		return parser.returnError();	
	}

	public static void main(String[] args) throws Exception {
		Holdable holdable = new HolderSQL();
		HTTPClientExample example = new HTTPClientExample(USER, PASSWD, MSISDN, TEXT, holdable);
		System.out.println("ErrorCode for Response:" + example.HttpClientExecute().value());// just to check
	}
}
