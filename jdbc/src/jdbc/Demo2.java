package jdbc;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Scanner;

/*
 * Example of PreparedStatement and Date Object handling.
 * Conversion of util.Date to sql.Date
 * */
public class Demo2 {

	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/orclpdb", "sys as sysdba",
				"orcl");
		String sql = "insert into student values(?,?,?)";
		PreparedStatement psmt = con.prepareStatement(sql);
		System.out.print("Enter id: ");
		int id = scan.nextInt();
		psmt.setInt(1, id);
		System.out.print("Enter name: ");
		String name = scan.next();
		psmt.setString(2, name);
		System.out.print("Enter Date of Birth(dd-mm-yyyy): ");
		String date = scan.next();
		scan.close();
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		java.util.Date udate = sdf.parse(date);
		long l = udate.getTime();
		java.sql.Date sdate = new java.sql.Date(l);
		psmt.setDate(3, sdate);
		int update = psmt.executeUpdate();
		System.out.println(update + " no. of rows updated.");
	}

}
