app.controller("EntidadBancariaListController", ["$scope", "$http", function($scope, $http) {

        $scope.findAll = function() {
            $http({
                method: "GET",
                url: contextPath + "/api/EntidadBancaria"
            }).success(function(data) {
                for (var i = 0; i < data.length; i++) {
                    var fecha = new Date(data[i].fechaCreacionEntidadBancaria);
                    data[i].fechaCreacionEntidadBancaria = fecha.getFullYear() + "-" + (fecha.getMonth() + 1) + "-" + fecha.getDate();
                }
                $scope.entidadesBancarias = data;
            }).error(function() {
                alert("Error: no se ha podido realizar la operación");
            });//success.Error
        };//Consultar 
        $scope.findAll();
    }]);


