<%@ page language="java" contentType="text/html; charset=UTF-8"
import = "member.*"
    pageEncoding="UTF-8"%>
<%
	String noStr = request.getParameter("no");
	String oldPw = request.getParameter("old_pw");
	String newPw = request.getParameter("new_pw");
	String nickname = request.getParameter("nickname");
	
	if(noStr == null){
		response.sendRedirect("main.jsp");
	}
	else if(oldPw ==null || newPw ==null || nickname ==null){
		response.sendRedirect("detailPage.jsp?no="+noStr);		
	}else{
		MemberService service = new OracleMemberService(new OracleMemberDAO());
		//
		Member member = service.read(Integer.parseInt(noStr));
		//
		member.setPassword(newPw);
		member.setNickname(nickname);
			if(service.edit(member, oldPw)){
				response.sendRedirect("main.jsp");
			}else{
				response.sendRedirect("modifyPage.jsp?no="+noStr);
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