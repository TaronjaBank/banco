app.config(['$routeProvider', function ($routeProvider) {
        
        $routeProvider.when('/login', {
            templateUrl: "login/login.html",
            controller: "LoginController"
        });
        
    }]);


