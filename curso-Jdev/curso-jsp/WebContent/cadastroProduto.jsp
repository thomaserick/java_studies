<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>

<%@taglib uri="http://java.sun.com/jsp/jstl/fmt"
          prefix="fmt" %>
          


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js" type="text/javascript"></script>
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
	src="resources/js/jquery.maskMoney.min.js"></script>

<title>Cadastro de Produto</title>

</head>
<body>
	<div class="container">

		<div class="card text-white bg-primary">
			<div class="card-header">
				<div class="row">
					<div class="col-6">
						<span style="font-size:30px;">Cadastro de Produto</span>
					</div>
					<div class="col-6">
						<ul class="nav nav-pills card-header-pills justify-content-end">
							<li class="nav-item"><a class="nav-link" href="home.jsp" title="Home"><i class="fas fa-home fa-2x" style="color:white;"></i></a></li>
							<li class="nav-item"><a class="nav-link" href="index.jsp" title="Sair"><i class="fas fa-sign-out-alt fa-2x" style="color:white;"></i></a></li>
						</ul>
					</div>
				</div>
			</div>
		</div>


		<form action="salvarProduto" method="post" id="formProduto"
			onsubmit="return validarCampos();">

			<fieldset class="form-group">
				<div class="row">
					<div class="col-md-9">
						<c:if test="${not empty msg}">
							
							<div class="alert alert-danger" role="alert">${msg}</div>
						
						</c:if>
						<div class="form-group">
							<label for="id">Código</label> <input type="text"
								class="col-1  form-control" id="id" placeholder="" name="id"
								readonly="readonly" value="${prod.id}">
						</div>

						<div class="form-group">
							<label for="login">Descrição</label> <input type="text"
								class="form-control col-md-4" id="descricao" maxlength="150"
								placeholder="Descrição" name="descricao" ${edit}
								value="${prod.descricao}">
						</div>
						<div class ="form-group">
							<label for="login">Categoria</label>
							<select id="categoria_id" name="categoria_id" class="form-control col-md-6">
							<option value="">Selecione</option> 						
							<c:forEach items="${categorias}" var="cat">		
													
								<option value="${cat.id}" id="${cat.id}"								
							
								<c:if test="${cat.id == prod.categoria_id}">
										<c:out value="selected=selected"/>	
								</c:if>>
								
								${cat.descricao}
								</option>				
							
													
							<%-- <option value="${cat.id}" id="${cat.id}" ${prod.categoria_id == cat_id ? 'selected': ''}>${cat.descricao}</option>		 --%>					
							</c:forEach>
							</select>
						</div>
						<div class="form-group">
							<label for="quantidade">Quantidade:</label> <input type="number"
								class="form-control col-md-4" id="quantidade"
								onchange="calcular()" placeholder="0.00" name="quantidade"
								value="${prod.quantidade}" step="0.01">
						</div>

						<div class="form-group">
							<label for="fone">Valor:</label> <input  step=".10" 
								type="text" class="form-control col-md-4" id="valor" data-thousands="." data-decimal=","
								onchange="calcular()" placeholder="0.00" name="valor"
								value="${prod.parseValor}">
						</div>

						<div class="form-group">
							<label for="fone">Total:</label> <input type="number" step=".10"
								class="form-control col-md-4 " id="total" placeholder="Total"
								name="total" readonly="readonly" value="">
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
							<th>Valor R$</th>
							<th>Ação</th>

						</tr>
					</thead>
					<tbody>
						<!-- Expression Linguage -->
						<c:forEach items="${produto}" var="prod">
							<tr>

								<td style="width: 150px"><c:out value="${prod.id}"></c:out></td>
								<td><c:out value="${prod.descricao }"></c:out></td>
								<fmt:setLocale value="pt-BR" />		
								<td class=""><fmt:formatNumber type="currency" maxFractionDigits="2" currencySymbol="" value="${prod.quantidade}" />	</td> 		
							 	<td class=""><fmt:formatNumber type="currency" maxFractionDigits="2" currencySymbol="R$" value="${prod.valor}" />	</td>
								<td><a href="salvarProduto?acao=delete&id=${prod.id}" data-confirm='Tem certeza de que deseja excluir o item selecionado?'><button
											class="btn btn-danger" title="Excluir">
											<i class="far fa-trash-alt"></i>
										</button></a> <a href="salvarProduto?acao=editar&id=${prod.id}"  
									class="btn btn-primary" title="Editar"> <i
										class="fas fa-edit"></i>
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
	function calcular() {

		var qtde = parseFloat(document.getElementById('quantidade').value);
		var valor = parseFloat(document.getElementById('valor').value);

		var total = qtde * valor

		document.getElementById('total').value = total.toFixed(2);

	}

	function validarCampos() {

		if (document.getElementById('descricao').value == '') {
			alert('Informe a Descrição');
			return false;
		} else if (document.getElementById('quantidade').value == '') {
			alert("Informe a Quantidade");
			return false;
		} else if (document.getElementById('valor').value == '') {
			alert("Informe o Valor");
			return false;
		}

		return true;	
		
	}
	
	$(function() {
	    $('#valor').maskMoney();
	  })
	
	$(document).ready(function(){
		$('.qtde').mask("#.##0.00", {
			reverse : true
		});
	    
	}); 
	
	$(document).ready(function() {
		  $("a[data-confirm]").click(function(ev) {
		    var href = $(this).attr("href");
		    if (!$("#confirm-delete").length) {
		      $("body").append(
		        '<div class="modal fade" id="confirm-delete" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true"><div class="modal-dialog"><div class="modal-content"><div class="modal-header bg-danger text-white">EXCLUIR PRODUTO <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button></div><div class="modal-body">Tem certeza de que deseja excluir o item selecionado?</div><div class="modal-footer"><button type="button" class="btn btn-success" data-dismiss="modal">Cancelar</button><a class="btn btn-danger text-white" id="dataComfirmOK">Apagar</a></div></div></div></div>'
		      );
		    }
		    $("#dataComfirmOK").attr("href", href);
		    $("#confirm-delete").modal({ show: true });
		    return false;
		  });
		});
	

</script>


</html>