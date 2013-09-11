package httpClientP;

public class HolderConsole implements Holdable {

	@Override
	public void get(SmsServlet_Request data) {
		System.out.println(data.getUser());
		System.out.println(data.getPasswd());
		System.out.println(data.getMsisdn());
		System.out.println(data.getText());
	}

}
