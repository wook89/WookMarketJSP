<%@ page language="java" contentType="text/html; charset=UTF-8"
import ="cart.*"
    pageEncoding="UTF-8"%>
<%@ include file="/common/isLoggedIn.jsp" %>
<%
	CartService service = new WookCartService(new OracleCartDAO());
	
	if(service.clear(memberNo)){
		response.sendRedirect(request.getContextPath()+"/cart/main.jsp");
		return;
	}else{
		response.sendRedirect(request.getContextPath()+"/common/errorPage.jsp?cartClearErr=1");
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