var app = angular.module("app", ['ngRoute', 'ui.date']);

app.run(function ($rootScope, $http, $location) {
    
    $rootScope.empleado = null;
    $rootScope.estiloBloqueado = {'background-color':'#ffb478', 'font-weight':'bolder', 'color': 'black'};//Estilo para los input disabled
    $rootScope.comprobarSesion= function() {
            $http({
                method: "GET",
                url: contextPath + "/api/Session/Empleado"
            }).success(function(data,status) {
                if(status===200){
                    $rootScope.empleado=data;
                }else{
                    $location.path("/portada");
                }
            }).error(function(status) {
                alert("Error en la peticiión al servidor; error: " + status);
            });
        };
});

//Configuración datepicker
app.constant('uiDateConfig', {
    dateFormat: "dd-mm-yy",
    dayNamesMin: [ "Do", "Lu", "Ma", "Mi", "Ju", "Vi", "Sa" ],
    firstDay: 1,
    monthNames: [ "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre" ],
    defaultDate: new Date,
    //minDate: new Date(),
    maxDate: new Date,
    showWeek: true,
    weekHeader: "Sm"
});

