<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<% 
if(session.getAttribute("AdminId") == null){
	response.sendRedirect(request.getContextPath()+"/common/errorPage.jsp?loginError=1");
	return;
}
%>  