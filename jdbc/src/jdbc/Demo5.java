package jdbc;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Scanner;

/*
 * Example of Batch update using PreparedStatement.
 * */
public class Demo5 {
	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		String name, date;
		int id;
		long l;
		java.util.Date udate;
		java.sql.Date sdate;
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/orclpdb", "sys as sysdba",
				"orcl");
		PreparedStatement psmt = con.prepareStatement("insert into student values(?,?,?)");

		System.out.print("Enter id: ");
		id = scan.nextInt();
		psmt.setInt(1, id);
		System.out.print("Enter name: ");
		name = scan.next();
		psmt.setString(2, name);
		System.out.print("Enter date(dd-mm-yyyy): ");
		date = scan.next();
		udate = sdf.parse(date);
		l = udate.getTime();
		sdate = new java.sql.Date(l);
		psmt.setDate(3, sdate);
		psmt.addBatch();

		System.out.print("Enter id: ");
		id = scan.nextInt();
		psmt.setInt(1, id);
		System.out.print("Enter name: ");
		name = scan.next();
		psmt.setString(2, name);
		System.out.print("Enter date(dd-mm-yyyy): ");
		date = scan.next();
		udate = sdf.parse(date);
		l = udate.getTime();
		sdate = new java.sql.Date(l);
		psmt.setDate(3, sdate);
		psmt.addBatch();
		scan.close();

		int update[] = psmt.executeBatch();
		int rows = 0;
		for (int i = 0; i < update.length; i++) {
			rows += update[i];
		}
		System.out.println(rows + " rows affected.");
		scan.close();
	}
}
