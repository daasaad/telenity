package httpClientP;

public class HolderConsole implements Holdable {

	@Override
	public void get(String user, String passwd, String msisdn, String text) {
		System.out.println(user);
		System.out.println(passwd);
		System.out.println(msisdn);
		System.out.println(text);
	}

}
