package day08.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class Ex38_DBConnect {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Connection conn = null;
		
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mariadb://localhost:포트번호/데이터베이스명",
					"이름",
					"패스워드"
					);
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
