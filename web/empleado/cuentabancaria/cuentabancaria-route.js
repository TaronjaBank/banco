
app.config(['$routeProvider', function ($routeProvider) {
        $routeProvider.when("/cuentabancaria/main", {
            templateUrl: "cuentabancaria/cuentabancaria-main.html",
            controller: "CuentaBancariaMainController"
        });
        $routeProvider.when('/cuentabancaria/new', {
            templateUrl: "cuentabancaria/cuentabancaria-detail.html",
            controller: "CuentaBancariaInsertController"
        });
        $routeProvider.when('/cuentabancaria/update/:idCuentaBancaria', {
            templateUrl: "cuentabancaria/cuentabancaria-detail.html",
            controller: "CuentaBancariaUpdateController"
        });
        $routeProvider.when('/cuentabancaria/delete/:idCuentaBancaria', {
            templateUrl: "cuentabancaria/cuentabancaria-detail.html",
            controller: "CuentaBancariaDeleteController"
        });
        $routeProvider.when('/cuentabancaria/list', {
            templateUrl: "cuentabancaria/cuentabancaria-list.html",
            controller: "CuentaBancariaListController"
        });
        
        
        
        $routeProvider.otherwise({redirectTo: '/'});
    }]);


