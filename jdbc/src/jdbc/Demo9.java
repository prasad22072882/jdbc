package jdbc;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.sql.*;

import oracle.jdbc.pool.OracleDataSource;

/*
 * Example of connection to database using DataSource (connection pooling)
 * */
public class Demo9 {
	public static void main(String[] args) throws IOException, SQLException {
		DataSource ds = MyDataSource.getDataSource();
		Connection con = ds.getConnection();
		Statement smt = con.createStatement();
		ResultSet rs = smt.executeQuery("select * from student");
		while (rs.next()) {
			System.out.println(rs.getInt(1) + " " + rs.getString(2));
		}
	}
}

class MyDataSource {
	public static DataSource getDataSource() throws IOException, SQLException {
		Properties props = new Properties();
		FileInputStream fis = new FileInputStream("D:\\git repository\\jdbc\\jdbc\\src\\jdbc\\db.properties");
		props.load(fis);
		OracleDataSource oracleDataSource = new OracleDataSource();
		oracleDataSource.setURL(props.getProperty("url"));
		oracleDataSource.setUser(props.getProperty("user"));
		oracleDataSource.setPassword(props.getProperty("password"));
		return oracleDataSource;
	}
}
