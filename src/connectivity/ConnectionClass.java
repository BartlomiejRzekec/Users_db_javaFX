package connectivity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionClass {

	
	public Connection getConnection() throws SQLException {
		
		String dbName = "users_db";
		String user = "root";
		String password = "root";
		
		Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/" + dbName + "?autoReconnect=true&useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", user, password);
		
		return connection;
	}
	
}
