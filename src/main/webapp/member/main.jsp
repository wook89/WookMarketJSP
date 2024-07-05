<%@ page language="java" contentType="text/html; charset=UTF-8"
import="member.*"
import="java.util.*"
    pageEncoding="UTF-8"%>
<%@ include file="/common/isAdminLogged.jsp" %>    
<%
	MemberService service = new OracleMemberService(new OracleMemberDAO());
	List<Member> memberList = service.listAll();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 관리</title>
</head>
<body>
<%@ include file ="/common/header.jsp" %>
	<h1>회원관리 메인 페이지</h1>
	<h3>회원목록</h3>
	<%if(memberList.size() == 0){ %>
		<p>등록되어있는 회원이 없습니다.</p>	
		<% }else{ %>
		<table>
			<tr><th>회원번호</th><th>아이디</th><th>닉네임</th><th>등록일</th></tr>
			<% for(Member m : memberList) { %>
				<tr>
					<td><%= m.getNo() %></td>
					<td><a href="detailPage.jsp?no=<%=m.getNo()%>"><%= m.getId() %></a></td>
					<td><%= m.getNickname() %></td>
					<td><%= m.getRegdate() %></td>
				</tr>
			<%} %>
		</table>
		<%} %>
<%@ include file ="/common/footer.jsp" %>
</body>
</html>