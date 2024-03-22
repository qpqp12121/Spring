<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title></title>
</head>
<body>
	<h3>게시판목록</h3>
	<form>
		<select>
			<option>선택</option>
			<c:forEach items="${conditionMap}" var="item">
				<option value="${item.value}">${item.key}</option>
			</c:forEach>
		</select>	
		<input type="submit" value="검색"/>
	</form>
	<a href="insertBoardForm">게시글등록하기</a>
	<c:forEach items="${boardList}" var="board">
		<div style="border: 1px solid blue;">
			seq:<a href="getBoard/${board.SEQ}">${board.SEQ}</a>
			<span>${board.TITLE}</span>
			<span>${board.WRITER}</span>
			<span>${board.CONTENT}</span>
			<span>${board.REGDATE}</span>
		</div>
	</c:forEach>
</body>
</html>