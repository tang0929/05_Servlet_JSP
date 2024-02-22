package edu.kh.jsp.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import edu.kh.jsp.model.dto.Book;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/el")
public class ELServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	
	// HttpServletRequest 객체에 여러 속성을 추가!
	
	/* - req.setAttribute("K",V);
	* - 추가된 속성 값은 위임받은 JSP에서 
	* ${K} 형태로 작성하면 출력시 해당 위치에 V가 출력됨 */
		
	// 기본 자료형
	req.setAttribute("score", 90);
	
	// String
	req.setAttribute("address","서울시 중구 남대문로 120");
	
	// 컬렉션(List, Set, Map)
	List<String> strList = new ArrayList<String>();
	strList.add("컬렉션내용1");
	strList.add("컬렉션내용2");
	strList.add("컬렉션내용3");
	strList.add("컬렉션내용4");
	req.setAttribute("strList", strList);
	
	
	
	// DTO
	Book book1 = new Book("나는 행복한 푸바오 할부지입니다","강철원",18000);
	req.setAttribute("book1", book1);
	
	// -----------------------------------------------------------------
	
	/* null, 빈칸, 비어있음 에 대한 EL 처리 확인 */
	
	String test1 = null; // null
	String test2 = ""; // 빈칸
	List<String> test3 = null; // null
	List<String> test4 = new ArrayList(); // 비어있는 리스트
	List<String> test5 = new ArrayList(); 
	test5.add("aaa");
	test5.add("bbb"); // 비어있지 않은 리스트
	
	req.setAttribute("test1", test1);
	req.setAttribute("test2", test2);
	req.setAttribute("test3", test3);
	req.setAttribute("test4", test4);
	req.setAttribute("test5", test5);

	
	
	
	
	// -----------------------------------------------------------------
		
		
		
	// forward : 요청 위임
		
	// 원래 Servlet이 요청 받고,결과 HTML 만들어야 하는데
	// Java에서 HTML 코드 쓰기 어려움.  --> JSP에서 요청, 응답 객체를
	// 넘겨줘서 대신 결과 화면 만들고 응답함
		

		
	// 1. 요청 위ㅎ임할 JSP 파일 경로 지정
		String path = "/WEB-INF/views/el/el.jsp";
		
	// 2. 요청 발송자(RequestDispatcher) 생성
		RequestDispatcher dispatcher = req.getRequestDispatcher(path);
		
	// 요청 위임	
		dispatcher.forward(req, resp);
	

}
}
