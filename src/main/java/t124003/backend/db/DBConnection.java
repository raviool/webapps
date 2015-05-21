package t124003.backend.db;
import java.sql.*;
import java.util.*;

public class DBConnection {
	public static Connection getConnection() {
		Connection c = null;  
		String url = "";
		String password = "";
		String user = "";
		
		try {            
			ResourceBundle rb = ResourceBundle.getBundle("DBConnection");
			Class.forName(rb.getString("Driver"));
			url = rb.getString("url");
			user = rb.getString("usr");
			password = rb.getString("pwd");
			c = DriverManager.getConnection(url, user, password);
		} catch(Exception e) {  
			System.out.println(e + e.getMessage());
		}
		
		return c;
	}

	public static void close(final Connection c) {
		if (c != null) {
			try {
				c.close();
			} catch (SQLException e) {
				System.out.println(e +  e.getMessage());
			}
		}
	}

	public static void closeStatement(final Statement s) {
		if (s != null) {
			try {
				s.close();
			} catch (SQLException e) {
				System.out.println(e + e.getMessage());
			}
		}
	}


	public static void closeResultSet(final ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				System.out.println("DBConnection.closeResult()" + e.getMessage());
			}
		}
	}
}