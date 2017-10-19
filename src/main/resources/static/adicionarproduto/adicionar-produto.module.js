var app = angular.module("ifome.adicionarProduto", []);

app.config(function ($stateProvider) {

    var adicionarProduto = {
        name: 'adicionarproduto',
        url: '/novo-produto',
        templateUrl: 'adicionarproduto/adicionar-produto.html',
        controller: 'AdicionarProdutoCtrl'
    }

    $stateProvider.state(adicionarProduto);

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
});
