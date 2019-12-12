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
<title>Cadastro de Usu�rio</title>

</head>
<body>
	<div class="container">

		<div class="card text-white bg-primary">
			<div class="card-header">
				<div class="row">
					<div class="col-md-6">
						<span style="font-size: 30px;">Cadastro de Usu�rio</span>
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
							<label for="id">C�digo</label> <input type="text"
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
									<label for="user">Usu�rio:</label> <input type="text"
										class="form-control col-md-8" id="user" placeholder="Usu�rio"
										name="user" value="${user.user}">
								</div>
							</div>
							<div class="col-md-4">
								<div class="form-group">
									<div class="form-check">
										<input class="form-check-input" type="checkbox" name="ativo" id="ativo" ${user.ativo ? 'checked': ''} />
									    <label class="form-check-label"> Ativo </label>
									</div>
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
									<label for="endereco">Endere�o:</label> <input type="text"
										class="form-control" id="endereco" placeholder="Rua"
										name="endereco" value="${user.endereco}">
								</div>
							</div>

							<div class="col-md-1">
								<div class="form-group">
									<label for="endum">N�:</label> <input type="text"
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
									<label for="imgUser">Foto:</label> <input type="file"
										class="form-control-file" id="imgUser" name="imgUser">


								</div>
							</div>
							<div class="col-md-6">
								<div class="form-group">
									<label for="cvUser">Curr�culo:</label> <input type="file"
										class="form-control-file" id="cvUser" name="cvUser">
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
							<th>C�digo</th>
							<th>Usu�rio</th>
							<th>Foto</th>
							<th>Curr�culo</th>
							<th>Login</th>
							<th>CEP</th>
							<th>Endere�o</th>
							<th>Bairro</th>
							<th>Cidade</th>
							<th>UF</th>
							<th>A��o</th>

						</tr>
					</thead>
					<tbody>
						<!-- Expression Linguage -->
						<c:forEach items="${usuarios}" var="user">
							<tr>

								<td style="width: 50px"><c:out value="${user.id }"></c:out></td>
								<td><c:out value="${user.user }"></c:out></td>
								<td><c:if test="${not empty user.fotoBase64Min }">
										<a href="salvarUsuario?acao=download&id=${user.id }"><img
											alt="Imagem usu�rio" Title="Imagem usu�rio"
											src='<c:out value="${user.fotoBase64Min }"></c:out>'
											width="32px" height="32px"></a>
									</c:if> <c:if test="${empty user.fotoBase64Min }">
										<i class="fas fa-user-secret fa-3x"></i>
									</c:if></td>

								<td class="text-center"><c:if
										test="${not empty user.cvBase64}">
										<a href="salvarUsuario?acao=downloadCv&id=${user.id }"
											Title="Curr�culo"> <i class="far fa-file-pdf fa-3x"></i>
										</a>
									</c:if></td>


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
										</button></a> <a href="salvarUsuario?acao=delete&id=${user.id}"
									data-confirm='Tem certeza de que deseja excluir o usu�rio selecionado?'><button
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
	jQuery("input.fone").mask("(99) 99999-999?9").focusout(
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
			alert('Informe o Usu�rio');
			return false;
		} 
		return true;
	}

	$(document).ready(
			function() {

				function limpa_formul�rio_cep() {
					// Limpa valores do formul�rio de cep.
					$("#endereco").val("");
					$("#bairro").val("");
					$("#cidade").val("");
					$("#uf").val("");
				}

				//Quando o campo cep perde o foco.
				$("#cep").blur(
						function() {

							//Nova vari�vel "cep" somente com d�gitos.
							var cep = $(this).val().replace(/\D/g, '');

							//Verifica se campo cep possui valor informado.
							if (cep != "") {

								//Express�o regular para validar o CEP.
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
											//CEP pesquisado n�o foi encontrado.
											limpa_formul�rio_cep();
											alert("CEP n�o encontrado.");
										}
									});
								} //end if.
								else {
									//cep � inv�lido.
									limpa_formul�rio_cep();
									alert("Formato de CEP inv�lido.");
								}
							} //end if.
							else {
								//cep sem valor, limpa formul�rio.
								limpa_formul�rio_cep();
							}
						});
			});

	$(document)
			.ready(
					function() {
						$("a[data-confirm]")
								.click(
										function(ev) {
											var href = $(this).attr("href");
											if (!$("#confirm-delete").length) {
												$("body")
														.append(
																'<div class="modal fade" id="confirm-delete" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true"><div class="modal-dialog"><div class="modal-content"><div class="modal-header bg-danger text-white">EXCLUIR USU�RIO <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button></div><div class="modal-body">Tem certeza de que deseja excluir o usu�rio selecionado?</div><div class="modal-footer"><button type="button" class="btn btn-success" data-dismiss="modal">Cancelar</button><a class="btn btn-danger text-white" id="dataComfirmOK">Apagar</a></div></div></div></div>');
											}
											$("#dataComfirmOK").attr("href",
													href);
											$("#confirm-delete").modal({
												show : true
											});
											return false;
										});
					});
</script>
</html>