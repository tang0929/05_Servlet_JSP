package edu.kh.jsp.controller;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


/* @WebServlet("주소")
 * 1. 현재 클래스를 Servlet으로 등록(서버 실행 시 자동으로 객체화됨)
 * 2. ("주소")와 Servlet을 매핑해서 요청/응답 처리 할 수 있게함 */


@WebServlet("/signup")
public class SignupServlet extends HttpServlet{
	
	// method = "GET"   == doGet() 오버라이딩
	// method = "POST"  == doPost() 오버라이딩
	
	
	// dopost 입력 후 자동완성시 오버라이딩 완성
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 자동완성 된 후 {} 안의 내용 지우기
		
		// 파라미터(== 전달 인자, 전달된 값) (항상 String으로 받아옴)
		
		String inputId = req.getParameter("inputId");
		String inputPw = req.getParameter("inputPw");
		String inputPwCheck = req.getParameter("inputPwCheck");
		String inputName = req.getParameter("inputName");
		String inputAge = req.getParameter("inputAge");
		
		System.out.println("inputID = " + inputId);
		System.out.println("inputPw = " + inputPw);
		System.out.println("inputPwCheck = " +inputPwCheck);
		System.out.println("inputName = " + inputName);
		System.out.println("inputAge = " + inputAge);
		
		
		
		// 조건 넣기
		
		
		// 비밀번호, 비밀번호 확인이 불일치 하면 
		// 비밀번호가 일치하지 않습니다.
		
		// 나이가 14세 미만인 경우
		// 14세 이상만 가입 가능합니다.
		
		// 모두 충족시
		// 가입 성공
		// 아이디, 비밀번호, 이름 나이를 ul, li태그를 이용해 출력
		
		
		// ---------------------------------------------------------
		
		
		/* JSP를 이용해서 응답하기 */
		
		/* 1. JSP 파일 작성
		 *  -> src/main/webapp/WEB-INF/views/ 폴더에 작성
		 *  
		 * 2. Servlet이 요청 될 때 생성된
		 * HttpServletRequest, HttpServletResponse 객체를 
		 * 응답 화면을 대신 만들어서 응답해줄 JSP에서 전달  == 요청 위임(forward)
		 * 
		 * 
		 */
		
		/* RequestDispatcher 객체 
		 * 어떤 JSP로 요청을 위임할지 지정하고 발송해주는 객체 
		 * HttpServletRequest에 내장되어 있음 */
		
		
		// 요청 위임할 JSP 경로를 path라고 설정
		// src/main/webapp 폴더를 기준으로 파일 경로로 작성
		// / : webapp 기준으로 시작
		String path = "/WEB-INF/views/signup_result.jsp";
		RequestDispatcher dispatcher = req.getRequestDispatcher(path);
		
		dispatcher.forward(req, resp); // 지정된 JSP로 요청 위임
		
		
		
		
		
		
		
		
		
		
		
		
//		// 응답 형태 지정
//		resp.setContentType("text/html; charset = utf-8");
//		
//		// 출력용 스트림 얻어오기 
//		PrintWriter out = resp.getWriter();
//		StringBuilder sb = new StringBuilder();
//		
//		sb.append("<!DOCTYPE HTML>");
//		sb.append("<html>");
//		
//		sb.append("<head>");
//		sb.append("<title>회원 가입 결과</title>");
//		sb.append("</head>");
//		
//		
//		sb.append("<body>");
//		
//		
//		if(!inputPw.equals(inputPwCheck)) { 
//			// 비밀번호와 비밀번호확인이 불일치하다면
//			sb.append("<h3>비밀번호가 일치하지 않습니다.</h3>");
//			
//		} else if( Integer.parseInt(inputAge) < 14) {
//			// 나이가 14세 미만인지 확인
//			// inputAge가 String으로 받아왔으므로 Integer.parseInt 사용해서 정수로 비교하게 함
//			sb.append("<h3>14세 이상만 가입 가능합니다.</h3>");
//		}
//		else {
//			sb.append("<h3>가입 성공</h3>");
//			sb.append("<ul>");
//			sb.append(String.format("<li>ID : %s</li>",inputId));
//			sb.append(String.format("<li>PW : %s</li>",inputPw));
//			sb.append(String.format("<li>Name : %s</li>",inputName));
//			sb.append(String.format("<li>Age : %s</li>",inputAge));
//			sb.append("</ul>");
//		}
//		
//		sb.append("</body>");
//		
//		out.print(sb.toString());
//		
//		sb.append("</html>");
	}


}
