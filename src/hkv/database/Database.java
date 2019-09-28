package hkv.database;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;


public class Database {
	public static Connection con = null;
	private static Database instance = new Database();
	public static Database getInStance() {
		return instance;
	}
	public static void connect() {
		String url = "jdbc:sqlserver://localhost:1433;databaseNAME=HKVTravel;";
		String user = "sa";
		String password = "025825273a";
		try {
			con = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Kết nối thất bại!");
		}
	}
	public static void disconnect() {
		if(con!=null)
			try {
				con.close();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
	}
	public static Connection getConnection() {
		connect();
		return con;
	}
	public static void main(String[] args) {
		 connect();
	}
}
