<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<h2>Download photo</h2>
</head>
<body>
	
	<%@ page import="org.springframework.core.io.Resource"
			 import="java.io.File"%>
	
	<% File photo = (File)request.getAttribute("photo");%>
	
	<%	if(request.getAttribute("error") != null){%>
		<h3 style="color: red;"><%out.println(request.getAttribute("error"));%></h3>
	<% 	
	   }
		else{%>
			<img alt="" src=<%=photo %> width="800" height="800"/>
	<% }
	%>
	
	
</body>
</html>