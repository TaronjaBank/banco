app.controller("LoginController", ['$scope', '$location', '$http', '$rootScope', function($scope, $location, $http, $rootScope) {
        
        $scope.logIn = function() {
            $http({
                method: "POST",
                url: contextPath + "/api/Session/Empleado",
                data: $scope.credencial
            }).success(function(data) {
                $rootScope.empleado = data;
                $location.path("/main");
            }).error(function() {
                alert("No se ha podido inciar sesión, revise los datos introducidos");
            });
        };

        $scope.getSesion = function() {
            $http({
                method: "GET",
                url: contextPath + "/api/Session/Empleado"
            }).success(function(data) {
                $rootScope.empleado = data;
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
                 $location.path("/portada");
            }).error(function() {
                alert("Error: no se ha podido realizar la operación");
            });
        };

    }]);


