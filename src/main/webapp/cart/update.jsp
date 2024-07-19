<%@ page language="java" contentType="text/html; charset=UTF-8"
import = "cart.*"
    pageEncoding="UTF-8"%>
<%@ include file="/common/isLoggedIn.jsp" %>    
<%
	String idStr = request.getParameter("id");
	String quanStr = request.getParameter("quantity");
	
	if(idStr==null || idStr.isEmpty() || quanStr==null || quanStr.isEmpty()){
		response.sendRedirect(request.getContextPath()+"/common/errorPage.jsp?cartIdErr=1");
		return;
	}
	CartService service = new WookCartService(HashMapCartDAO.getInstance());
	
	if(service.update(Integer.parseInt(idStr),memberNo,Integer.parseInt(quanStr))){
		response.sendRedirect(request.getContextPath()+"/cart/main.jsp");
	}else{
		response.sendRedirect(request.getContextPath()+"/common/errorPage.jsp?cartUpdateErr=2");
	}
%>    
