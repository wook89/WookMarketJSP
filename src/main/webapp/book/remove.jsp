<%@ page language="java" contentType="text/html; charset=UTF-8"
import="book.*"
    pageEncoding="UTF-8"%>
<%
	String idStr = request.getParameter("id");
	if(idStr == null){
		response.sendRedirect("../index.jsp");
	}else{
		BookService service = new OracleBookService(new OracleBookDAO());
		if(service.remove(Integer.parseInt(idStr))){
			response.sendRedirect("../index.jsp");
		}else{
			response.sendRedirect("detailPage.jsp?id="+idStr);
		}
	}
%>    
