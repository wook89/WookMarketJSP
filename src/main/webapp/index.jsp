<%@ page language="java" contentType="text/html; charset=UTF-8"
import ="java.util.*"
import ="book.*"
    pageEncoding="UTF-8"%>
<%
	BookService service = new OracleBookService(new OracleBookDAO());
	List<Book> bookList = service.listAll();
	bookList.sort(Comparator.comparing(j-> j.getId()));
%>     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome Wook's BookMarket</title>
<style>
	table{
		border-collapse : collapse;
		text-align : center;
	}
	td{
		padding : 5px;
	}
</style>
</head>
<body>
<%@ include file = "common/header.jsp" %> 
	<h3>도서목록</h3>
	
	<br>
	<%if(bookList.size() == 0){ %>
		<p>등록되어있는 도서가 없습니다.</p>	
		<% }else{ %>
		<table border=1>
			<tr><th>도서ID</th><th>제목</th><th>저자</th><th>가격</th></tr>
			<% for(Book book : bookList) { %>
				<tr>
					<td><%= book.getId() %></td>
					<td><a href="<%= request.getContextPath() %>/book/detailPage.jsp?id=<%=book.getId()%>"><%= book.getName() %></a></td>
					<td><%= book.getAuthor()%></td>
					<td><%= String.format("%,d",book.getPrice())%>원</td>
				</tr>
			<%} %>
		</table>
		<%} %>
<%@ include file="common/footer.jsp" %>		
</body>
</html>