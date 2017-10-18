angular.module('ifome')
	.controller('ListarCtrl', ['$scope', 'buscaProdutos', 'salvarPedido', 'excluirProduto', function($scope, buscaProdutos, salvarPedido, excluirProduto) {

		$scope.listResult = [];

		$scope.progresso = false;
		$scope.btnSalvar = true;

		function mostraProdutos() {
            buscaProdutos.query()
                .$promise.then(function (data) {
                $scope.listResult = data;
            })
			.catch(function (error) {
				console.log(error);
			});
        }

        mostraProdutos();


		$scope.total = 0;

		$scope.montaPedido = function (id) {

            $scope.pedido = {itens: []};

			$scope.listResult.forEach(function (produto) {
                if(produto.adicionar == true){
                    $scope.pedido.itens.push(produto);
                    if(produto.id == id) {
                        $scope.btnSalvar = false;
                        $scope.total = $scope.total + produto.preco;
                    }
                } else if(produto.id == id && produto.adicionar == false){
                    $scope.total = $scope.total - produto.preco;
				}

				if($scope.total == 0){
                	$scope.btnSalvar = true;
				}
			});
		};


        $scope.salvarPedidoFeito = function () {
            $scope.progresso = true;
            $scope.btnSalvar = true;

            setTimeout(function () {
                salvarPedido.save($scope.pedido);
                $scope.progresso = false;
                Materialize.toast('Pedido realizado com sucesso!', 4000, 'rounded toast-success');

            }, 2000);

			$scope.listResult.forEach(function (produto) {
				produto.adicionar = false;
                $scope.total = 0;
			});
        }


        $scope.excluirProduto = function (id) {
            excluirProduto.delete({produtoId: id})
                .$promise.then(function (data) {
                    $scope.listResult.forEach(function (produto) {
                        if(produto.id == id){
                            var indice = $scope.listResult.indexOf(produto);
                            $scope.listResult.splice(indice, 1);
                        }
                    });
                    Materialize.toast('Produto removido com sucesso', 2000, 'rounded toast-success');
                }).catch(function (response) {
                    Materialize.toast(response.data.message, 2000, 'rounded toast-error');
                });
        }

	}]);