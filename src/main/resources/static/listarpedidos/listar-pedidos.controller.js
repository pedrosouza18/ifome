angular.module('ifome.listarPedido')
    .controller('ListarPedidosCtrl', ['$scope', 'mostraPedidos', '$state', function($scope, mostraPedidos, $state) {

        $scope.listResult = [];

        $scope.progresso = true;
        $scope.btnSalvar = true;

        $scope.listarProdutos = function () {
            $state.go('listar');
        }

        $scope.adicionarProduto = function () {
            $state.go('adicionarproduto');
        }

        mostraPedidos.query()
            .$promise.then(function (data) {
                $scope.listResult = data;
                $scope.progresso = false;
        })
        .catch(function (error) {
            console.log(error);
        });

    }]);