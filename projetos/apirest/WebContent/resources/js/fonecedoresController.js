var app = angular.module('fornecedoresApp', ['angular.viacep', 'ui.mask', 'angular-growl', 'ngAnimate']);

angular.module('fornecedoresApp').config(['growlProvider', function (growlProvider) {
  //Configuração do tempo que a mensagem ficará na tela
   growlProvider.globalInlineMessages(true);
   growlProvider.globalDisableCountDown(true);
   growlProvider.globalTimeToLive(3000);
}]);

app.controller('fornecedoresController', function ($scope,$window,fornecedorService,growl) {


	$scope.fornecedor = {};
	var config = {};
	list();

	function list() {
		$scope.fornecedores = fornecedorService.list().then(function (response) {
			$scope.fornecedores = response.data

		})
	}

	function clear() {
		$scope.fornecedor = {};
		$scope.formFornec.$setPristine();
	}


	$scope.save = function (fornecedor) {

		if ($scope.formFornec.$invalid) {
			return;
		}
		
		fornecedorService.save(fornecedor).then(list)	
		if(fornecedor.id){
			growl.success("<b>Fornecedor alterado com Sucesso</b>", config);
		}else {
			growl.success("<b>Fornecedor incluido com Sucesso</b>", config);
		}
		clear();
		

	}

	$scope.edit = function (fornecedor) {
		$scope.fornecedor = angular.copy(fornecedor);
	}

	$scope.delete = function (fornecedor) {

		if($window.confirm("Deseja realmente excluir esse registro?")){
			fornecedorService.delete(fornecedor).then(list)
			growl.success("<b>Fornecedor deletado com Sucesso</b>", config);
		}
	
	}

	$scope.cancel = function () {
		clear();
	}


});


app.service('fornecedorService', function ($http) {

	var api = "/apirest/rest/fornecedor/"	
	this.list = function () {

		return $http.get(api + 'list');

	}

	this.save = function (fornecedor) {

		/* fornecedor.cnpj = fornecedor.cnpj.replace(/[^\d]+/g,''); */

		if (fornecedor.id) {
			
			return $http.put(api + 'edit/' + fornecedor.id, fornecedor)
			
		} else {
			
			return $http.post(api + 'add', fornecedor)
		}		

	}

	this.delete = function (fornecedor) {

		return $http.delete(api + 'delet/' + fornecedor.id);
	}


});