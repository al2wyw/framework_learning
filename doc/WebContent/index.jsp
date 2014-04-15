<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="WEB-INF/lib/test.tld" prefix="test"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript">
function valid(){
	var name=document.getElementById("name");
	var t=/^[a-zA-z]+$/;
	if(t.test(name.value)){
		return true;
	}else{
		return false;
	}
}
function linktoAuth(){
	window.location.href="auth.jsp";
}
function send_(){
	var t=document.getElementById("name");
	t.addEventListener();
	t.removeEventListener();
	var req = new XMLHttpRequest();
	if(!req){
		return;
	}
	var data=new FormData(document.getElementById("file_upload"));
	if(!data){
		return;
	}
	req.open("POST","fileStore",true);
	req.onreadystatechange=function (){
		if(req.readyState==4&&req.status==200){
			document.getElementById("show").innerHTML="done";
		}
	};
	req.upload.onprogress=up;
		
function up(event){
		if(event.lengthComputable){
			document.getElementById("show").innerHTML=Math.round(event.loaded/event.total*100);
		}else
			alert("can not progress");
	}
	req.send(data);
}
</script>
<link type="text/css" rel="styleSheet" href="index.css" />

<title>Insert title here</title>
<% String text=new String("show me");
%>
</head>
<jsp:useBean id="testt" class="mytest.test" />
<jsp:setProperty property="text" name="testt" value="Anne" />
<jsp:useBean id="test" class="mytest.enter" scope="session" />
<jsp:setProperty property="text" name="test" value="Stranger" />
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
			<li>test</li>
			<li><%= text %></li>
			<li>test</li>
			<li><jsp:getProperty property="text" name="testt" /></li>
		</ul>
		<test:mytag flag="false">
			<test:mythen>The flag is ${flag}</test:mythen>
			<test:myelse>The flag is ${flag}</test:myelse>
		</test:mytag>
		<div class="mform">
			<form class="form1" action="test.jsp" method="post"
				onSubmit="return valid()">
				<div class="label" style="width: 200px; float: left">what is
					your name:</div>
				<input class="textfield" type="text" name="name" id="name"
					value="<jsp:getProperty property="text" name="test"/>" /> <input
					class="button" type="submit" value="submit" />
			</form>
			<form class="form2" action="test" method="get"
				onSubmit="return valid()">
				<div class="label" style="width: 200px; float: left">what is
					your type:</div>
				<input class="textfield" type="text" name="type" id="name" /> <input
					class="button" type="submit" value="submit" />
			</form>
			<form class="form3" action="session_attr" method="get">
				<div class="label" style="width: 200px; float: left">what is
					your attribute(name,value):</div>
				<input class="textfield" type="text" name="value" id="value" /> <input
					class="button" type="submit" value="submit" />
			</form>
		</div>
		<form action="select/test/mypathislong/canyou" method="post">
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
		<form id="file_upload" action="fileStore" method="post"
			enctype="multipart/form-data">
			<input type="file" value="browse" name="file" />
			<button type="submit">submit</button>
		</form>
		<button type="button" onclick="send_()">click me</button>
		<p id="show"></p>
	</div>
	<p style="margin: 30px 0px; clear: both;">
		The URL of the request is :
		<%= request.getRequestURL() %><br> The URI of the request is:
		<%= request.getRequestURI() %></p>
	<jsp:include page="included.jsp">
		<jsp:param name="id" value="test0123" />
	</jsp:include>
</body>
</html>