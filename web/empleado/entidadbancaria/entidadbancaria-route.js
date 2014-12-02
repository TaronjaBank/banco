app.config(['$routeProvider', function ($routeProvider) {

        $routeProvider.when("/entidadbancaria/main", {
            templateUrl: "entidadbancaria/entidadbancaria-main.html",
            controller: "EntidadBancariaMainController"
        });
        $routeProvider.when('/entidadbancaria/new', {
            templateUrl: "entidadbancaria/entidadbancaria-detail.html",
            controller: "EntidadBancariaInsertController"
        });
        
        $routeProvider.when("/entidadbancaria/update/:idEntidadBancaria", {
            templateUrl: "entidadbancaria/entidadbancaria-detail.html",
            controller: "EntidadBancariaUpdateController"
        });
        $routeProvider.when('/entidadbancaria/delete/:idEntidadBancaria', {
            templateUrl: "entidadbancaria/entidadbancaria-detail.html",
            controller: "EntidadBancariaDeleteController"
        });
        $routeProvider.when('/entidadbancaria/list', {
            templateUrl: "entidadbancaria/entidadbancaria-list.html",
            controller: "EntidadBancariaListController"
        });

        

        

    }]);

