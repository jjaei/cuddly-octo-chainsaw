package day08.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class Ex38_DBConnect {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Connection conn = null;
		
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			conn = DriverManager.getConnection( /* 내용 생략 */ );
		} catch(Exception e) {
			System.out.println("Exception Occurred");
		}
		
		if(conn != null) {
			System.out.println("Congratulations!");
			System.out.println("Database Connection OK.");
			System.out.println(conn);
		}
	}
} 
