package com.it.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/MyServlet")   // 서비스 요청 중 MyServlet을 만나면 HttpServlet이 호출 됨.
public class MyServlet extends HttpServlet {
	public MyServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		System.out.println("[MyServlet(Service)] Get Called");
		PrintWriter out = response.getWriter();
		out.println("<html><body><h1>Webpage made by Servlet</h1>");
		out.println("</body></html>");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		System.out.println("[MyServlet(Service)] Get Called");
		PrintWriter out = response.getWriter();
		out.println("<html><body><h1>Webpage made by Servlet</h1>");
		out.println("</body></html>");
	}
}
