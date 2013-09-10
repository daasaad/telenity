package httpClientP;

import java.sql.Connection;
import java.util.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

public class HolderSQL implements Holdable {
	
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/smsservlet";

	static final String USER = "root";
	static final String PASS = "bbb";

	public void get(String user, String passwd, String msisdn, String text) {

		Connection conn = null;
		PreparedStatement stmt = null;

		Date date = new Date();

		String query = " insert into smsservlet_request (USER, PASSWD, MSISDN, TIMESTAMP, TEXT)"
				+ " values (?, ?, ?, ?, ?)";

		try {
			Class.forName("com.mysql.jdbc.Driver");

			System.out.print("Connecting database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			System.out.println("Success!");

			System.out.print("Inserting records into the table...");
			stmt = conn.prepareStatement(query);

			stmt.setString(1, user);
			stmt.setString(2, passwd);
			stmt.setString(3, msisdn);
			stmt.setTimestamp(4, new Timestamp(date.getTime()));
			stmt.setString(5, text);

			stmt.execute();

			System.out.println("Success!");

		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					conn.close();
			} catch (SQLException se) {
			}
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
		System.out.println("Successful!");
	}
}