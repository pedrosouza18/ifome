var app = angular.module("ifome.adicionarProduto", []);

app.config(function ($stateProvider) {

    var adicionarProduto = {
        name: 'adicionarproduto',
        url: '/novo-produto',
        templateUrl: 'adicionarproduto/adicionar-produto.html',
        controller: 'AdicionarProdutoCtrl'
    }

    var editarProduto = {
        name: 'editarproduto',
        url: '/{produtoId: int}/editar-produto',
        templateUrl: 'adicionarproduto/adicionar-produto.html',
        controller: 'AdicionarProdutoCtrl'
    }

    $stateProvider.state(adicionarProduto);
    $stateProvider.state(editarProduto);

})

app.factory('salvarProduto', function($resource) {

    return $resource('produtos', {}, {
        save : {
            method: 'POST'
        }
    });
})

app.factory('atualizarProduto', function($resource) {

    return $resource('produtos/:produtoId/editar', null, {
        'update' : {
            method: 'PUT'
        }
    });
})

app.factory('buscarProduto', function($resource) {

    return $resource('produtos/:produtoId', {}, {
        get : {
            method: 'GET'
        }
    });
});

