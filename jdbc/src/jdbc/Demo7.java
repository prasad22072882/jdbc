package jdbc;

import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.*;

/*
 * Retrieve image(BLOB) type data from database.
 * */
public class Demo7 {
	public static void main(String[] args) throws SQLException, IOException {
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/orclpdb", "sys as sysdba",
				"orcl");
		Statement smt = con.createStatement();
		ResultSet rs = smt.executeQuery("select * from image");
		FileOutputStream fout;
		int i = 1;
		while (rs.next()) {
			System.out.println(rs.getString(1) + " " + rs.getBlob(2));
			fout = new FileOutputStream("D:\\" + rs.getString(1) + i + ".jpg");
			byte[] img = rs.getBytes(2);
			fout.write(img);
			fout.close();
			i++;
		}
	}
}
