app.config(['$routeProvider', function ($routeProvider) {

        $routeProvider.when("/empleado/main", {
            templateUrl: "empleado/empleado-main.html",
            controller: "EmpleadoMainController"
        });
        $routeProvider.when('/empleado/new', {
            templateUrl: "empleado/empleado-detail.html",
            controller: "EmpleadoInsertController"
        });
        $routeProvider.when("/empleado/update/:idEmpleado", {
            templateUrl: "empleado/empleado-detail.html",
            controller: "EmpleadoUpdateController"
        });
        $routeProvider.when('/empleado/delete/:idEmpleado', {
            templateUrl: "empleado/empleado-detail.html",
            controller: "EmpleadoDeleteController"
        });
        $routeProvider.when('/empleado/list', {
            templateUrl: "empleado/empleado-list.html",
            controller: "EmpleadoListController"
        });

    }]);


