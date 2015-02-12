app.controller("CuentaBancariaMainController", ["$rootScope", "$location", function ($rootScope, $location) {
        var promise = $rootScope.comprobarSesion();

        promise.then(function (status) {
            if (status === 200) {

            } else {
                $location.path("/portada");
                $rootScope.empleado = null;
            }
        }, function (error) {
            alert("Se ha producido un error al obtener el dato:" + error);
        });

    }]);


