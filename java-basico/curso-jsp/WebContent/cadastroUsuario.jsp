<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastro de Usuário</title>
</head>
<body>

	<form action="salvarUsuario" method="post">

		<div>
			<label for="id">Código:</label> <input type="text"
				readonly="readonly" id="id"
				name="id" value="${user.id}" />
		</div>

		<div>
			<label for="user">Usuário:</label> <input type="text" id="user"
				name="user" value="${user.user}" />
		</div>
		<div>
			<label for="login">Login:</label> <input type="text" id="login"
				name="login" value="${user.login}" />
		</div>

		<div>
			<label for="passwd">Senha:</label> <input type="password" id="passwd"
				name="passwd" value="${user.passwd}" />
		</div>

		<div class="button">
			<button type="submit">Salvar</button>
		</div>

	</form>


	<table>
		<tr>
			<th>Código</th>
			<th>Usuário</th>
			<th>Login</th>
			<th>Senha</th>
		</tr>

		<!-- Expression Linguage -->
		<c:forEach items="${usuarios}" var="user">
			<tr>

				<td style="width: 150px"><c:out value="${user.id }"></c:out></td>
				<td><c:out value="${user.user }"></c:out></td>
				<td><c:out value="${user.login }"></c:out></td>
				<td><c:out value="${user.passwd }"></c:out></td>

				<td><a href="salvarUsuario?acao=delete&id=${user.id }">Exluir</a></td>
				<td><a href="salvarUsuario?acao=editar&id=${user.id }">Editar</a></td>

			</tr>
		</c:forEach>

	</table>


</body>
</html>