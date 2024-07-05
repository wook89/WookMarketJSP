<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	[<%=request.getParameter("id") %>]오류가 발생했습니다. <a href="<%=request.getContextPath() %>/index.jsp"><button>홈</button></a>
</body>
</html>