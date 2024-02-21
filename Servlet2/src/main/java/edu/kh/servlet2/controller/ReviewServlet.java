package edu.kh.servlet2.controller;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/ex3")

public class ReviewServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 파라미터 얻어오기
			String pizza =req.getParameter("pizza");   
			String size = req.getParameter("size");     
			String orderer = req.getParameter("orderer");   
			String address = req.getParameter("address");  
			String phoneNumber = req.getParameter("phoneNumber");  

			
			String[] options = req.getParameterValues("sideMenu");
			
			System.out.println("[서버] /ex3 요청됨");
			
			
	// --------------------------------------------
			resp.setContentType("text/html; charset=utf-8");
			
			int price = 0;
			
			switch(pizza) {
			case "치즈 피자" : price += 18000; break;
			case "포테이토 피자" : price += 19000; break;
			case "불고기 피자" : price += 20000; break;
			case "콤비네이션 피자" : price += 19000; break;
			case "페퍼로니 피자" : price += 19000; break;
			
			}
			
			if(size.equals("large")) {
				price += 3000;
			}
			
		
			
			if(options != null) {
				for(String opt : options) {
					// 배열에 저장된 모든 값을 순차적으로 돌려봄
					switch(opt) {
					case "치즈스파게티" : price += 6000; break;
					case "치킨텐더" : price += 5000; break;
					case "치즈볼" : price += 4000; break;
					case "콜라" : price += 1500; break;
					case "피클" : price += 0; break;
					}
				}
			}
			
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
			sb.append(String.format("<li>피자 : %s</li>",pizza));
			
			String temp = size.equals("large") ? "large" : "regular";
			sb.append(String.format("<li>사이즈 : %s</li>",temp));
			
			if(options != null) {
				sb.append("<li>");
				sb.append("사이드 메뉴 : ");
				for(String opt : options) sb.append(opt + " ");
				sb.append("</li>");
			}

			sb.append(String.format("<li>전화번호 : %s </li>",phoneNumber));
		
			sb.append("</ul>");
			
			sb.append(String.format("<h3>주문 총 금액 : %d원</h3>", price));
			
			sb.append(String.format("<h1>주문이 완료되었습니다.</h1>"));
			
			sb.append("</body>");
			
			
			sb.append("</html>");
			
			out.print(sb.toString());

			
			
			
			
			
			
		
		
		
	}
	

		
		
		
		
	
	

}
