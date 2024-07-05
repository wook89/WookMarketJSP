<%@ page language="java" contentType="text/html; charset=UTF-8"
import="book.*"
    pageEncoding="UTF-8"%>
<%@ include file="/common/isAdminLogged.jsp" %>    
<%
	String idStr = request.getParameter("id");
	String name = request.getParameter("name");
	String author = request.getParameter("author");
	String price = request.getParameter("price");
	
	if(idStr == null){
		response.sendRedirect("../index.jsp");
	}
	else if(name ==null || author ==null || price ==null){
		response.sendRedirect("detailPage.jsp?id="+idStr);		
	}else{
		BookService service = new OracleBookService(new OracleBookDAO());
		Book book = service.read(Integer.parseInt(idStr));
		
		book.setName(name);
		book.setAuthor(author);
		book.setPrice(Integer.parseInt(price));
			if(service.edit(book, name,author,Integer.parseInt(price))){
				response.sendRedirect("../index.jsp");
			}else{
				response.sendRedirect("modifyPage.jsp?no="+idStr);
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