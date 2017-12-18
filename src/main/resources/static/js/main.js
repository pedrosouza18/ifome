(function(){

    'use strict';

    var app = angular.module("ifome", ['ui.router', 'ngResource', 'ifome.listarProduto', 'ifome.listarPedido', 'ifome.adicionarProduto']);

        app.config(function ($locationProvider, $urlRouterProvider) {

            $urlRouterProvider
                .when('/listar-produtos', '/', '','/404', '/error', '/listar-pedidos', 'novo-produto' , ['$state', function ($state) {
                    $state.go('listar');
                }])
                .otherwise('/');

            $locationProvider.html5Mode(true);

        });
})();
