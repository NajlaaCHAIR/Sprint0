(function() {
	'use strict';
	angular.module(
			'app',
			[ 'ngRoute', 'ngAnimate', 'ui.bootstrap', 'easypiechart',
					'mgo-angular-wizard', 'textAngular', 'ui.tree',
					'ngTagsInput']).config(
			[ '$routeProvider', function($routeProvider, $urlRouterProvider) {
        $routeProvider
		.when('/home', {
        templateUrl: 'pages/index.html'
      })
      .when('/formations', {
        templateUrl: 'pages/formations.html',
        controller: 'FormationsCtrl',
        controllerAs: 'formations'
      })
       .when('/detail/:codeFormation', {
        templateUrl: 'pages/formation.html',
        controller: 'FormationCtrl',
        controllerAs: 'formation'
      })
      .when('/AjoutF', {
        templateUrl: 'pages/Ajoutform.html',
        controller: 'AjoutFormationCtrl',
        controllerAs: 'AjoutF'
      })
      .when('/Update', {
        templateUrl: 'pages/formation.html',
        controller: 'AjoutFormationCtrl',
        controllerAs: 'update'
      })      
      .when('/DeleteForm/:codeFormation', {
        templateUrl: 'pages/formations.html',
        controller: 'DeleteFormationCtrl',
        controllerAs: 'DeleteF'
      })
      .when('/enseignants', {
        templateUrl: 'pages/enseignants.html',
        controller: 'EnseignantsCtrl',
        controllerAs: 'Enseignants'
      })
      .when('/detail/:nom/:prenom', {
        templateUrl: 'pages/enseignant.html',
        controller: 'EnseignantCtrl',
        controllerAs: 'enseignant'
      })
      .when('/AjoutE', {
        templateUrl: 'pages/AjoutEns.html',
        controller: 'AjoutEnseignantCtrl',
        controllerAs: 'AjoutE'
      })
      .when('/DeleteEns/:nom/:prenom', {
        templateUrl: 'pages/enseignants.html',
        controller: 'DeleteEnseignantCtrl',
        controllerAs: 'DeleteE'
      })
			.otherwise({
				redirectTo :'/'
			});
  }]);
  
}).call(this);


