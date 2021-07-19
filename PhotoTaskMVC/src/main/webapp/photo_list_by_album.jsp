<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<h2>Photo list by album</h2>
</head>
<body>
	<%@ page import="com.model.PhotoDataApplicationDTO"%>

	<% PhotoDataApplicationDTO[] list = (PhotoDataApplicationDTO[])session.getAttribute("photoList");
	   for(int i=0; i<list.length; i++){
		   out.println(i+1 + ": " + list[i]);%>
	<br>
	<% 
	   }
	%>
</body>
</html>