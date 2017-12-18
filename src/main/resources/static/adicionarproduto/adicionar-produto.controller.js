(function(){

    'use strict';

    angular.module('ifome.adicionarProduto')
        .controller('AdicionarProdutoCtrl', ['$scope', 'salvarProduto', '$state', '$stateParams', 'atualizarProduto', 'buscarProduto', function($scope, salvarProduto, $state, $stateParams, atualizarProduto, buscarProduto) {

            $scope.object = {};

            $scope.listarProdutos = function () {
                $state.go('listar');
            }

            $scope.listarPedidos = function () {
                $state.go('listarpedidos');
            }


            if($stateParams.produtoId) {
                buscarProduto.get({produtoId: $stateParams.produtoId})
                    .$promise.then(function (data) {
                        $scope.object = angular.copy(data);
                })
                    .catch(function (response) {
                        console.log(response);
                    });
            }

            $scope.salvaProduto = function () {

                if($stateParams.produtoId){
                    atualizarProduto.update({produtoId: $stateParams.produtoId}, $scope.object);
                    Materialize.toast('Produto Alterado com sucesso!', 1400, 'rounded toast-success');

                    setTimeout(function () {
                        $state.go('listar');
                    }, 1400);

                } else {
                    salvarProduto.save($scope.object);
                    Materialize.toast('Produto Salvo com sucesso!', 1400, 'rounded toast-success');

                    $scope.object = {};

                    setTimeout(function () {
                        $state.go('listar');
                    }, 1400);
                }
            }
        }]);
})();
