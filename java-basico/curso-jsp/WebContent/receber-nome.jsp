<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%="Nome recebido: " + request.getParameter("nome")%>

	<%! int cont = 10;
	
		public int retorna(int n){
			return n * 3;
		}
		
	%>
	<%= "Teste: " +retorna(cont) %>

</body>
</html>