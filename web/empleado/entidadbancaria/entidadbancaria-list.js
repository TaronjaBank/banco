app.controller("EntidadBancariaListController", ["$scope", "$http", function($scope, $http){
        
        $scope.findAll=function(){
        $http({
        method:"GET",
        url:contextPath+"/api/EntidadBancaria"
        }).success(function(data) {
            $scope.entidadesBancarias=data;
        }).error(function() {
             alert("No se a podido listar.");
        });//success.Error
        };//Consultar 
        $scope.findAll();
    }]);


