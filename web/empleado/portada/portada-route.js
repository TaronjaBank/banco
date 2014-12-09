app.config(['$routeProvider', function ($routeProvider) {
        $routeProvider.when('/', {
            templateUrl: "portada/portada.html",
            controller: "PortadaController"
        });
    }]);


