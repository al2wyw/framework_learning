<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
${param.status } <br>
${param.status == "神奇" ?"是神奇":"不是神奇"} <br>
<%= java.net.URLDecoder.decode(request.getParameter("status"),"UTF-8")%><br>
${pageContext.request.requestURL }?${pageContext.request.queryString }
</body>
</html>