package com.it.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import com.it.db.MemberDAO;
import com.it.db.MemberVO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet({"/Member", "/Join"})
public class MemberServlet extends HttpServlet {
	
	public MemberServlet() {
		super();
		System.out.println("MemberServlet:MemberServlet()] Instance Created");
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("[MemberServlet] New Member, Welcome!");
		MemberDAO dao = new MemberDAO();
		MemberVO vo = new MemberVO();
		int memberno = Integer.parseInt(request.getParameter("memberno"));
		String id = request.getParameter("id");
		
		String name = request.getParameter("name");
		vo.setMemberno(memberno);
		vo.setId(id);
		vo.setName(name);
		
		int result = dao.insert(vo);
		System.out.println("[MemberServlet : doGet()] " + result +"건이 인서트 되었습니다.");
//		vo.setMemberNo(0);
//		vo.setId("Jason");
//		vo.setName("ABCDEFG");
		
		ResultSet rs = dao.select(new MemberVO());
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		try {
			while(rs.next()) {
				out.println("<hr>");
				out.println(rs.getInt("memberno") + "<br>");
				out.println(rs.getString("id") + "<br>");
				out.println(rs.getString("name") + "<br>");
			}
		} catch(Exception e) {e.printStackTrace();}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
