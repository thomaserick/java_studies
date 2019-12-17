var app = angular.module('fornecedoresApp', []);

app.controller('fornecedoresController', function ($scope, fornecedorService) {


	$scope.fornecedor = {};
	list();

	function list() {
		$scope.fornecedores = fornecedorService.list().then(function (response) {
			$scope.fornecedores = response.data

		})
	}

	$scope.save = function (fornecedor) {

		if($scope.formFornec.$invalid){		
			return;
		}

		fornecedorService.save(fornecedor).then(list)
		$scope.fornecedor = {};		
		$scope.formFornec.$setPristine();

	}

	$scope.edit = function (fornecedor) {
		$scope.fornecedor = angular.copy(fornecedor);
	}

	$scope.delete = function (fornecedor) {
		fornecedorService.delete(fornecedor).then(list)

	}

	$scope.cancel = function () {
		$scope.fornecedor = {};	
		$scope.formFornec.$setPristine();
	}

});


app.service('fornecedorService', function ($http) {


	var api = "/apirest/rest/fornecedor/"


	this.list = function () {

		return $http.get(api + 'list');

	}

	this.save = function (fornecedor) {


		if (fornecedor.id) {

			return $http.put(api + 'edit/' + fornecedor.id, fornecedor)

		} else {

			return $http.post(api+'add', fornecedor)

		}

	}

	this.delete = function (fornecedor) {

		return $http.delete(api + 'delet/'+ fornecedor.id);
	}







});