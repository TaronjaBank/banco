var app = angular.module("app", ['ngRoute', 'ui.date']);

app.run(function ($rootScope, $http) {
    
    $rootScope.empleado = null;
    $rootScope.estiloBloqueado = {'background-color':'#ffb478', 'font-weight':'bolder'};//Estilo para los input disabled

});

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

