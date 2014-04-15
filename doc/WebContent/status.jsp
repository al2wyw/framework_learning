<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<!-- accept-charset="UTF-8" -->
	<form action="status" method="get" >
		<table>
			<tr>
				<td>get the code: <input type="text" name="code" /></td>
				<td><input type="submit" value="submit" /></td>
			</tr>
		</table>
	</form>
	<form action="status" method="post" >
		<table>
			<tr>
				<td>post the code: <input type="text" name="code" /></td>
				<td><input type="submit" value="submit" /></td>
			</tr>
		</table>
	</form>
</body>
</html>