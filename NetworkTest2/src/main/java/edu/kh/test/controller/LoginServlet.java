package edu.kh.test.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/join")

public class LoginServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	// 로그인을 하는데에는 doGet이 부적합하며
		String inputId = req.getParameter("inputId");
		String inputPw = req.getParameter("inputPw");
		if(inputId.equals("user01") && inputPw.equals("pass01")) {
			req.setAttribute("message", "user01 로그인 성공!");
			String message = String.format("user01 로그인 성공!");
			String path = "/WEB-INF/views/result.jsp";
			req.setAttribute("searchMessage", message);
			// forward 경로를 완전히 다 작성하지 않음
			req.getRequestDispatcher(path).forward(req, resp);
			//req.setAttribute("searchMessage", message);
			
		}else {
			String message = "아이디 또는 비밀번호가 일치하지 않습니다.";
			//req.setAttribute("message", "아이디 또는 비밀번호가 일치하지 않습니다");
			HttpSession session = req.getSession();
			session.setAttribute("message", message); 
			
	
			resp.sendRedirect("/");
		}
	}
}