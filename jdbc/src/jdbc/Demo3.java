package jdbc;

import java.sql.*;
import java.text.SimpleDateFormat;

/*
 * Example of retrieve data and conversion of sql.Date to util.Date
 * */
public class Demo3 {
	public static void main(String[] args) throws Exception {
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/orclpdb", "sys as sysdba",
				"orcl");
		Statement smt = con.createStatement();
		String sql = "select * from student";
		ResultSet rs = smt.executeQuery(sql);
//		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");	//10-12-2019
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy"); // 10-Dec-2019
		while (rs.next()) {
			System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + sdf.format(rs.getDate(3)));
		}
	}
}
