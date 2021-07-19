<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<h2>Photo List:</h2>
</head>
<body>
	<%@ page import="com.model.PhotoDataApplicationDTO" %>

	<% PhotoDataApplicationDTO[] list = (PhotoDataApplicationDTO[])session.getAttribute("photoList");
	   for(int i=0; i<list.length; i++){
		   out.println(i+1 + ": " + list[i]);%>
		   <br>
		   <% 
	   }
	%>
	<br>
	<br>
	<form action="photo-list-by-album">
		<h3>Photos from which album you would like to filter by?</h3>
		<input type=text name="albumId">
		<input type="submit" value="Get photo list by album">
	</form>
	<br>
	<form action="download-photo">
		<h3>Which photo would you would like to download?</h3>
		<h4>album id:</h4>
		<input type=text name="albumId">
		<h4>photo id:</h4>
		<input type=text name="photoId">
		<input type="submit" value="Download Photo">
	</form>
</body>
</html>