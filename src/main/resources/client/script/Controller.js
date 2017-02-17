'use strict';

/**
 * @ngdoc function
 * @name app.controller:FormationsCtrl
 * @description
 * # FormationCtrl
 * Controller of app
 */


angular.module('app')
  .controller('FormationsCtrl', ['$scope','formationsService',function ($scope,formationsService) {
  	 $scope.Formations = [];
       formationsService.fetchPopular(function(data){
           $scope.Formations = data;
           console.log(data);
  });
  }])
  
   .controller('FormationCtrl', ['$scope','formationService','$routeParams',function ($scope,formationService,$routeParam) {
	  	 $scope.Formation = null;
	  	console.log("1");
	  	 var code = $routeParam.codeFormation;
	  	console.log(code);
	        formationService.fetchPopular(code,function(data){
	            $scope.Formation = data;
	   });
	   }])
	   
	   .controller('AjoutFormationCtrl', ['$scope','AjoutformationService', function ($scope,AjoutformationService) {
		   console.log("up1");
	  	 var Form = {
	  			 codeFormation : "",
	  			 nomFormation : "",
	  			 debutAccreditation : "",
	  			 diplome : "",
	  			 doubleDiplome : "",
	  			 finAccreditation : "",
	  			 n0Annee : ""	  			 
	  	 };

	  	$scope.AjoutFormation = function(){
	  		if($scope.form==undefined)
	  			alert("Remplissez les champs avant de valider l'ajout");
	  		else {
	  		Form = $scope.form;
	  		console.log(Form);
	  		$scope.form["Content-Type"] = "application/json";
	  		AjoutformationService.save($scope.form);
	  		window.location.href = "http://localhost:8090/index.html?#/AjoutF";
	  		}
	  	}	  	
	   }])
	   
	   .controller('DeleteFormationCtrl', ['$scope','DeleteformationService', '$routeParams',function ($scope,DeleteformationService,$routeParam) {
		   $scope.Formation = null;
		  	console.log("1");
		  	 var code = $routeParam.codeFormation;
		  	console.log(code);
		  	DeleteformationService.Delete(code,function(data){
		            $scope.Formation = data;
		            window.location.href = "#/formations";
		  	});
	   }]);


angular.module('app')
.controller('EnseignantsCtrl', ['$scope','enseignantsService',function ($scope,enseignantsService) {
	 $scope.Enseignants = [];
	 enseignantsService.fetchPopular(function(data){
         $scope.Enseignants = data;
         console.log(data);
});
}])

 .controller('EnseignantCtrl', ['$scope','enseignantService','$routeParams',function ($scope,enseignantService,$routeParam) {
	  	 $scope.Ens = null;
	  	console.log("1");
	  	 var nom = $routeParam.nom;
	  	 var prenom = $routeParam.prenom;
	  	console.log(nom);
	  	enseignantService.fetchPopular(nom,prenom,function(data){
	            $scope.Ens = data;
	   });
	   }])
	   
 .controller('AjoutEnseignantCtrl', ['$scope','AjoutEnseignantService', function ($scope,AjoutEnseignantService) {
	  	 var Ens = {
	  			noEnseignant : "",
	  			adresse : "",
	  			codePostal : "",
	  			emailPerso : "",
	  			emailUbo : "",
	  			mobile : "",
	  			nom : "",
	  			pays : "",
	  			prenom : "",
	  			sexe : "",
	  			telephone : "",
	  			type : "",
	  			ville : ""
	  			
	  	 };
	  	console.log("hi");
	  	console.log(Ens);

	  	$scope.AjoutEnseignant = function(){
	  		/*if($scope.ens==undefined)
	  			alert("Remplissez les champs avant de valider l'ajout");
	  		else {*/
	  		console.log("hi again");
	  	    Ens = $scope.ens;
	  		console.log(Ens);
	  		$scope.ens["Content-Type"] = "application/json";
	  		AjoutEnseignantService.save($scope.ens);
	  		window.location.href = "#/AjoutE";
	  		//}
	  	}	  	
	   }])
	   
	   .controller('DeleteEnseignantCtrl', ['$scope','DeleteEnseignantService', '$routeParams',function ($scope,DeleteEnseignantService,$routeParam) {
		   $scope.Formation = null;
		  	console.log("1");
		  	 var nom = $routeParam.nom;
		  	 var prenom = $routeParam.prenom;
		  	DeleteEnseignantService.Delete(nom,prenom,function(data){
		            $scope.Formation = data;
		            window.location.href = "#/enseignants";
		  	});
	   }]);
	   