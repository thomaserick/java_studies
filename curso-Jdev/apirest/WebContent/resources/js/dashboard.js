
jQuery("input.fone").mask("(99) 99999-999?9").focusout(
	function (event) {
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
	} else if (document.getElementById("sexo").value == '') {
		alert('Informe o Sexo');
		return false;
		return true;
	}
}

$(document).ready(
	function () {

		function limpa_formulario_cep() {
			// Limpa valores do formul�rio de cep. 
			$("#endereco").val("");
			$("#bairro").val("");
			$("#cidade").val("");
			$("#uf").val("");
		}

		//Quando o campo cep perde o foco.
		$("#cep").blur(
			function () {

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
							+ "/json/?callback=?", function (
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
									limpa_formulario_cep();
									alert("CEP n�o encontrado.");
								}
							});
					} //end if.
					else {
						//cep � inv�lido.
						limpa_formulario_cep();
						alert("Formato de CEP inv�lido.");
					}
				} //end if.
				else {
					//cep sem valor, limpa formul�rio.
					limpa_formulario_cep();
				}
			});
	});

$(document)
	.ready(
		function () {
			$("a[data-confirm]")
				.click(
					function (ev) {
						var href = $(this).attr("href");
						if (!$("#confirm-delete").length) {
							$("body")
								.append(
									'<div class="modal fade" id="confirm-delete" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true"><div class="modal-dialog"><div class="modal-content"><div class="modal-header bg-danger text-white">EXCLUIR USU�RIO <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button></div><div class="modal-body">Tem certeza de que deseja excluir o usu�rio selecionado?</div><div class="modal-footer"><button type="button" class="btn btn-success" data-dismiss="modal">Cancelar</button><a class="btn btn-danger text-white" id="dataComfirmOK">Apagar</a></div></div></div></div>');
						}
						$("#dataComfirmOK").attr("href",
							href);
						$("#confirm-delete").modal({
							show: true
						});
						return false;
					});
		});
