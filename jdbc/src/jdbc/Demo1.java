package jdbc;

import java.sql.*;

public class Demo1 {

	public static void main(String[] args) throws ClassNotFoundException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		try {
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/orclpdb", "sys as sysdba",
					"orcl");
			Statement smt = con.createStatement();
			ResultSet rs = smt.executeQuery("select * from student");
			while (rs.next()) {
				System.out.println(rs.getInt(1) + " : " + rs.getString(2));
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
