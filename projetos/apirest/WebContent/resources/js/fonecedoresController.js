var app = angular.module('fornecedoresApp', ['angular.viacep', 'ui.mask']);

app.controller('fornecedoresController', function ($scope,$window, fornecedorService) {


	$scope.fornecedor = {};
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
		clear();


	}

	$scope.edit = function (fornecedor) {
		$scope.fornecedor = angular.copy(fornecedor);
	}

	$scope.delete = function (fornecedor) {

		if($window.confirm("Deseja realmente excluir esse registro?")){
			fornecedorService.delete(fornecedor).then(list)
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