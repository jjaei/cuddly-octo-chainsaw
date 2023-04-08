package com.it.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;


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
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(conn != null) 
			System.out.println("[MemberDAO: MemberDAO()] DB Connected OK!");
	}
	
	// insert
	public int insert(MemberVO vo) {
		int memberno = vo.getMemberno();
		String id = vo.getId();
		String name = vo.getName();
		
		String sql = "insert into member values(" + memberno + ",'" + id + "','" + name +"')";
		System.out.println(sql);
		
		int result = 0;
		try {
		stmt = conn.createStatement();
		result = stmt.executeUpdate(sql);
		} catch (Exception e) {e.printStackTrace();}
		return result;
	}
	
	// select
	public ResultSet select(MemberVO vo) {
		ResultSet rs = null;
		
		String sql = "select * from member where 1=1";
		if(vo.getMemberno() != 0) 
			sql += " and memberno = " + vo.getMemberno();	
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
	
	// select 전건
	public ArrayList select() {
		String sql = "select * from member";
		ArrayList<MemberVO> members = new ArrayList();
		
		System.out.println("[MemberDAO:select()] Called");
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			MemberVO member;
			while(rs.next()) {
				member = new MemberVO();
				member.setMemberno(rs.getInt("memberno"));
				System.out.println("[MemberDAO:select()] memberno : " + rs.getInt("memberno"));
				member.setId(rs.getString("id"));
				member.setName(rs.getString("name"));
				members.add(member);
			}
		} catch (Exception e) {e.printStackTrace();}
		
		return members;
	}
	
	// 이름 중복검사 메서드
	public boolean checkName(String name) {
		String sql = "select 1 from member where name = ?";
		PreparedStatement pstmt = null;
		boolean check = false;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();
			
			// rs.next()가 true라는 것은 이름이 있음을 의미한다.
			if(rs.next()) {
				check = true;
			}
		} catch(Exception e) {e.printStackTrace();}
		return check;
	}
	
}
