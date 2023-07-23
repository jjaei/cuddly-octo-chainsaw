package com.it.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/Order")
public class OrderServlet extends HttpServlet {
	public OrderServlet() {
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		System.out.println("[OrderServlet(Service)] Get Called");
		
		// request에서 parameter를 꺼내는 방법
		String food = request.getParameter("ramyun");
		String price = request.getParameter("price");
		String loc = request.getParameter("location");
		System.out.println(request.getContextPath());
		
		response.getWriter().append("Served At: ").append(request.getContextPath());
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		out.write("<br><br><hr>");
		out.write("손님께서 주문하신 음식은 " + food + "(" + loc + ") 입니다.<br>");
		
		// 보낸 price의 열 배로 가격을 받는다.
		out.write("총 가격은 " + Integer.parseInt(price) * 10 + "원 입니다.");
	}
}
