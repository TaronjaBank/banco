app.config(['$routeProvider', function ($routeProvider) {
        $routeProvider.when('/main', {
            templateUrl: "main/main.html",
            controller: "MainController"
        });
    }]);


