app.config(['$routeProvider', function ($routeProvider) {
        $routeProvider.when('/', {
            templateUrl: "main/main.html",
            controller: "MainController"
        });
    }]);


