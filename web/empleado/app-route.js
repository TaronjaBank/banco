app.config(['$routeProvider', function ($routeProvider) {
        
        $routeProvider.when('/indexEmpleado', {
            templateUrl: "index.html",
            controller: "IndexController"
        });
        
        $routeProvider.otherwise({redirectTo: '/portada'});
    }]);

