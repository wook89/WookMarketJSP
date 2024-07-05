<%@ page language="java" contentType="text/html; charset=UTF-8"
import ="member.*"
    pageEncoding="UTF-8"%>
<%
	String id = request.getParameter("id");
	String pw = request.getParameter("password");
	
	if(id == null || pw == null || id == "" || pw == ""){
		
		response.sendRedirect(request.getContextPath()+"/member/loginPage.jsp?loginError=1");
		return;
	}
	if(id.isEmpty() || pw.isEmpty()){
		response.sendRedirect(request.getContextPath()+"/common/errorPage.jsp?loginError=2");
		return;
	}
	final String adminId = "admin";
	final String adminPw = "1234";
	
	if(id.equals(adminId) && pw.equals(adminPw)){
		session.setAttribute("AdminId", adminId);
		session.setAttribute("AdminName", "관리자");
		response.sendRedirect(request.getContextPath()+"/admin/main.jsp");
	}else{	
		MemberService service = new OracleMemberService(new OracleMemberDAO());
		Member member = service.login(id, pw);
		
		if(member != null){
			session.setAttribute("MemberId",member.getId());
			session.setAttribute("MemberName",member.getNickname());
			session.setAttribute("MemberNo",member.getNo());
			response.sendRedirect(request.getContextPath()+"/index.jsp");
		}else{
			response.sendRedirect(request.getContextPath()+"/member/loginPage.jsp?loginError=3");
		}
	}
%>
