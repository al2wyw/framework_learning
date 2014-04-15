<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
response.setDateHeader("Expires", -1);
response.setHeader("Pragma", "no-cache");
%>
<h1>you are authorized to access this resource</h1>
<% if(request.getRemoteUser()==null){ %>
	<form method="get" action="login">
	user: <input type="text" name="user"/><br>
	password: <input type="text" name="password"/>
	<br>
	<input type="submit" value="submit"/>
	</form>
<%}else{%>
	<p>you are logged in</p>
	<script type="text/javascript">
	function logmeout(){
		var req=new XMLHttpRequest();
		if(!req)
			alert("error");
		else{
			req.open("GET","logout",true);
			req.onreadystatechange=function(){
				if(req.readyState==4)
					if(req.responseText=="success")
						window.location.href="auth.jsp";
			};
			req.send();
		}
	}
	</script>
	<button id="logout" onclick="logmeout()">logout</button>

<%} %>
</body>
</html>