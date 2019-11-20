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
	
	<!-- Page -->
	<%@ page info="Página do curso de JSP" %>
	
	<!-- ErrorPage -->
	<%@ page errorPage="error.jsp" %>
<%--  <%= 100/0 %>  --%>
	
	<%session.setAttribute("Curso", "curso de jsp"); %>

<%@ page import="java.util.Date" %>



<%= "Data de Hoje: " + new Date() + " " + getServletInfo() %>
</body>
</html>