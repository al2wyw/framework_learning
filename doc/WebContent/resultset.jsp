<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html">
<html>
<head>
<style>
th{
font-style:italic;
font-size:24px;
font-family:"Times New Roman",Georgia,Serif;
text-align:left;
}
td{
font-size:18px;
font-family:"Times New Roman",Georgia,Serif;
width:100px;
height:30px;
text-align:left;
padding-left:10px;
padding-top:10px;
padding-bottom:10px;
border:solid 1px grey;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"/>
<title>Insert title here</title>
</head>

<body>
<h1><%=new java.util.Date() %></h1>
<p>show me the result</p>
<table style="border:solid 1px grey;border-collapse:collapse">
<tr><th>Name</th><th>Salary</th></tr>
<c:forEach items="${mysql.people }" var="cur">
<tr><td>${cur.key}</td><td>${cur.value}</td></tr>
</c:forEach>
</table>
${mysql.people.james} <br/>
${mysql.charvar} <br>
${4>3 } <br>

</body>

</html>