<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>${message}</h1>
<!-- session에 message가 존재하면 출력됨 -->

<%
// session은 만료/종료하기 전까지 계속 유지하기에 페이지를 넘나들어도 계속 출력상태로 남아있음
// 1회 출력 후 session에서 데이터를 제거하도록 함
session.removeAttribute("message");
%>

<hr>

<h1> 회원 가입 </h1>
<form action="/signup" method = "POST">
<div>
ID : <input type = "text" name = "id">
</div>
<div>
PW : <input type = "password" name = "pw"><br>
PW CHECK : <input type = "password" name = "pwCheck">
</div>
<button>회원 가입</button>


</form>
</body>
</html>