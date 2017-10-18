angular.module('ifome')
    .controller('AdicionarProdutoCtrl', ['$scope', 'salvarProduto', function($scope, salvarProduto) {

        $scope.object = {};

        console.log($scope.object);

        $scope.salvaProduto = function () {
            salvarProduto.save($scope.object);
            Materialize.toast('Produto Salvo com sucesso!', 1500, 'rounded toast-success');

            $scope.object = {};

            setTimeout(function () {
                window.location.href = "index.html";
            }, 2000);
        }
    }]);