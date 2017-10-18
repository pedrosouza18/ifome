angular.module('Servicos', ['ngResource'])
    .factory('buscaProdutos', function($resource) {

        return $resource('produtos', {}, {
            query : {
                method: 'GET',
                isArray: true
            }
        });
    })

    .factory('salvarPedido', function($resource) {

        return $resource('pedidos', {}, {
            save : {
                method: 'POST'
            }
        });
    })

    .factory('mostraPedidos', function($resource) {

        return $resource('pedidos', {}, {
            query : {
                method: 'GET',
                isArray: true
            }
        });
    })

    .factory('excluirProduto', function($resource) {

        return $resource('produtos/:produtoId', {}, {
            delete : {
                method: 'DELETE'
            }
        });
    })

    .factory('salvarProduto', function($resource) {

        return $resource('produtos', {}, {
            save : {
                method: 'POST'
            }
        });
    });
