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
			<div class="card-header">
				<div class="row">
					<div class="col-md-6">
						<span style="font-size: 30px;">Cadastro de Usuário</span>
					</div>
					<div class="col-md-6">
						<ul class="nav nav-pills card-header-pills justify-content-end">
							<li class="nav-item"><a class="nav-link" href="home.jsp"
								title="Home"><i class="fas fa-home fa-2x"
									style="color: white;"></i></a></li>
							<li class="nav-item"><a class="nav-link" href="index.jsp"
								title="Sair"><i class="fas fa-sign-out-alt fa-2x"
									style="color: white;"></i></a></li>
						</ul>
					</div>
				</div>
			</div>
		</div>


		<form action="salvarUsuario" method="post" id="formUser"
			onsubmit="return validarCampos()" enctype="multipart/form-data">
			<fieldset class="form-group">
				<div class="row">
					<div class="col-md-12">
						<c:if test="${not empty msg}">
							<p>
							<div class="alert alert-danger" role="alert">${msg}</div>
						</c:if>
						<div class="form-group">
							<label for="id">Código</label> <input type="text"
								class="col-1  form-control" id="id" placeholder="" name="id"
								readonly="readonly" value="${user.id}">
						</div>

						<div class="row">
							<div class="col-md-4">
								<div class="form-group">
									<label for="login">Login:</label> <input type="text"
										class="form-control col-md-6" id="login" placeholder="Usuario"
										name="login" ${edit} value="${user.login}">
								</div>
							</div>
							<div class="col-md-4">
								<div class="form-group">
									<label for="passwd">Senha:</label> <input type="password"
										class="form-control col-md-6" id="passwd" placeholder="Senha"
										name="passwd" value="${user.passwd}">
								</div>
							</div>
						</div>


						<div class="row">
							<div class="col-md-4">
								<div class="form-group">
									<label for="user">Usuário:</label> <input type="text"
										class="form-control col-md-8" id="user" placeholder="Usuário"
										name="user" value="${user.user}">
								</div>
							</div>
							<div class="col-md-4">
								<div class="form-group">
									<label for="fone">Fone:</label> <input type="tel"
										class="fone form-control col-md-6" id="fone"
										placeholder="Fone" name="fone" value="${user.fone}"
										pattern="\([0-9]{2}\)[\s][0-9]{4,5}-[0-9]{4}">
								</div>
							</div>
						</div>

						<div class="row">
							<div class="col-md-4">
								<div class="form-group">
									<label for="cep">Cep:</label> <input type="text"
										class="form-control col-md-8" id="cep" placeholder="CEP"
										name="cep" required="" value="${user.cep}" maxlength="8"
										pattern="[0-9]+$">
								</div>
							</div>
						</div>

						<div class="row">
							<div class="col-md-6">
								<div class="form-group">
									<label for="endereco">Endereço:</label> <input type="text"
										class="form-control" id="endereco" placeholder="Rua"
										name="endereco" value="${user.endereco}">
								</div>
							</div>

							<div class="col-md-1">
								<div class="form-group">
									<label for="endum">N°:</label> <input type="text"
										class="form-control" id="endNum" placeholder="" name="endNum"
										value="${user.endNum}">
								</div>
							</div>
							<div class="col-md-5">
								<div class="form-group">
									<label for="bairro">Bairro:</label> <input type="text"
										class="form-control" id="bairro" placeholder="Bairro"
										name="bairro" value="${user.bairro}">
								</div>
							</div>
						</div>

						<div class="row">
							<div class="col-md-6">
								<div class="form-group">
									<label for="cidade">Cidade:</label> <input type="text"
										class="form-control" id="cidade" placeholder="Cidade"
										name="cidade" value="${user.cidade}">
								</div>
							</div>
							<div class="col-md-1">
								<div class="form-group">
									<label for="uf">Estado:</label> <input type="text"
										class="form-control" id="uf" placeholder=UF name="uf"
										value="${user.uf}">
								</div>
							</div>
						</div>

						<div class="row">
							<div class="col-md-6">
								<div class="form-group">
									<label for="imgUser">Foto:</label>
									<input type="file" class="form-control-file"
										id="imgUser">
								</div>
							</div>
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
							<th>CEP</th>
							<th>Endereço</th>
							<th>Bairro</th>
							<th>Cidade</th>
							<th>UF</th>
							<th>Ação</th>

						</tr>
					</thead>
					<tbody>
						<!-- Expression Linguage -->
						<c:forEach items="${usuarios}" var="user">
							<tr>

								<td style="width: 50px"><c:out value="${user.id }"></c:out></td>
								<td><c:out value="${user.user }"></c:out></td>
								<td><c:out value="${user.fone }"></c:out></td>
								<td><c:out value="${user.login }"></c:out></td>

								<td><c:out value="${user.cep }"></c:out></td>
								<td><c:out value="${user.endereco }, ${user.endNum}"></c:out></td>
								<td><c:out value="${user.bairro }"></c:out></td>
								<td><c:out value="${user.cidade }"></c:out></td>
								<td><c:out value="${user.uf }"></c:out></td>

								<td><a
									href="salvarTelefones?acao=addfone&userId=${user.id }"><button
											class="btn btn-secondary" title="Telefones">
											<i class="fas fa-phone"></i>
										</button></a> <a href="salvarUsuario?acao=editar&id=${user.id }"><button
											class="btn btn-primary" title="Editar">
											<i class="fas fa-user-edit"></i>
										</button></a> <a href="salvarUsuario?acao=delete&id=${user.id}"><button
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
		if (document.getElementById("login").value == '') {
			alert('Informe Login');
			return false;
		} else if (document.getElementById("passwd").value == '') {
			alert('Informe a Senha');
			return false;
		} else if (document.getElementById("user").value == '') {
			alert('Informe o Usuário');
			return false;
		} else if (document.getElementById("fone").value == '') {
			alert('Informe o Telefone');
			return false;
		}
		return true;
	}

	$(document).ready(
			function() {

				function limpa_formulário_cep() {
					// Limpa valores do formulário de cep.
					$("#endereco").val("");
					$("#bairro").val("");
					$("#cidade").val("");
					$("#uf").val("");
				}

				//Quando o campo cep perde o foco.
				$("#cep").blur(
						function() {

							//Nova variável "cep" somente com dígitos.
							var cep = $(this).val().replace(/\D/g, '');

							//Verifica se campo cep possui valor informado.
							if (cep != "") {

								//Expressão regular para validar o CEP.
								var validacep = /^[0-9]{8}$/;

								//Valida o formato do CEP.
								if (validacep.test(cep)) {

									//Preenche os campos com "..." enquanto consulta webservice.
									$("#endereco").val("...");
									$("#bairro").val("...");
									$("#cidade").val("...");
									$("#uf").val("...");

									//Consulta o webservice viacep.com.br/
									$.getJSON("https://viacep.com.br/ws/" + cep
											+ "/json/?callback=?", function(
											dados) {

										if (!("erro" in dados)) {
											//Atualiza os campos com os valores da consulta.
											$("#endereco")
													.val(dados.logradouro);
											$("#bairro").val(dados.bairro);
											$("#cidade").val(dados.localidade);
											$("#uf").val(dados.uf);
										} //end if.
										else {
											//CEP pesquisado não foi encontrado.
											limpa_formulário_cep();
											alert("CEP não encontrado.");
										}
									});
								} //end if.
								else {
									//cep é inválido.
									limpa_formulário_cep();
									alert("Formato de CEP inválido.");
								}
							} //end if.
							else {
								//cep sem valor, limpa formulário.
								limpa_formulário_cep();
							}
						});
			});
</script>
</html>