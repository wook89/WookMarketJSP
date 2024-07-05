<%@page import="member.MemberService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
import="member.*"
    pageEncoding="UTF-8"%>
<%
	String noStr = request.getParameter("no");
	if(noStr == null){
		response.sendRedirect(request.getContextPath()+"/member/main.jsp");
	}else{
		MemberService service = new OracleMemberService(new OracleMemberDAO());
		if(service.remove(Integer.parseInt(noStr))){
			response.sendRedirect(request.getContextPath()+"/member/main.jsp");
		}else{
			response.sendRedirect(request.getContextPath()+"/member/detailPage.jsp?no="+noStr);
		}
	}
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>