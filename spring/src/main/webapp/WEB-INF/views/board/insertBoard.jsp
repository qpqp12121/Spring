<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html><html><head><title>insertBoard.jsp</title></head>
<body>
<form action="./insertBoard" method="post" enctype="multipart/form-data">
	title<input type="text" name="title">
	content<input type="text" name="content">
	writer<input type="text" name="writer">
	<input type="file" name="file">
 	<input type="submit" value="등록"/>
</form>
</body>
</html>