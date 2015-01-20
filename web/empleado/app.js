var app = angular.module("app", ['ngRoute', 'ui.date']);

app.run(function ($rootScope, $http) {
    
    $rootScope.empleado = null;
    $rootScope.rol = "";
    $rootScope.estiloBloqueado = {'background-color':'#ffb478', 'font-weight':'bolder'};//Estilo para los input disabled

    $rootScope.asignarEstadoSesion = function() {
            $http({
                method: "GET",
                url: contextPath + "/api/Session/Empleado"
            }).success(function(data) {
                if ($rootScope.empleado === data) {
                    alert("Sesión abierta");
                } else {
                    $rootScope.empleado=data;
                    $rootScope.rol = "empleado";
                }
            }).error(function(status) {
                alert("Error en la peticiión al servidor; error: " + status);
            });
        };
});

