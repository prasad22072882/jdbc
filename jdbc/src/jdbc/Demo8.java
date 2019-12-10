package jdbc;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

/* Example of connection using properties file
 * 
 * 1. Create a properties file
 * 2. Create a Properties Object in java
 * 3. Read data from properties file
 * 4. Load data to Properties Object
 * 5. get properties value
 * 6. Create Connection Object
 * 7. Communicate with database 
 * */
public class Demo8 {
	public static void main(String[] args) throws IOException, SQLException {
		Properties props = new Properties();
		FileInputStream fis = new FileInputStream("D:\\git repository\\jdbc\\jdbc\\src\\jdbc\\db.properties");
		props.load(fis);
		String url = props.getProperty("url");
		String user = props.getProperty("user");
		String password = props.getProperty("password");
		Connection con = DriverManager.getConnection(url, user, password);
		Statement smt = con.createStatement();
		ResultSet rs = smt.executeQuery("select * from student");
		while (rs.next()) {
			System.out.println(rs.getInt(1) + " " + rs.getString(2));
		}
	}
}
