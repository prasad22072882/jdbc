package jdbc;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.*;

/*
 * insert image(BLOB) type data into database.
 * */
public class Demo6 {
	public static void main(String[] args) throws FileNotFoundException, SQLException {
		File f = new File("D:\\git repository\\jdbc\\jdbc\\src\\jdbc\\car-wallpaper.jpg");
		FileInputStream fis = new FileInputStream(f);
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/orclpdb", "sys as sysdba",
				"orcl");
		PreparedStatement psmt = con.prepareStatement("insert into image values(?,?)");
		psmt.setString(1, "car wallpaper");
		psmt.setBinaryStream(2, fis);
		int update = psmt.executeUpdate();
		System.out.println(update + " rows affected.");
	}
}
