<%@ page language="java" contentType="text/html; charset=UTF-8"
import="member.*"
import="cart.*"
pageEncoding="UTF-8"%>
<%
	int memberNo = Integer.parseInt(request.getParameter("memberNo"));
	String mobile = request.getParameter("mobile");
	String email = request.getParameter("email");
	String address = request.getParameter("address");
	
	if(mobile ==null || email ==null || address ==null){
		response.sendRedirect(request.getContextPath()+"/common/errorPage.jsp?orderError=1");
		return;
	}
	if(mobile.isEmpty() || email.isEmpty() || address.isEmpty()){
		response.sendRedirect("orderPage.jsp");
		return;
	}
	
	if(request.getParameter("modifyMember") != null){
		MemberService memberService = new OracleMemberService(new OracleMemberDAO());
		memberService.editAdditionInfo(memberNo,mobile,email,address);
	}
	
	CartService cartService = new WookCartService(new HashMapCartDAO());
	if(cartService.clear(memberNo)){
%>
		<script>
		alert("주문이 완료되었습니다.");
		location = "<%=request.getContextPath()%>/index.jsp";
		</script>
<%		
	}
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
오더제이에스핍니다.
</body>
</html>