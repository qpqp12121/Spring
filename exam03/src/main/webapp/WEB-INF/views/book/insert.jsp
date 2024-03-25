<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<title>도서등록</title>
</head>
<body>
<br>
<a href="../list">도서목록</a>
<h3>도서등록</h3>

    <form action="../insert" method="post">
    	도서번호 <input name="bookNo" readonly><br>
    	도서명 <input name="bookName"><br>
    	도서표지 <input type="text" name="bookCoverimg"><br>
    	출판일자 <input name="bookDate"><br>
    	금액 <input name="bookPrice"><br>
    	출판사 <input name="bookPublisher"><br>
    	도서소개 <textarea name="bookInfo"></textarea><br>
    	<button>등록</button>
	</form>
	
<!-- 	<script>
		var msg = "<c:out value='${msg}'/>";
		alert(msg);
	</script> -->
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