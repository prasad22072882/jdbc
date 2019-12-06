package jdbc;

import java.sql.*;

/*
 * 1. Load the Driver class
 * 2. get the connection
 * 3. Create statement
 * 4. Execute query
 * 5. Get the result set
 * 6. Retrieve the result from ResultSet
 * 7. close the connection
 * */
public class Demo1 {

	public static void main(String[] args) throws ClassNotFoundException {
//		Class.forName("oracle.jdbc.driver.OracleDriver");	// An advanced version of ojdbc.jar file automatically loads the driver class.
		try {
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/orclpdb", "sys as sysdba",
					"orcl");
			Statement smt = con.createStatement();
			ResultSet rs = smt.executeQuery("select * from student");
			while (rs.next()) {
				System.out.println(rs.getInt(1) + " : " + rs.getString(2));
			}
//			con.close();	// An advanced version of ojdbc.jar file automatically closes the connection.
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
