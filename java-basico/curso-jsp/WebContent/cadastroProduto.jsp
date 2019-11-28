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

<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.13.4/jquery.mask.min.js"></script>

<title>Cadastro de Produto</title>

</head>
<body>
	<div class="container">

		<div class="card text-white bg-primary">
			<div class="card-header">Cadastro de Produto</div>
		</div>


		<form action="salvarProduto" method="post" id="formProduto">

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
								readonly="readonly" value="${prod.id}">
						</div>

						<div class="form-group">
							<label for="login">Descrição</label> <input type="text"
								class="form-control col-md-4" id="descricao" placeholder="Descrição"
								name="descricao" ${edit} value="${prod.descricao}">
						</div>

						<div class="form-group">
							<label for="quantidade">Quantidade:</label> <input type="text"
								class="form-control col-md-4 money" id="quantidade" placeholder="Quantidade"
								name="quantidade" value="${prod.quantidade}">
						</div>

						<div class="form-group">
							<label for="fone">Valor:</label> <input type="text"
								class="form-control col-md-4 money" id="valor" placeholder="Valor"
								name="valor" value="${prod.valor}" >
						</div>
					</div>
				</div>

				<div class="form-group row">
					<div class="col-4">
						<button type="submit" class="btn btn-primary">Salvar</button>
						<a href="salvarProduto?acao=listarproduto">
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
							<th>Descrição</th>
							<th>Quantidade</th>
							<th>Valor</th>
							<th>Ação</th>

						</tr>
					</thead>
					<tbody>
						<!-- Expression Linguage -->
						<c:forEach items="${produto}" var="prod">
							<tr>

								<td style="width: 150px"><c:out value="${prod.id}"></c:out></td>
								<td><c:out value="${prod.descricao }"></c:out></td>
								<td><c:out value="${prod.quantidade }"></c:out></td>
								<td><c:out value="${prod.valor }"></c:out></td>

								<td><a href="salvarProduto?acao=delete&id=${prod.id}"><button
											class="btn btn-danger" title="Excluir">
											<i class="far fa-trash-alt"></i>
										</button></a> 
										
										<a href="salvarProduto?acao=editar&id=${prod.id}"  class="btn btn-primary" title="Editar" >											
											<i class="fas fa-edit"></i>
										</a></td>
							</tr>
						</c:forEach>
					</tbody>

				</table>
			</div>
		</div>
	</div> 

</body>


<script type="text/javascript">

$('.money').mask("#.##0,00", {reverse: true});
	
</script>


</html>