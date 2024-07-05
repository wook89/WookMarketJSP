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
<title>도서 목록</title>
</head>
<body>
<%@ include file = "../common/header.jsp" %>
	<h1>도서관리 메인 페이지</h1>
	<a href="registPage.jsp"><button>도서등록</button></a><br>
	<h3>도서목록</h3>
	<%if(bookList.size() == 0){ %>
		<p>등록되어있는 도서가 없습니다.</p>	
		<% }else{ %>
		<table>
			<tr><th>도서ID</th><th>제목</th><th>저자</th><th>가격</th></tr>
			<% for(Book m : bookList) { %>
				<tr>
					<td><%= m.getId() %></td>
					<td><a href="detailPage.jsp?id=<%=m.getId()%>"><%= m.getName() %></a></td>
					<td><%= m.getAuthor()%></td>
					<td><%= m.getPrice()%></td>
				</tr>
			<%} %>
		</table>
		<%} %>
		<%@ include file = "../common/footer.jsp" %>
</body>
</html>