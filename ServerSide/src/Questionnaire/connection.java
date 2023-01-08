package Questionnaire;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class connection {
	
	Connection connection;
	public connection() {
		try {
			connection = DriverManager.getConnection("jdbc:mysql://funmaths.cymfgpdjcecz.us-west-1.rds.amazonaws.com:3306/funMaths","root","root1234");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
public Connection get() {
	return connection;
}

}
