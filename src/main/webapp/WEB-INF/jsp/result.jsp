<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String name=(String)request.getAttribute("name");
	String filename=(String)request.getAttribute("filename");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>fileupload</title>
</head>
<body>
	<p>名前:<%= name %></p>
	<p>写真:<br><img src="/FileUpload/upload/<%= filename %>"></p>
</body>
</html>