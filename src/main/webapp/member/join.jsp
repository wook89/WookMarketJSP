<%@page import="member.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	String nickname = request.getParameter("nickname");
	
	if(id ==null || pw ==null || nickname ==null){//request parameter 자체가 없는경우
		response.sendRedirect(request.getContextPath()+"/common/errorPage.jsp?joinError=1");
	
	}else if(id.isEmpty() || pw.isEmpty() || nickname.isEmpty()){//request parameter는 있는데 값이 없는경우
		response.sendRedirect(request.getContextPath()+"/member/joinPage.jsp?joinError=1");
	}else{
		MemberService service = new OracleMemberService(new OracleMemberDAO());
		Member member = new Member(id,pw,nickname);
		
		if(service.regist(member)){
			response.sendRedirect(request.getContextPath()+"/member/loginPage.jsp");
		}else{
			response.sendRedirect(request.getContextPath()+"/common/errorPage.jsp?joinError=2");
		}
	}
%>  
