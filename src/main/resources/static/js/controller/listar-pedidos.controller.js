angular.module('ifome')
    .controller('ListarPedidosCtrl', ['$scope', 'mostraPedidos', function($scope, mostraPedidos) {

        $scope.listResult = [];

        $scope.progresso = true;
        $scope.btnSalvar = true;

        mostraPedidos.query()
            .$promise.then(function (data) {
                $scope.listResult = data;
                $scope.progresso = false;
        })
        .catch(function (error) {
            console.log(error);
        });

    }]);