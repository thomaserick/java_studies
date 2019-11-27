<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">


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


<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery.maskedinput/1.4.1/jquery.maskedinput.min.js"></script>
<title>Cadastro de Usuário</title>

</head>
<body>
	<div class="container">

		<div class="card text-white bg-primary">
			<div class="card-header">Cadastro de Usuário</div>
		</div>


		<form action="salvarUsuario" method="post" id="formUser">

			<fieldset class="form-group">
				<div class="row">

					<div class="col-md-9">


						<c:if test="${not empty msg}">
							<p>
							<div class="alert alert-danger" role="alert">${msg}</div>
							</p>
						</c:if>
						<div class="form-group">
							<label for="id">Código</label> <input type="text"
								class="col-1  form-control" id="id" placeholder="" name="id"
								readonly="readonly" value="${user.id}">
						</div>

						<div class="form-group">
							<label for="login">Login:</label> <input type="text"
								class="form-control col-md-4" id="login" placeholder="Usuario"
								name="login" ${edit} value="${user.login}">
						</div>


						<div class="form-group">
							<label for="passwd">Senha:</label> <input type="password"
								class="form-control col-md-4" id="passwd" placeholder="Senha"
								name="passwd" value="${user.passwd}">
						</div>
						<div class="form-group">
							<label for="user">Usuário:</label> <input type="text"
								class="form-control col-md-4" id="user" placeholder="Usuário"
								name="user" value="${user.user}">
						</div>

						<div class="form-group">
							<label for="fone">Fone:</label> <input type="tel"
								class="fone form-control col-md-4" id="fone" placeholder="Fone"
								name="fone" value="${user.fone}"
								pattern="\([0-9]{2}\)[\s][0-9]{4,5}-[0-9]{4}">
						</div>
					</div>
				</div>

				<div class="form-group row">
					<div class="col-4">
						<button type="submit" class="btn btn-primary">Salvar</button>
						<a href="salvarUsuario?acao=listaruser">
							<button type="button" class="btn btn-danger">Cancelar</button>
						</a>
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
							<th>Fone</th>
							<th>Login</th>
							<th>Ação</th>

						</tr>
					</thead>
					<tbody>
						<!-- Expression Linguage -->
						<c:forEach items="${usuarios}" var="user">
							<tr>

								<td style="width: 150px"><c:out value="${user.id }"></c:out></td>
								<td><c:out value="${user.user }"></c:out></td>
								<td><c:out value="${user.fone }"></c:out></td>
								<td><c:out value="${user.login }"></c:out></td>

								<td><a href="salvarUsuario?acao=delete&id=${user.id}"><button
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


<script type="text/javascript">
	jQuery("input.fone").mask("(99) 9999-9999?9").focusout(
			function(event) {
				var target, phone, element;
				target = (event.currentTarget) ? event.currentTarget
						: event.srcElement;
				phone = target.value.replace(/\D/g, '');
				element = $(target);
				element.unmask();
				if (phone.length > 10) {
					element.mask("(99) 99999-999?9");
				} else {
					element.mask("(99) 9999-9999?9");
				}
			});
</script>


</html>