package com.it.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class MemberDAO {

	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	
	public MemberDAO() {
		try {
			System.out.println("MemberDAO Created.");
			Class.forName("org.mariadb.jdbc.Driver");
			
			conn = DriverManager.getConnection(
					"jdbc:mariadb://localhost:3399/member",
					"root",
					"1234"
					);	
		} catch(Exception e) {e.printStackTrace();}
	
	
		if(conn != null)
			System.out.println("[MemberDAO : MemberDAO()] DB Conneced OK!");
	}
	
	// insert
	public int insert(MemberVO vo) {
		int memberno = vo.getMemberNo();
		String id = vo.getId();
		String name = vo.getName();
		
		String sql = "insert into member values(" + memberno + ",'" + id + "','" + name + "')";
		System.out.println(sql);
		
		int result = 0;
		try {
			stmt = conn.createStatement();
			result=stmt.executeUpdate(sql);
		} catch(Exception e) {e.printStackTrace();}
		return result;
	}

	// select
	public ResultSet select(MemberVO vo) {
		ResultSet rs = null;
		String sql = "select * from member where 1=1";
		if(vo.getMemberNo() != 0) 
			sql += " and memberno = " + vo.getMemberNo();	
		if(vo.getId() != null) 
			sql += " and id = '" + vo.getId() + "'";
		if(vo.getName() != null)
			sql += " and name = '" + vo.getName() + "'";
		System.out.println(sql);
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
		} catch(Exception e) {e.printStackTrace();}
		return rs;
	}
}
