package GUI;

import java.sql.DriverManager;
import java.sql.SQLException;

public class DBconnection {

	public DBconnection() {
		try {
			DriverManager.getConnection("jdbc:mysql://localhost:3306/funMaths",
					"root", "root1234");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
