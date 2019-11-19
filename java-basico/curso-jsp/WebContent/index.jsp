<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Curso-JSP</title>
</head>
<body>

	<h1>Bem vindo ao Curso JSP</h1>
	<%=
		"seu sucesso garantido.."
	%>

	<form action="receber-nome.jsp" method="get">

		<input type="text" id="nome" name="nome">
		<input type="submit" value="Enviar">

	</form>

</body>
</html>