package httpClientP;

public class SmsServletRequest {
	private String user = null;
	private String passwd = null;
	private String msisdn = null;
	private String text = null;

	public void setUser(String user) {
		this.user = user;
	}

	public String getUser() {
		return this.user;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getPasswd() {
		return this.passwd;
	}

	public void setMSISDN(String msisdn) {
		this.msisdn = msisdn;
	}

	public String getMSISDN() {
		return this.msisdn;
	}

	public void setText(String message) {
		this.text = message;
	}

	public String getText() {
		return this.text;
	}

}
