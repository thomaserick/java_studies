<jsp:useBean id="calcula" class="beans.BeanCursoJsp"
	type="beans.BeanCursoJsp" scope="page"></jsp:useBean>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Curso-JSP</title>
</head>
<body>
	<h1>Index</h1>
	<form action="LoginServlet" method="post">
		<input type="text" id="login" name="login">
		<br /> 
		<input type="text" id="senha" name="senha"> 
		<br />
		<input type="submit" value="logar">
	</form>
</body>
</html>