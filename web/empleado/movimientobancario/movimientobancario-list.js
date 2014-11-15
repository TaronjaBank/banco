    app.controller("MovimientoBancarioListController", ["$scope", "$http", function($scope, $http){
        $scope.findAll=function(){
        $http({
        method:"GET",
        url:contextPath+"/api/MovimientoBancario"
        }).success(function(data) {
            $scope.movimientosBancarios=data;
        }).error(function() {
             alert("No se ha podido listar.");
        });//success.Error
        };//Consultar
        
        $scope.findAll();
    }]);