package jdbc;

import java.sql.*;

/*
 * Example of Batch update using Statement.
 * */
public class Demo4 {
	public static void main(String[] args) throws Exception {
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/orclpdb", "sys as sysdba",
				"orcl");
		Statement smt = con.createStatement();
		smt.addBatch("insert into student values(3, 'Roshan', '15-feb-2015')");
		smt.addBatch("insert into student values(4, 'Padmabati', '15-feb-2015')");
		smt.addBatch("insert into student values(5, 'Rajeswari', '15-feb-2015')");
		int update[] = smt.executeBatch();
		int rows = 0;
		for (int i = 0; i < update.length; i++) {
			rows += update[i];
		}
		System.out.println(rows + " rows affected.");
	}
}
