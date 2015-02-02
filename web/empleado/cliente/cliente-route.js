app.config(["$routeProvider", function ($routeProvider) {
        
        $routeProvider.when("/cliente/main", {
            templateUrl: "cliente/cliente-main.html",
            controller: "ClienteMainController"
        });
        
        $routeProvider.when("/cliente/new", {
            templateUrl: "cliente/cliente-detail.html",
            controller: "ClienteInsertController"
        });
        
        $routeProvider.when("/cliente/update/:idCliente", {
            templateUrl: "cliente/cliente-detail.html",
            controller: "ClienteUpdateController"
        });
        
        $routeProvider.when("/cliente/delete/:idCliente", {
            templateUrl: "cliente/cliente-detail.html",
            controller: "ClienteDeleteController"
        });
        
        $routeProvider.when("/cliente/list", {
            templateUrl: "cliente/cliente-list.html",
            controller: "ClienteListController"
        });

    }]);
