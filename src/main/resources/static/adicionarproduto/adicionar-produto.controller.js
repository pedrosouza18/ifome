angular.module('ifome.adicionarProduto')
    .controller('AdicionarProdutoCtrl', ['$scope', 'salvarProduto', '$state', '$routeParams', 'atualizarProduto', function($scope, salvarProduto, $state, $routeParams, atualizarProduto) {

        $scope.object = {};

        $scope.listarProdutos = function () {
            $state.go('listar');
        }

        $scope.listarPedidos = function () {
            $state.go('listarpedidos');
        }

        console.log($routeParams.produtoId);
        /*if($routeParams.produtoId)
            atualizarProduto.get({produtoId: $routeParams.produtoId})*/

        $scope.salvaProduto = function () {
            salvarProduto.save($scope.object);
            Materialize.toast('Produto Salvo com sucesso!', 1400, 'rounded toast-success');

            $scope.object = {};

            setTimeout(function () {
                $state.go('listar');
            }, 1400);
        }
    }]);