app.controller("LoginController", ['$scope', '$location', '$http', '$rootScope', function($scope, $location, $http, $rootScope) {

        $scope.irMain = function() {
            $location.path("/main");
        };

        $scope.irLogin = function() {
            $location.path("/login");
        };

        $scope.logIn = function() {
            $http({
                method: "POST",
                url: contextPath + "/api/Session/Empleado",
                data: $scope.credencial
            }).success(function(data) {
                $rootScope.empleado = data;
                $rootScope.rol = "empleado";
                $scope.irMain();
            }).error(function() {
                alert("No se ha podido inciar sesión, revise los datos introducidos");
            });
        };

        $scope.verEstadoSesion = function() {
            $http({
                method: "GET",
                url: contextPath + "/api/Session/Empleado"
            }).success(function(data) {
                if ($rootScope.empleado === data) {
                    alert("Sesión abierta");
                } else {
                    alert("Sesión cerrada");
                }
            }).error(function(status) {
                alert("Error en la peticiión al servidor; error: " + status);
            });
        };

        $scope.logOut = function() {
            $http({
                method: "DELETE",
                url: contextPath + "/api/Session/Empleado"
            }).success(function() {
                $rootScope.empleado = null;
                $rootScope.rol = "";
                $scope.irLogin();
            }).error(function() {
                alert("Error: no se ha podido realizar la operación");
            });
        };

    }]);


