package edu.kh.jsp.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/signup")
public class SignupServlet extends HttpServlet{
	
	// a 태그 요청
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// forward를 통해 signup.jsp로 통해 응답
		String path ="/WEB-INF/views/redirect/signup.jsp";
		req.getRequestDispatcher(path).forward(req, resp);
		
	

		
	}
	
	// form 태그 제출(POST) 처리
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 파라미터 얻어오기
		
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		String pwCheck = req.getParameter("pwCheck");
		
		// pw, pwCheck가 일치하면 "(id) 회원 가입 성공"
		// 일치하지 않으면 "비밀번호 불일치"
		// 라고 하는 메시지를 message 변수에 저장
		
		String message = null;
		if(pw.equals(pwCheck)) {
			message = id + " 회원 가입 성공";
		}else { 
			message = "비밀번호 불일치";
		}
		
		// Servlet 코드 수행이 완료된 후 
		// 원래 존재하던 페이지로 이동하거나(회원가입 실패시)
		// 응답할 화면이 별도로 존재하지 않은 경우
		// *** redirect *** 수행함
		
		// req.setAttribute("message", message); -> 실행 안됨
		
		// redirect 수행시 이전 요청이 담긴 request 객체가 삭제되고
		// 새로운 요청이 담김 request 객체가 생성된다.
		// - 이전 request에 message가 세팅되었기 때문에 새로운 request에는
		//  존재하지 않음 -> 출력X
		
		/* 해결 방법
		 * session 객체를 이용
		 * session은 redirect해도 사라지지 않고 갱신되지도 않음. 브라우저 종료/만료 전까지 유지 
		 * */
		
		resp.sendRedirect("/signup");
		HttpSession session = req.getSession(); // session객체 얻어옴
		session.setAttribute("message", message); // session에 message 추가
		
		// redirect는 무조건 GET 방식 요청
		// ("/") : 메인페이지로 이동함
		
		
		
		
		
		
	}
	
	
	
	
	

}
