<%@ page language="java" contentType="text/html; charset=UTF-8"
import="cart.*"
import="book.*"
import="java.util.*"
import="member.*"
    pageEncoding="UTF-8"%>
<%@ include file ="/common/isLoggedIn.jsp" %>
<%
	CartService cartService = new WookCartService(new HashMapCartDAO());
	BookService bookService = new OracleBookService(new OracleBookDAO());
	MemberService memberService = new OracleMemberService(new OracleMemberDAO());
	List<CartItem> itemList = cartService.listAll(memberNo);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주문 페이지</title>
<style>
	input[type="number"] {
		width:2em
	}
	form {
		display : inline;
	}
	td,th{
		border : solid black 1px;
		border-collapse : collapsed;
	}
</style>
</head>
<body>

<%@ include file ="/common/header.jsp" %>
<h2>주문하기</h2>
<h4>주문할 도서 목록</h4>

		<table vorder=1>
			<tr><th>책제목</th><th>가격</th><th>수량</th></tr>
			<% 
			int numItems = 0, totalPrice =0, i =0; 
			for(CartItem item : itemList){ 
			//Book book = bookService.detail(item.getBookId());
			Book book = bookService.read(item.getBookId());
			numItems+=item.getQuantity();
			totalPrice += book.getPrice()*item.getQuantity();
			i++;
			%>
		<tr><td><%= i %></td>
			<td><%= book.getId() %></td>
			<td><%= book.getPrice() %></td>
			<td><%= item.getQuantity() %></td>
		<% } %>	
		</table>
		<p>총 상품가격 : <%= String.format("%,d", totalPrice) %>원 총(<%= numItems %>)</p>
		<%
			Member member = memberService.read(memberNo);
		%>
	<h4>배송 정보</h4>
	이름 : <%= member.getNickname() %><br>
	
	<form action="order.jsp" method="post">
	<input type="hidden" name="memberNo" value="<%=memberNo %>">
		모바일 : <input type="text" name="mobile" value="<%= member.getMobile()==null ?"" : member.getMobile() %>"><br>
		E메일 : <input type="text" name="email" value="<%= member.getEmail()==null ?"" : member.getEmail() %>"><br>
		주소 : <input type="text" name="address" value="<%= member.getAddress()==null ?"" : member.getAddress() %>"><br>
		<input type="checkbox" neme="modifyMember">회원정보 수정<br>
		<input type="submit" value="주문">
		<a href="<%= request.getContextPath()%>/cart/main.jsp"><input type="button" value="취소"></a>
	</form>



<%@ include file ="/common/footer.jsp" %>
</body>
</html>