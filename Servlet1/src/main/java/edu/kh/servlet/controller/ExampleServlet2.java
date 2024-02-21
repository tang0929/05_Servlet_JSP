package edu.kh.servlet.controller;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/* Servlet 작성 순서
 * 1. HttpServlet 상속 받기
 * 2. @WebServlet 어노테이션 작성하기
 */


/* @WebServlet : <servlet>, <servlet-mapping> 태그를 컴파일 시 추가하라는 어노테이션
 * 1. 현재 클래스를 Servlet으로 등록 -> <servlet>
 * 2. 등록된 servlet과 () 내 요청 주소 매핑 -> <servlet-mapping> 
 * 3. doGet() 또는 doPost() 오버라이딩 -> 요청 method에 따라 수행
 * 4. 필요한 로직 처리
 * 	- 파라미터 얻어오기
 * 	- 필요한 요청 처리 구문 작성
 * 5. 응답 형태 지정 + 응답 스트림 얻어오기 
 * 6. 스트림을 통해 응답 데이터(html 코드) 출력하기*/
@WebServlet("/ex2")
public class ExampleServlet2 extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		// 파라미터 얻어오기
		String chicken = req.getParameter("chicken");   // 치킨
		String type = req.getParameter("type");   // 뼈순살
		String orderer = req.getParameter("orderer");   // 주문자
		String address = req.getParameter("address");   // 주소

		
		// String[] req.getParameterValues("name속성값");
		// 같은 name 속성 값을 가지는 값을 모두 모아 하나의 String[]로 만들어 반환하는 메서드
		
		String[] options = req.getParameterValues("opt");
		
		// 아무것도 선택하지 않으면 null
		// 하나라도 선택하면 String[] 반환
		
		System.out.println("[서버] /ex2 요청됨");
	
	
	
	
		// -------------------------------------------------
		
		// 선택한 치킨, 뼈순살, 옵션에 따라 달라지는 가격 계산하기
		
		int price = 0;
		
		switch(chicken) {
		case "fried" : price += 20000; break;
		case "sauce" : price += 22000; break;
		case "soy" : 
		case "garlic" : price += 22000; break;
		
		}
		
		if(type.equals("boneless")) {
			// 순살인 경우
			price += 2000;
		}
		
		// checkbox에 선택된 옵션이 있을 경우
		if(options != null) {
			for(String opt : options) {
				// 배열에 저장된 모든 값을 순차적으로 돌려봄
				switch(opt) {
				case "치킨무" : price += 500; break;
				case "콜라" : price += 500; break;
				case "치즈볼" : price += 3000; break;
				}
			}
		}
		
		// 응답 형태 지정
		resp.setContentType("text/html; charset = utf-8");
		
		// 응답 스트림 얻어오기
		PrintWriter out = resp.getWriter();
		
		StringBuilder sb = new StringBuilder();
		
		sb.append("<!DOCTYPE html>");
		sb.append("<html>");
		
		sb.append("<head>");
		sb.append("<title>");
		sb.append(String.format("%s님의 주문 영수증", orderer));
		sb.append("</title>");
		sb.append("</head>");
		
		sb.append("<body>");
		
		sb.append("<h3>");
		sb.append("주문자명 : ");
		sb.append(orderer);
		sb.append("</h3>");
		
		sb.append(String.format("<h3>주소 : %s</h3>", address));
		
		sb.append("<ul>");
		sb.append(String.format("<li>치킨 : %s</li>",chicken));
		
		String temp = type.equals("bone") ? "뼈" : "순살";
		sb.append(String.format("<li>뼈/순살 : %s</li>",temp));
		
		if(options != null) {
			sb.append("<li>");
			sb.append("선택한 옵션 : ");
			for(String opt : options) sb.append(opt + " ");
			sb.append("</li>");
		}

	
		sb.append("</ul>");
		
		sb.append(String.format("<h3>주문 총 금액 : %d원</h3>", price));
		
		sb.append("</body>");
		
		
		sb.append("</html>");
		
		out.print(sb.toString());

}


	}
