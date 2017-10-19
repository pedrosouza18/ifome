var app = angular.module("ifome.listarProduto", []);

app.config(function ($stateProvider) {

    var listarState = {
        name: 'listar',
        url: '/',
        templateUrl: 'listarprodutos/listar.html',
        controller: 'ListarCtrl'
    }

    $stateProvider.state(listarState);

})

app.factory('buscaProdutos', function($resource) {

    return $resource('produtos', {}, {
        query : {
            method: 'GET',
            isArray: true
        }
    });
})

app.factory('salvarPedido', function($resource) {

    return $resource('pedidos', {}, {
        save : {
            method: 'POST'
        }
    });
})

app.factory('excluirProduto', function($resource) {

    return $resource('produtos/:produtoId', {}, {
        delete : {
            method: 'DELETE'
        }
    });
});
