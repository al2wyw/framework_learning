<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<link type="text/css" rel="styleSheet" href="index.css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<% String text=new String("show me");
%>
</head>
<jsp:useBean id="testSess" class="mytest.myTestDate" scope="session" />
<jsp:useBean id="testApp" class="mytest.myTestDate" scope="application" />
<body>
	<div id="mbody" class="mbody">
		<div id="header" class="header">
			<table class="left-head">
				<tr>
					<td align="center">Home</td>
					<td align="center">Shopping</td>
					<td align="center" onclick="linktoAuth()">Tools</td>
				</tr>
			</table>
			<table class="right-head">
				<tr>
					<td align="right">Reference</td>
				</tr>
			</table>
		</div>
		<ul>
			<li>${testApp.date}</li>
			<li><%= text %></li>
			<li>${testSess.date}</li>
		</ul>
		<test:mytag flag="false">
			<test:mythen>The flag is ${flag}</test:mythen>
			<test:myelse>The flag is ${flag}</test:myelse>
		</test:mytag>

		<form action="select" method="post">
			<select name="select" multiple>
				<option value="test1">test1</option>
				<option value="test2">test2</option>
				<option value="test3">test3</option>
				<option value="test4">test4</option>
				<option value="test5">test5</option>
			</select> <input type="radio" value="male" name="sex" />male <input
				type="radio" value="female" name="sex" />female <input
				type="checkbox" value="worker" name="job" />worker <input
				type="checkbox" value="teacher" name="job" />teacher <input
				type="checkbox" value="employee" name="job" />employee
			<button type="submit">sumbit</button>
		</form>
	</div>
</body>
</html>