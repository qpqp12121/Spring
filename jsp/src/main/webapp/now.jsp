<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="my"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>now.jsp</title>
</head>
<body>
<my:myselect></my:myselect>
<h2>시간 알림 서비스</h2>
현재 날짜와 시간은
	<%=request.getAttribute("today")%> 
	<br>
	<b><font color="powderBlue">${today}</font></b><!--${requestScope.today} 생략버전-->
입니다.
	<br>클라이언트 IP: <%= request.getRemoteAddr()%>
	<hr>EL ${pageContext.request.remoteAddr } <!-- 위의 getRemotedAddr()랑 같은 거임(get생략하고 필드명만 적어도 됨) -->
	
	<br>클라이언트 브라우저: <%= request.getHeader("User-Agent")%>
	<hr>EL ${header["User-Agent"]}<!--위의 "User-Agent" 안에 하이픈때문에 대괄호로 감싸기-->
	
	<br><%=request.getParameter("name") %>
	<hr>EL ${param.name} <!--url에 ? 붙이고 name=값 적어주면 뜸 (http://localhost:8081/jsp/NowServ?name=kiki) -->
	
	<br><%=request.getCookies()[2].getValue() %>
	<hr>EL ${cookie.cart.value }
</body>
</html>