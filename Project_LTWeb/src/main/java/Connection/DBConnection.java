package Connection;

import java.sql.Connection;
import java.sql.DriverManager;
 
public class DBConnection {

<<<<<<< HEAD
	private final String serverName = "VANTUAN";
=======
	private final String serverName = "DESKTOP-IK5D1LO";
>>>>>>> f2963754281288bc0d272bfbfdc6f18ee2d90e1a
	private final String dbName = "DB_Project_LTWeb";
	private final String portNumber = "1433";
	private final String instance = "SQLEXPRESS";// MSSQLSERVER LEAVE THIS ONE EMPTY IF YOUR SQL IS A SINGLE INSTANCE
	private final String userID = "sa";
	private final String password = "123456";

	public Connection getConnection() throws Exception {
		String url = "jdbc:sqlserver://" + serverName + "\\" + instance + ";databaseName=" + dbName;
		if (instance == null || instance.trim().isEmpty())
			url = "jdbc:sqlserver://" + serverName + ":" + portNumber + ";databaseName=" + dbName;
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		return DriverManager.getConnection(url, userID, password);
	}

	public static void main(String[] args) {
		try {
			System.out.println("Kết nối DB_Project_LTWeb thành công");
			System.out.println(new DBConnection().getConnection());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
