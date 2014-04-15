<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false" errorPage="error.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript">
function jump(){
	window.location.href="/doc/clear_all";
}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>
		Hello, I tricked you! your session id is
		<c:forEach items="${pageContext.session.attributeNames}" var="cur">

				
				${cur}<br>
		</c:forEach>
	</h1>
	<input type="button" value="clear all" onclick="jump()" />
</body>
</html>