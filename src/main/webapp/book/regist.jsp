<%@ page language="java" contentType="text/html; charset=UTF-8"
import ="book.*"
    pageEncoding="UTF-8"%>
<%@ include file="/common/isAdminLogged.jsp" %>    
<!DOCTYPE html>
<%
	String name = request.getParameter("name");
	String author = request.getParameter("author");
	String price = request.getParameter("price");
	String instock = request.getParameter("instock");
	
	if(name ==null || author ==null || price ==null || instock == null){
		response.sendRedirect(request.getContextPath()+"/common/errorPage.jsp?regError=1");
	}else if(name.isEmpty() || author.isEmpty() || price.isEmpty() || instock.isEmpty()){
		response.sendRedirect("registPage.jsp");		
	}else if(name == ""||author==""||price==""){
		response.sendRedirect(request.getContextPath()+"/book/registPage.jsp?regError=1");
	}else{
		BookService service = new OracleBookService(new OracleBookDAO());
		if(service.regist(new Book(name,author,Integer.parseInt(price),Integer.parseInt(instock)))){
			response.sendRedirect(request.getContextPath()+"../index.jsp");
		}else{
			response.sendRedirect(request.getContextPath()+"/book/registPage.jsp?regError=2");
		}
	}
%>  
