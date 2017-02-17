'use strict';



angular.module('app')
.service('formationsService',['$http', function($http){
	this.fetchPopular = function(callback){
		var url = "http://localhost:8090/formations";
	$http.get(url).then(function(response){
		callback(response.data);
	});
	};
}])

.service('formationService',['$http', function($http){
	this.fetchPopular = function(code,callback){
		console.log(code);
		var url = "http://localhost:8090/formation/"+code;
		console.log("2");
	$http.get(url).then(function(response){
		callback(response.data);
		console.log("3");
		console.log(response.data);
	});
	};
}])

.service('AjoutformationService',['$http', function($http){
	this.save = function(form){
		console.log(form);
		   $http({
			url : "http://localhost:8090/newFormation",
			method : "POST",
			data : form,			
		    dataType : "application/json"
		}).success(function(data, status, config) {
            console.log("oui");
            alert("Vous venez de valider l'ajout de la formation "+form.codeFormation)
            window.location.href = "http://localhost:8090/index.html?#/AjoutF";
        }).error(function(data, status, config) {
            console.log("non");
            alert("Erreur de validation de l'ajout de la formation "+form.codeFormation);
        });
	}
}])

.service('DeleteformationService',['$http', function($http){
	this.Delete = function(code,callback){
		console.log(code);
		var url = "http://localhost:8090/supprimer/"+code;
		console.log("2");
	$http.get(url).success(function(response){
		alert("Formation Supprimée !");
		window.location.href = "http://localhost:8090/index.html?#/formations";
	}).error(function(response){
		alert("Problème de contrainte");
	});
	}
}])


	
	
	
	/*then(function(response){
		callback(response.data);
		console.log("3");
		console.log(response.data);*/


.service('enseignantsService',['$http', function($http){
	this.fetchPopular = function(callback){
		var url = "http://localhost:8090/Enseignants";
	$http.get(url).then(function(response){
		callback(response.data);
	});
	};
}])

   .service('enseignantService',['$http', function($http){
	this.fetchPopular = function(nom,prenom,callback){
		//console.log(nom","prenom);
		var url = "http://localhost:8090/enseignant/"+nom+"-"+prenom;
		console.log("2");
	$http.get(url).then(function(response){
		callback(response.data);
		console.log("3");
		console.log(response.data);
	});
	};
}])
.service('AjoutEnseignantService',['$http', function($http){
	this.save = function(ens){
		console.log(ens);
		   $http({
			url : "http://localhost:8090/newEnseignant",
			method : "POST",
			data : ens,			
		    dataType : "application/json"
		}).success(function(data, status, config) {
            console.log("oui");
            alert("Vous venez de valider l'ajout de l'enseignant "+ens.nom+" "+ens.prenom)
            window.location.href = "http://localhost:8090/index.html?#/AjoutE";
        }).error(function(data, status, config) {
            console.log("non");
            alert("Erreur de validation de l'ajout de l'enseignant "+ens.nom+" "+ens.prenom)
        });
	}
}])

.service('DeleteEnseignantService',['$http', function($http){
	this.Delete = function(nom,prenom,callback){
		var url = "http://localhost:8090/supprimerEns/"+nom+"-"+prenom;
		console.log("2");
	$http.get(url).success(function(response){
		alert("Enseignant Supprime !");
		window.location.href = "http://localhost:8090/index.html?#/enseignants";
	}).error(function(response){
		alert("Probleme de contrainte");
	});
	}
}]);


