var app = angular.module("app", ['ngRoute', 'ui.date']);

app.run(function ($rootScope, $http, $q) {

    $rootScope.empleado = null;
    $rootScope.estiloBloqueado = {'background-color': '#ffb478', 'font-weight': 'bold', 'color': 'brown'};//Estilo para los input disabled

    $rootScope.comprobarSesion = function () {

        var defered = $q.defer();
        var promise = defered.promise;

        $http({
            method: "GET",
            url: contextPath + "/api/Session/Empleado"
        }).success(function (data, status) {
            $rootScope.empleado = data;
            defered.resolve(status);
        }).error(function (status) {
            defered.reject(status);
        });
        return promise;
    };
});

//Configuración datepicker
app.constant('uiDateConfig', {
    dateFormat: "dd-mm-yy",
    dayNamesMin: ["Do", "Lu", "Ma", "Mi", "Ju", "Vi", "Sa"],
    firstDay: 1,
    monthNames: ["Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"],
    defaultDate: new Date,
    //minDate: new Date(),
    maxDate: new Date,
    showWeek: true,
    weekHeader: "Sm"
});
