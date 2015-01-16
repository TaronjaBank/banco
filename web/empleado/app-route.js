app.config(['$routeProvider', function ($routeProvider) {
        
        $routeProvider.when('/index', {
            templateUrl: "index.html",
            controller: "IndexController"
        });
        
        $routeProvider.otherwise({redirectTo: '/'});
    }]);

