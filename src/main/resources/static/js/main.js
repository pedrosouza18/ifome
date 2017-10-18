angular.module('ifome', ['ui.router', 'ngResource' , 'Servicos'])

    .config(function ($stateProvider) {

        $stateProvider
            .state('ifome', {
            url: '/',
            template: '<h3>hello world!</h3>'
        });
    });
