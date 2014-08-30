app.directive('field', function() {
	return {
		require:'^ngController',
		restrict : 'E',
		templateUrl : 'component/field.html',
		transclude : false,
		replace : false,
		scope : {
			label : '@',
			name: '@',
			value : '=',
		},
		link: function(scope, element, attrs, ctrl){
		}
	}
})

app.directive('dynamicName', function($compile, $parse) {
  return {
    restrict: 'A',
    terminal: true,
    priority: 100000,
    link: function(scope, elem) {
      var attr=elem.attr('dynamic-name');
	var name = scope.$eval(attr);
      elem.removeAttr('dynamic-name');
      elem.attr('name', name);
      $compile(elem)(scope);
    }
  };
});


app.directive('like', function() {
	return {
		restrict : 'E',
		templateUrl : 'component/like.html',
		scope:{
			val:'='
		},
		controller:function(){
			console.log('Like rendering')
		}
	}
})