<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입 페이지</title>
</head>
<body>
<%@ include file = "../common/header.jsp" %> 
	<h3>회원 가입</h3>
<%
	if(request.getParameter("joinError") != null){
		out.print("회원 가입을 위해 아래의 정보를 모두 입력해주세요.");
	}
%>
	<form action="join.jsp" method="post">
		<input type="text" name="id" placeholder="아이디 입력"><br>
		<input type="password" name="pw" placeholder="패스워드 입력"><br>
		<input type="text" name="nickname" placeholder="닉네임 입력"><br>
		<br>
		<input type="submit" value="등록">
		<a href="../index.jsp"><input type="button" value="취소"></a>
	</form>
</body>
</html>