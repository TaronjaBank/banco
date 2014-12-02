app.config(['$routeProvider', function ($routeProvider) {

        $routeProvider.when("/movimientobancario/main", {
            templateUrl: "movimientobancario/movimientobancario-main.html",
            controller: "MovimientoBancarioMainController"
        });
        $routeProvider.when('/movimientobancario/new', {
            templateUrl: "movimientobancario/movimientobancario-detail.html",
            controller: "MovimientoBancarioInsertController"
        });

        $routeProvider.when('/movimientobancario/update/:idMovimientoBancario', {
            templateUrl: "movimientobancario/movimientobancario-detail.html",
            controller: "MovimientoBancarioUpdateController"
        });
        $routeProvider.when('/movimientobancario/delete/:idMovimientoBancario', {
            templateUrl: "movimientobancario/movimientobancario-detail.html",
            controller: "MovimientoBancarioDeleteController"
        });
        $routeProvider.when('/movimientobancario/list', {
            templateUrl: "movimientobancario/movimientobancario-list.html",
            controller: "MovimientoBancarioListController"
        });

        

        

    }]);