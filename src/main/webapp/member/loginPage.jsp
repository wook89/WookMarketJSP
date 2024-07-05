<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 페이지</title>
</head>
<body>
<%@ include file ="/common/header.jsp" %>
	<h1>로그인</h1>
	<%
	if (request.getParameter("loginError") != null){
		out.print("로그인을 다시 하세요.");	
	}
	%>
	<form action="login.jsp" method="post">
		<input type="text" name="id" placeholder="아이디를 입력해주세요."><br>
		<input type="text" name="password" placeholder="비밀번호를 입력해주세요."><br>
		<input type="submit" value="로그인">
	</form>
<%@ include file ="/common/footer.jsp" %>
</body>
</html>