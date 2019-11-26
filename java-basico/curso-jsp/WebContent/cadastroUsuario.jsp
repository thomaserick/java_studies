<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Cadastro de Usuário</title>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>

<script defer
	src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.11.2/js/all.min.js"></script>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.11.2/css/all.min.css">


</head>
<body>
	<div class="container">

		<form action="salvarUsuario" method="post">

			<fieldset class="form-group">
				<div class="row">

					<div class="col-md-9">
						<div class="form-group">
							<label for="username">Código</label> <input type="text"
								class="col-1  form-control" id="id" placeholder="" name="id"
								readonly="readonly" value="${user.id}">
						</div>
						<div class="form-group">
							<label for="user">Usuário:</label> <input type="text"
								class="form-control col-md-4" id="user" placeholder="Usuario"
								name="user" value="${user.user}">
						</div>

						<div class="form-group">
							<label for="login">Login:</label> <input type="text"
								class="form-control col-md-4" id="login" placeholder="Usuario"
								name="login" value="${user.login}">
						</div>


						<div class="form-group">
							<label for="passwd">Senha:</label> <input type="password"
								class="form-control col-md-4" id="password" placeholder="Senha"
								name="passwd" value="${user.passwd}">
						</div>
					</div>
				</div>
				<div class="form-group row">
				<div class="col-4">
					<button type="submit" class="btn btn-primary">Salvar</button>
				</div>
			</div>
			</fieldset>

			
		</form>
	</div>

	<div class="container">
		<div class="row justify-content-center">

			<div class="table-responsive">
				<table id="cadUser" class="table table-striped table-bordered">
					<thead>
						<tr>
							<th>Código</th>
							<th>Usuário</th>
							<th>Login</th>
							<th>Senha</th>
							<th>Ação</th>

						</tr>
					</thead>
					<tbody>
						<!-- Expression Linguage -->
						<c:forEach items="${usuarios}" var="user">
							<tr>

								<td style="width: 150px"><c:out value="${user.id }"></c:out></td>
								<td><c:out value="${user.user }"></c:out></td>
								<td><c:out value="${user.login }"></c:out></td>
								<td><c:out value="${user.passwd }"></c:out></td>

								<td><a href="salvarUsuario?acao=delete&id=${user.id }"><button
											class="btn btn-danger" title="Excluir">
											<i class="far fa-trash-alt"></i>
										</button></a> <a href="salvarUsuario?acao=editar&id=${user.id }"><button
											class="btn btn-primary" title="Editar">
											<i class="fas fa-user-edit"></i>
										</button></a> <span class="glyphicon glyphicon-trash"></span></td>


							</tr>
						</c:forEach>
					</tbody>

				</table>
			</div>
		</div>
	</div>

</body>
</html>