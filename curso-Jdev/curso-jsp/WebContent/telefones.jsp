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
<title>Cadastro de Telefones</title>

</head>
<body>
	<div class="container">

		<div class="card text-white bg-primary">
			<div class="card-header">
				<div class="row">
					<div class="col-md-6">
						<span style="font-size: 30px;">Cadastro de Telefones</span>
					</div>
					<div class="col-md-6">
						<ul class="nav nav-pills card-header-pills justify-content-end">
							<li class="nav-item"><a class="nav-link" href="home.jsp"
								title="Home"><i class="fas fa-home fa-2x"
									style="color: white;"></i></a></li>
							<li class="nav-item"><a class="nav-link"
								href="cadastroUsuario.jsp" title="Voltar"><i
									class="fas fa-undo fa-2x" style="color: white;"></i></a></li>
						</ul>
					</div>
				</div>
			</div>
		</div>


		<form action="salvarTelefones" method="post" id="formPhone"
			onsubmit="return validarCampos()">
			<fieldset class="form-group">
				<div class="row">

					<div class="col-md-12">
						<c:if test="${not empty msg}">
							<p>
							<div class="alert alert-danger" role="alert">${msg}</div>

						</c:if>
						<div class="form-group">
						<input type="hidden"
								class="col-1  form-control" id="userId" placeholder="" name="userId"
								 value="${userId}" >
								
								
							<label for="id">Usuário</label> <input type="text"
								class="col-1  form-control" id="user" placeholder="" name="user"
								readonly="readonly" value="${userName}">
						</div>

						<div class="row">
							<div class="col-md-4">
								<div class="form-group">
									<label for="fone">Telefone:</label> <input type="tel"
										class="fone form-control col-md-6" id="fone"
										placeholder="(__) ____-_____" name="fone" value="${fone.telefone}"
										pattern="\([0-9]{2}\)[\s][0-9]{4,5}-[0-9]{4}">
								</div>
							</div>
							<div class="col-md-4">
								<div class="form-group">
									<label for="tipo">Tipo:</label> <select class="form-control col-md-6"
										id="tipo">
										<option>Casa</option>
										<option>Contato</option>
										<option>Celular</option>
										<option>Trabalho</option>

									</select>
								</div>
							</div>
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
							<th>Telefone</th>
							<th>Tipo</th>
							<th>Ação</th>

						</tr>
					</thead>
					<tbody>
						<!-- Expression Linguage -->
						<c:forEach items="${telefones}" var="fone">
							<tr>

								<td style="width: 50px"><c:out value="${fone.id }"></c:out></td>
								<td><c:out value="${fone.telefone }"></c:out></td>
								<td><c:out value="${fone.tipo }"></c:out></td>

								<td><a href="salvarUsuario?acao=delete&id=${fone.id}"><button
											class="btn btn-danger" title="Excluir">
											<i class="far fa-trash-alt"></i>
										</button></a></td>
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

	function validarCampos() {
		if (document.getElementById("fone").value == '') {
			alert('Informe o Telefone');
			return false;
		}
		return true;
	}
</script>
</html>