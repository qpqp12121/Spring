<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<title>도서조회</title>
</head>
<body>
<br>
<a href="book/insert">도서등록</a>
<h3>도서목록 조회</h3>

    <table>
		<tr>
			<th>도서번호</th>
			<th>도서명</th>
			<th>표지</th>
			<th>출판일자</th>
			<th>금액</th>
			<th>출판사</th>
			<th>도서소개</th>
		</tr>
		<c:forEach items="${bookList }" var="book">
		<tr>
			<td>${book.bookNo}</td>
			<td>${book.bookName}</td>
			<td><img src="../../../resources/images/${book.bookCoverimg}"></td>
			<td><fmt:formatDate value="${book.bookDate}" pattern="yyyy/MM/dd"/></td>
			<td><fmt:formatNumber value="${book.bookPrice}" pattern="#,###"/></td>
			<td>${book.bookPublisher}</td>
			<td>${book.bookInfo}</td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>

<style>
table, th, td {
	border: 2px solid #ccc;
	border-collapse: collapse;
	padding: 5px;
}
th {
	background: #eee
}
</style>