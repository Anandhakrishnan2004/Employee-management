package Employee_app;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * @author Hridya
 *
 */
public class DBConnection {
	static Connection con;

	public static Connection createDBConnection() {
		//load driver
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			//get connection
			String url = "jdbc:mysql://localhost:3306/employeeDB";
			String username = "root";
			String password = "@nandhu08";

			con = DriverManager.getConnection(url, username, password);

		} catch (Exception e) {
			e.printStackTrace();
		}
		//get connection
		return con;
	}
}
