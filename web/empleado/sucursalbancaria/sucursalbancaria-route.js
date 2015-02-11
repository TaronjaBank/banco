app.config(["$routeProvider", function ($routeProvider) {
        
        $routeProvider.when("/sucursalbancaria/main", {
            templateUrl: "sucursalbancaria/sucursalbancaria-main.html",
            controller: "SucursalBancariaMainController"
        });
        
        $routeProvider.when("/sucursalbancaria/new", {
            templateUrl: "sucursalbancaria/sucursalbancaria-detail.html",
            controller: "SucursalBancariaInsertController"
        });
        
         $routeProvider.when("/sucursalbancaria/new/:idEntidadBancaria", {
            templateUrl: "sucursalbancaria/sucursalbancaria-detail.html",
            controller: "SucursalBancariaInsertController"
        });
        
        $routeProvider.when("/sucursalbancaria/update/:idSucursalBancaria", {
            templateUrl: "sucursalbancaria/sucursalbancaria-detail.html",
            controller: "SucursalBancariaUpdateController"
        });
        
        $routeProvider.when("/sucursalbancaria/delete/:idSucursalBancaria", {
            templateUrl: "sucursalbancaria/sucursalbancaria-detail.html",
            controller: "SucursalBancariaDeleteController"
        });
        
        $routeProvider.when("/sucursalbancaria/list", {
            templateUrl: "sucursalbancaria/sucursalbancaria-list.html",
            controller: "SucursalBancariaListController"
        });

    }]);
