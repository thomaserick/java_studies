<jsp:useBean id="calcula" class="beans.BeanCursoJsp"
	type="beans.BeanCursoJsp" scope="page"></jsp:useBean>

<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Curso-JSP</title>
<link rel="stylesheet" type="text/css" href="resources/css/style.css" media="screen" />
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery.maskedinput/1.4.1/jquery.maskedinput.min.js"></script>
</head>
<body>

	<div class="login-page">
		<div class="form">
			<form action="LoginServlet" method="post" class="login-form" onsubmit="return validarCampos()">
				<input type="text" placeholder="username" id="login" name="login" />
				<input type="password" placeholder="password" id="passwd"
					name="passwd" /> 
					<button type="submit" value="login">Login</button>
			</form>
		</div>
	</div>
</body>


<script type="text/javascript">	
	function validarCampos() {
		if (document.getElementById("login").value == '') {
			alert('Informe o Login');		
			return false;
		}	
		if (document.getElementById("passwd").value == '') {
			alert('Informe a Senha');		
			return false;
		}	
	
		return true;
	}
</script>
</html>