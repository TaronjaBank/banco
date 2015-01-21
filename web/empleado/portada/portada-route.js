app.config(['$routeProvider', function ($routeProvider) {
        $routeProvider.when('/portada', {
            templateUrl: "portada/portada.html",
            controller: "PortadaController"
        });
    }]);


