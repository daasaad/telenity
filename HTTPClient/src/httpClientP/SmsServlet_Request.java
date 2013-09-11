package httpClientP;


import java.io.Serializable;
import java.lang.String;
import java.sql.Timestamp;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: SmsServletRequest
 * 
 */
@Entity(name = "SmsServletRequest")
@Table(name = "smsservlet_request")
public class SmsServlet_Request implements Serializable {

	

	private static final long serialVersionUID = 7811219408234230083L;
	@Column(name = "ID")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name = "USER")
	private String user;
	@Column(name = "PASSWD")
	private String passwd;
	@Column(name = "MSISDN")
	private String msisdn;
	@Column(name = "TIMESTAMP")
	private Timestamp timestamp;
	@Column(name = "TEXT")
	private String text;

	public SmsServlet_Request() {
		super();
	}

	public String getUser() {
		return this.user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPasswd() {
		return this.passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getMsisdn() {
		return this.msisdn;
	}

	public void setMsisdn(String msisdn) {
		this.msisdn = msisdn;
	}

	public Timestamp getTimestamp() {
		return this.timestamp;
	}

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}

	public String getText() {
		return this.text;
	}

	public void setText(String text) {
		this.text = text;
	}

}
