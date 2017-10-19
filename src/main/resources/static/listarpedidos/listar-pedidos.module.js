var app = angular.module("ifome.listarPedido", []);

app.config(function ($stateProvider) {

    var listarStatePedido = {
        name: 'listarpedidos',
        url: '/listar-pedidos',
        templateUrl: 'listarpedidos/listar-pedidos.html',
        controller: 'ListarPedidosCtrl'
    }

    $stateProvider.state(listarStatePedido);

})

app.factory('mostraPedidos', function($resource) {

    return $resource('pedidos', {}, {
        query : {
            method: 'GET',
            isArray: true
        }
    });
});


