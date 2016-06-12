angular.module('app.directives', [])
.directive('hideTabs', function($rootScope) {
  return {
    restrict: 'A',
    link: function($scope, $el) {
      $rootScope.hideTabs = 'tabs-item-hide';
      $scope.$on('$destroy', function() {
        $rootScope.hideTabs = '';
      });
    }
  };
})

.directive('onSwipeLeft', function($parse, $ionicGesture) {
    return {
        restrict :  'A',
        link : function(scope, elem, attrs) {
            var fn = $parse(attrs.onSwipeLeft);
            $ionicGesture.on('swipeleft', function(event) {
                scope.$apply(function() {
                    fn(scope, {$event:event});
                });
            }, elem);
        }
    }
})

.directive('onSwipeRight', function($parse, $ionicGesture) {
    return {
        restrict :  'A',
        link : function(scope, elem, attrs) {
            var fn = $parse(attrs.onSwipeRight);
            $ionicGesture.on('swiperight', function(event) {
                scope.$apply(function() {
                    fn(scope, {$event:event});
                });
            }, elem);
        }
    }
});
