package studentManager.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	
	public static Connection getConnection() {
		final String driverName = "oracle.jdbc.driver.OracleDriver";
		try {
			Class.forName(driverName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		final String url = "jdbc:oracle:thin:@192.168.200.199:1521:orcl";
		try {
			Connection connection = DriverManager.getConnection(url, "db_student", "test");
			connection.setAutoCommit(false);
			return connection;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
