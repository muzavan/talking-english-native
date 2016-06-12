angular.module('starter.controllers', [])

.controller('SignInCtrl', function($scope, $state, $rootScope) {
  
  $scope.signIn = function(user) {
    console.log('Sign-In', user.username);
    $rootScope.hideTabs = ''; //munculin tab
    $state.go('tab.dash');
    $rootScope.usernameglobal = user.username
  };
  
})

.controller('DashCtrl', function($scope, $state, $rootScope, $ionicPlatform) {
  $rootScope.hideTabs = '';
  $scope.swipechats = function(){
    $rootScope.hideTabs = 'tabs-item-hide'; //hide tab
    $state.go('tab.chats');
  };
  $ionicPlatform.registerBackButtonAction(function (event) {
    if($state.current.name=="tab.dash"){
      navigator.app.exitApp();
    }
    else if ($state.current.name=="tab.chats") {
      navigator.app.backHistory();
    }
    else if ($state.current.name=="tab.search") {
      navigator.app.backHistory();
    }
    else if ($state.current.name=="tab.mother") {
      navigator.app.backHistory();
    }
    else if ($state.current.name=="setting") {
      navigator.app.backHistory();
    }
    else {
      event.preventDefault();
    }
  }, 100);
})

.controller('BeginnerCtrl', function($scope, $state, $rootScope) {
  $rootScope.hideTabs = 'tabs-item-hide';
  $scope.gotoMain = function() {
    $rootScope.hideTabs = '';
    $state.go('tab.dash');
  }
})

.controller('IntermediateCtrl', function($scope, $state, $rootScope) {
  $rootScope.hideTabs = 'tabs-item-hide';
  $scope.gotoMain = function() {
    $rootScope.hideTabs = '';
    $state.go('tab.dash');
  }
})

.controller('AdvanceCtrl', function($scope, $state, $rootScope) {
  $rootScope.hideTabs = 'tabs-item-hide';
  $scope.gotoMain = function() {
    $rootScope.hideTabs = '';
    $state.go('tab.dash');
  }
})

.controller('FamilyOneCtrl', function($scope, $rootScope) {
  $scope.score = $rootScope.value;
})

.controller('FamilyCtrl', function($scope, $state, $location, $ionicPopup, $rootScope) {
  $scope.score = $rootScope.value;
  $scope.showAlert = function() {
    $scope.data = {}
    var ans = $scope.radioValue

    if (ans == "Mother") {
      $rootScope.value+=50;
      $ionicPopup.alert({
        title: 'Result',
        templateUrl : 'popup-template-correct.html',
        scope: $scope,
        buttons: [{
          text: 'Next',
          type: 'button-balanced',
          onTap: function(e) {
            $location.path("/tab/family-3");
          }
        }]
      }).then(function(res) {
        console.log('This is the answer');
      });
    } else {
      $ionicPopup.alert({
        title: 'Result',
        templateUrl : 'popup-template-incorrect.html',
        scope: $scope,
        buttons: [{
          text: 'Next',
          type: 'button-balanced',
          onTap: function(e) {
            $location.path("/tab/family-3");
          }
        }]
      }).then(function(res) {
        console.log('This is the answer');
      });
    }
  };
})

.controller('FamilyThreeCtrl', function($scope, $rootScope) {
  $scope.score = $rootScope.value;
})

.controller('famFatherCtrl', function($scope, $state, $location, $ionicPopup, $rootScope) {
  $scope.score = $rootScope.value;

  $scope.showFatherAlert = function() {
    $scope.data = {}

    var ans = $scope.radioValue

    if (ans == "Father") {
      $rootScope.value+=50;
      $ionicPopup.alert({
        title: 'Result',
        templateUrl : 'popup-template-correct.html',
        scope: $scope,
        buttons: [{
          text: 'Next',
          type: 'button-balanced',
          onTap: function(e) {
            $location.path("/tab/family-5");
          }
        }]
      }).then(function(res) {
        console.log('This is the answer');
      });
    } else {
      $ionicPopup.alert({
        title: 'Result',
        templateUrl : 'popup-template-incorrect.html',
        scope: $scope,
        buttons: [{
          text: 'Next',
          type: 'button-balanced',
          onTap: function(e) {
            $location.path("/tab/family-5");
          }
        }]
      }).then(function(res) {
        console.log('This is the answer');
      });
    }
  };
})

.controller('FamilyFiveCtrl', function($scope, $rootScope) {
  $scope.score = $rootScope.value;
})

.controller('FamilySixCtrl', function($scope, $rootScope) {
  $scope.score = $rootScope.value;
})

.controller('ChatsCtrl', function($scope, $state, $rootScope) {
  console.log("halo")
  $rootScope.user = {
    username : ""
  }
  $rootScope.hideTabs = '';
  $scope.score = $rootScope.value;
  console.log ($rootScope.value)
  console.log($scope.score)
  $scope.swipedash = function(){
    $state.go('tab.dash');
  };
  $scope.swipesearch = function(){
    $state.go('tab.search');
  };
})

.controller('SearchCtrl', function($scope, $state, Searches, $rootScope) {
  $rootScope.hideTabs = '';
  $scope.swipechats = function(){
    $state.go('tab.chats');
  };

  $scope.searches = Searches.all();
  
   $scope.listlength = 20;
   
   $scope.loadMore = function(){
    if (!$scope.searches){
      $scope.$broadcast('scroll.infiniteScrollComplete');
      return;
    }

    if ($scope.listlength < $scope.searches.length)
      $scope.listlength+=10;
    $scope.$broadcast('scroll.infiniteScrollComplete');
  }
})

.controller('SettingCtrl', function($scope, $state, $rootScope, $ionicHistory) {
  $scope.settings = {
    enableReminder: true
  };

  $scope.goBack = function(){
    $rootScope.hideTabs = '';
    $ionicHistory.goBack();
  }

  $scope.timePickerObject = {
    inputEpochTime: ((new Date()).getHours() * 60 * 60),  //Optional
    step: 15,  //Optional
    format: 12,  //Optional
    titleLabel: '12-hour Format',  //Optional
    setLabel: 'Set',  //Optional
    closeLabel: 'Close',  //Optional
    setButtonType: 'button-positive',  //Optional
    closeButtonType: 'button-stable',  //Optional
    callback: function (val) {    //Mandatory
      if (typeof (val) === 'undefined') {
        console.log('Time not selected');
      } else {
      var selectedTime = new Date(val * 1000);
      console.log('Selected epoch is : ', val, 'and the time is ', selectedTime.getUTCHours(), ':', selectedTime.getUTCMinutes(), 'in UTC');
      }
    }
  };
})

.controller('ModalCtrl', function($scope, $ionicModal) {
  $ionicModal.fromTemplateUrl('my-modal.html', {
    scope: $scope,
    animation: 'slide-in-up'
  }).then(function(modal) {
    $scope.modal = modal;
  });
  $scope.openModal = function() {
    $scope.modal.show();
  };
  $scope.closeModal = function() {
    $scope.modal.hide();
  };
  //Cleanup the modal when we're done with it!
  $scope.$on('$destroy', function() {
    $scope.modal.remove();
  });
  // Execute action on hide modal
  $scope.$on('modal.hidden', function() {
    // Execute action
  });
  // Execute action on remove modal
  $scope.$on('modal.removed', function() {
    // Execute action
  });
})

.controller('ModalScoreCtrl', function($scope, $ionicModal) {
  $ionicModal.fromTemplateUrl('my-modal-score.html', {
    scope: $scope,
    animation: 'slide-in-up'
  }).then(function(modal) {
    $scope.modal = modal;
  });
  $scope.openModalScore = function() {
    $scope.modal.show();
  };
  $scope.closeModalScore = function() {
    $scope.modal.hide();
  };
  //Cleanup the modal when we're done with it!
  $scope.$on('$destroy', function() {
    $scope.modal.remove();
  });
  // Execute action on hide modal
  $scope.$on('modal.hidden', function() {
    // Execute action
  });
  // Execute action on remove modal
  $scope.$on('modal.removed', function() {
    // Execute action
  });
})

.controller('ModalLevelCtrl', function($scope, $ionicModal) {
  $ionicModal.fromTemplateUrl('my-modal-level.html', {
    scope: $scope,
    animation: 'slide-in-up'
  }).then(function(modal) {
    $scope.modal = modal;
  });
  $scope.openModalLevel = function() {
    $scope.modal.show();
  };
  $scope.closeModalLevel = function() {
    $scope.modal.hide();
  };
  //Cleanup the modal when we're done with it!
  $scope.$on('$destroy', function() {
    $scope.modal.remove();
  });
  // Execute action on hide modal
  $scope.$on('modal.hidden', function() {
    // Execute action
  });
  // Execute action on remove modal
  $scope.$on('modal.removed', function() {
    // Execute action
  });
})

.controller('PopCtrl', function($scope, $ionicPopover, $ionicHistory) {

  $ionicPopover.fromTemplateUrl('templates/popover.html', {
    scope: $scope,
  }).then(function(popover) {
    $scope.popover = popover;
  });

  $scope.myGoBack = function() {
    $ionicHistory.goBack();
  };

  $scope.demo = 'ios';
  $scope.setPlatform = function(p) {
    document.body.classList.remove('platform-ios');
    document.body.classList.remove('platform-android');
    document.body.classList.add('platform-' + p);
    $scope.demo = p;
  }

})

.controller('SearchDetailCtrl', function($scope, $state, $stateParams, Searches, $rootScope, $ionicHistory) {
  $scope.search = Searches.get($stateParams.searchId);

  $scope.goBackSearch = function(){
    $rootScope.hideTabs = '';
    $state.go('tab.search')
  }
})

.controller('SwitchCtrl', function($scope, $state, $location, $ionicPopup, $rootScope) {
  $scope.score = $rootScope.value;

  $scope.showContent = function( index ) {
    $scope.content = ( "content-" + index );
  };

  $scope.showFamAlert = function() {
    $scope.data = {}

    var ans = $scope.radioValue

    if (ans == "is") {
      $rootScope.value+=50;
      $ionicPopup.alert({
        title: 'Result',
        templateUrl : 'popup-template-correct.html',
        scope: $scope,
        buttons: [{
          text: 'Next',
          type: 'button-balanced',
          onTap: function(e) {
            $location.path("/tab/family-7");
          }
        }]
      }).then(function(res) {
        console.log('This is the answer');
      });
    } else {
      $ionicPopup.alert({
        title: 'Result',
        templateUrl : 'popup-template-incorrect.html',
        scope: $scope,
        buttons: [{
          text: 'Next',
          type: 'button-balanced',
          onTap: function(e) {
            $location.path("/tab/family-7");
          }
        }]
      }).then(function(res) {
        console.log('This is the answer');
      });
    }
  };
})

.controller('FamMomCtrl', function($scope, $state, $location, $ionicPopup, $rootScope) {
  $scope.score = $rootScope.value;

  $scope.showFamMomAlert = function() {
    $scope.data = {}

    var ans = $scope.inputValue

    if (ans == "Mother") {
      $rootScope.value+=50;
      $ionicPopup.alert({
        title: 'Result',
        templateUrl : 'popup-template-correct.html',
        scope: $scope,
        buttons: [{
          text: 'Next',
          type: 'button-balanced',
          onTap: function(e) {
            $location.path("/tab/family-8");
          }
        }]
      }).then(function(res) {
        console.log('This is the answer');
      });
    } else {
      $ionicPopup.alert({
        title: 'Result',
        templateUrl : 'popup-template-incorrect.html',
        scope: $scope,
        buttons: [{
          text: 'Next',
          type: 'button-balanced',
          onTap: function(e) {
            $location.path("/tab/family-8");
          }
        }]
      }).then(function(res) {
        console.log('This is the answer');
      });
    }
  };
})

.controller('FamilyEightCtrl', function($scope, $rootScope) {
  $scope.score = $rootScope.value;
})

.controller('FamFatherCtrl', function($scope, $state, $location, $ionicPopup, $rootScope) {
  $scope.score = $rootScope.value;   

  $scope.showContent = function( index ) {
    $scope.content = ( "content-" + index );
  };

  $scope.showFamAlert = function() {
    $scope.data = {}

    var ans = $scope.radioValue

    if (ans == "He") {
      $rootScope.value+=50;
      $ionicPopup.alert({
        title: 'Result',
        templateUrl : 'popup-template-correct.html',
        scope: $scope,
        buttons: [{
          text: 'Next',
          type: 'button-balanced',
          onTap: function(e) {
            $location.path("/tab/family-10");
          }
        }]
      }).then(function(res) {
        console.log('This is the answer');
      });
    } else {
      $ionicPopup.alert({
        title: 'Result',
        templateUrl : 'popup-template-incorrect.html',
        scope: $scope,
        buttons: [{
          text: 'Next',
          type: 'button-balanced',
          onTap: function(e) {
            $location.path("/tab/family-10");
          }
        }]
      }).then(function(res) {
        console.log('This is the answer');
      });
    }
  };
})

.controller('FamFatherInpCtrl', function($scope, $state, $location, $ionicPopup, $rootScope) {
  $scope.score = $rootScope.value;

  $scope.showFamFatherInpAlert = function() {
    $scope.data = {}

    var ans = $scope.inputValue

    if (ans == "Father") {
      $rootScope.value+=50;
      $ionicPopup.alert({
        title: 'Result',
        templateUrl : 'popup-template-correct.html',
        scope: $scope,
        buttons: [{
          text: 'Next',
          type: 'button-balanced',
          onTap: function(e) {
            $location.path("/tab/family-11");
          }
        }]
      }).then(function(res) {
        console.log('This is the answer');
      });
    } else {
      $ionicPopup.alert({
        title: 'Result',
        templateUrl : 'popup-template-incorrect.html',
        scope: $scope,
        buttons: [{
          text: 'Next',
          type: 'button-balanced',
          onTap: function(e) {
            $location.path("/tab/family-11");
          }
        }]
      }).then(function(res) {
        console.log('This is the answer');
      });
    }
  };
})

.controller('FamLipCtrl', function($scope, $state, $location, $ionicPopup, $rootScope) {
  $scope.score = $rootScope.value;

  $scope.showFamLipAlert = function() {
    $scope.data = {}

    var ans = $scope.radioValue

    if (ans == "She is a mother") {
      $rootScope.value+=50;
      $ionicPopup.alert({
        title: 'Result',
        templateUrl : 'popup-template-correct.html',
        scope: $scope,
        buttons: [{
          text: 'Next',
          type: 'button-balanced',
          onTap: function(e) {
            $location.path("/tab/family-12");
          }
        }]
      }).then(function(res) {
        console.log('This is the answer');
      });
    } else {
      $ionicPopup.alert({
        title: 'Result',
        templateUrl : 'popup-template-incorrect.html',
        scope: $scope,
        buttons: [{
          text: 'Next',
          type: 'button-balanced',
          onTap: function(e) {
            $location.path("/tab/family-12");
          }
        }]
      }).then(function(res) {
        console.log('This is the answer');
      });
    }
  };
})

.controller('FamLipHeCtrl', function($scope, $state, $location, $ionicPopup, $rootScope) {
  $scope.score = $rootScope.value;

  $scope.showFamLipHeAlert = function() {
    $scope.data = {}

    var ans = $scope.radioValue

    if (ans == "He is a father") {
      $rootScope.value+=50;
      $ionicPopup.alert({
        title: 'Result',
        templateUrl : 'popup-template-correct.html',
        scope: $scope,
        buttons: [{
          text: 'Next',
          type: 'button-balanced',
          onTap: function(e) {
            $location.path("/tab/family-13");
          }
        }]
      }).then(function(res) {
        console.log('This is the answer');
      });
    } else {
      $ionicPopup.alert({
        title: 'Result',
        templateUrl : 'popup-template-incorrect.html',
        scope: $scope,
        buttons: [{
          text: 'Next',
          type: 'button-balanced',
          onTap: function(e) {
            $location.path("/tab/family-13");
          }
        }]
      }).then(function(res) {
        console.log('This is the answer');
      });
    }
  };
})

.controller('FamilyThirteenCtrl', function($scope, $rootScope) {
  $scope.score = $rootScope.value;
})

.controller('FamilyFourteenCtrl', function($scope, $rootScope) {
  $scope.score = $rootScope.value;
})

.controller('BrotherCtrl', function($scope, $state, $location, $ionicPopup, $rootScope) {
  $scope.score = $rootScope.value;

  $scope.showBrotherAlert = function() {
    $scope.data = {}

    var ans = $scope.radioValue

    if (ans == "Brother") {
      $rootScope.value+=50;
      $ionicPopup.alert({
        title: 'Result',
        templateUrl : 'popup-template-correct.html',
        scope: $scope,
        buttons: [{
          text: 'Next',
          type: 'button-balanced',
          onTap: function(e) {
            $location.path("/tab/family-16");
          }
        }]
      }).then(function(res) {
        console.log('This is the answer');
      });
    } else {
      $ionicPopup.alert({
        title: 'Result',
        templateUrl : 'popup-template-incorrect.html',
        scope: $scope,
        buttons: [{
          text: 'Next',
          type: 'button-balanced',
          onTap: function(e) {
            $location.path("/tab/family-16");
          }
        }]
      }).then(function(res) {
        console.log('This is the answer');
      });
    }
  };
})

.controller('SisterCtrl', function($scope, $state, $location, $ionicPopup, $rootScope) {
  $scope.score = $rootScope.value;

  $scope.showSisterAlert = function() {
    $scope.data = {}

    var ans = $scope.radioValue

    if (ans == "Sister") {
      $rootScope.value+=50;
      $ionicPopup.alert({
        title: 'Result',
        templateUrl : 'popup-template-correct.html',
        scope: $scope,
        buttons: [{
          text: 'Next',
          type: 'button-balanced',
          onTap: function(e) {
            $location.path("/tab/family-17");
          }
        }]
      }).then(function(res) {
        console.log('This is the answer');
      });
    } else {
      $ionicPopup.alert({
        title: 'Result',
        templateUrl : 'popup-template-incorrect.html',
        scope: $scope,
        buttons: [{
          text: 'Next',
          type: 'button-balanced',
          onTap: function(e) {
            $location.path("/tab/family-17");
          }
        }]
      }).then(function(res) {
        console.log('This is the answer');
      });
    }
  };
})

.controller('FamilySeventeenCtrl', function($scope, $rootScope) {
  $scope.score = $rootScope.value;
})

.controller('FamilyEighteenCtrl', function($scope, $rootScope) {
  $scope.score = $rootScope.value;
})

.controller('WatchCtrl', function($scope, $state, $location, $ionicPopup, $rootScope) {
  $scope.score = $rootScope.value;

  $scope.showContent = function( index ) {
    $scope.content = ( "content-" + index );
  };

  $scope.showWatchAlert = function() {
    $scope.data = {}

    var ans = $scope.radioValue

    if (ans == "is") {
      $rootScope.value+=50;
      $ionicPopup.alert({
        title: 'Result',
        templateUrl : 'popup-template-correct.html',
        scope: $scope,
        buttons: [{
          text: 'Next',
          type: 'button-balanced',
          onTap: function(e) {
            $location.path("/tab/family-20");
          }
        }]
      }).then(function(res) {
        console.log('This is the answer');
      });
    } else {
      $ionicPopup.alert({
        title: 'Result',
        templateUrl : 'popup-template-incorrect.html',
        scope: $scope,
        buttons: [{
          text: 'Next',
          type: 'button-balanced',
          onTap: function(e) {
            $location.path("/tab/family-20");
          }
        }]
      }).then(function(res) {
        console.log('This is the answer');
      });
    }
  };
})

.controller('WatchLipCtrl', function($scope, $state, $location, $ionicPopup, $rootScope) {
  $scope.score = $rootScope.value;

  $scope.showWatchLipAlert = function() {
    $scope.data = {}

    var ans = $scope.radioValue

    if (ans == "Watch") {
      $rootScope.value+=50;
      $ionicPopup.alert({
        title: 'Result',
        templateUrl : 'popup-template-correct.html',
        scope: $scope,
        buttons: [{
          text: 'Next',
          type: 'button-balanced',
          onTap: function(e) {
            $location.path("/tab/family-21");
          }
        }]
      }).then(function(res) {
        console.log('This is the answer');
      });
    } else {
      $ionicPopup.alert({
        title: 'Result',
        templateUrl : 'popup-template-incorrect.html',
        scope: $scope,
        buttons: [{
          text: 'Next',
          type: 'button-balanced',
          onTap: function(e) {
            $location.path("/tab/family-21");
          }
        }]
      }).then(function(res) {
        console.log('This is the answer');
      });
    }
  };
})

.controller('SchoolOneCtrl', function($scope, $rootScope) {
  $scope.score = $rootScope.value;
})

.controller('SchoolTwoCtrl', function($scope, $rootScope) {
  $scope.score = $rootScope.value;
})

.controller('SchoolThreeCtrl', function($scope, $state, $location, $ionicPopup, $rootScope) {
  $scope.score = $rootScope.value;
  $scope.showSchoolThreeAlert = function() {
    $scope.data = {}
    var ans = $scope.radioValue

    if (ans == "Teacher") {
      $rootScope.value+=50;
      $ionicPopup.alert({
        title: 'Result',
        templateUrl : 'popup-template-correct.html',
        scope: $scope,
        buttons: [{
          text: 'Next',
          type: 'button-energized',
          onTap: function(e) {
            $location.path("/tab/school-4");
          }
        }]
      }).then(function(res) {
        console.log('This is the answer');
        console.log(ans);
      });
    } else {
      $ionicPopup.alert({
        title: 'Result',
        templateUrl : 'popup-template-incorrect.html',
        scope: $scope,
        buttons: [{
          text: 'Next',
          type: 'button-energized',
          onTap: function(e) {
            $location.path("/tab/school-4");
          }
        }]
      }).then(function(res) {
        console.log('This is the answer');
        console.log(ans);
      });
    }
  };
})

.controller('SchoolFourCtrl', function($scope, $state, $location, $ionicPopup, $rootScope) {
  $scope.score = $rootScope.value;
  $scope.showSchoolFourAlert = function() {
    $scope.data = {}
    var ans = $scope.radioValue

    if (ans == "Student") {
      $rootScope.value+=50;
      $ionicPopup.alert({
        title: 'Result',
        templateUrl : 'popup-template-correct.html',
        scope: $scope,
        buttons: [{
          text: 'Next',
          type: 'button-energized',
          onTap: function(e) {
            $location.path("/tab/school-5");
          }
        }]
      }).then(function(res) {
        console.log('This is the answer');
      });
    } else {
      $ionicPopup.alert({
        title: 'Result',
        templateUrl : 'popup-template-incorrect.html',
        scope: $scope,
        buttons: [{
          text: 'Next',
          type: 'button-energized',
          onTap: function(e) {
            $location.path("/tab/school-5");
          }
        }]
      }).then(function(res) {
        console.log('This is the answer');
      });
    }
  };
})

.controller('SchoolFiveCtrl', function($scope, $rootScope) {
  $scope.score = $rootScope.value;
})

.controller('SchoolSixCtrl', function($scope, $rootScope) {
  $scope.score = $rootScope.value;
})

.controller('SchoolSevenCtrl', function($scope, $rootScope) {
  $scope.score = $rootScope.value;
})

.controller('SchoolEightCtrl', function($scope, $state, $location, $ionicPopup, $rootScope) {
  $scope.score = $rootScope.value;

  $scope.showContent = function( index ) {
    $scope.content = ( "content-" + index );
  };

  $scope.showSchoolEightAlert = function() {
    $scope.data = {}

    var ans = $scope.radioValue

    if (ans == "writing") {
      $rootScope.value+=50;
      $ionicPopup.alert({
        title: 'Result',
        templateUrl : 'popup-template-correct.html',
        scope: $scope,
        buttons: [{
          text: 'Next',
          type: 'button-energized',
          onTap: function(e) {
            $location.path("/tab/school-9");
          }
        }]
      }).then(function(res) {
        console.log('This is the answer');
      });
    } else {
      $ionicPopup.alert({
        title: 'Result',
        templateUrl : 'popup-template-incorrect.html',
        scope: $scope,
        buttons: [{
          text: 'Next',
          type: 'button-energized',
          onTap: function(e) {
            $location.path("/tab/school-9");
          }
        }]
      }).then(function(res) {
        console.log('This is the answer');
      });
    }
  };
})

.controller('SchoolNineCtrl', function($scope, $state, $location, $ionicPopup, $rootScope) {
  $scope.score = $rootScope.value;

  $scope.showSchoolNineAlert = function() {
    $scope.data = {}

    var ans = $scope.radioValue

    if (ans == "write") {
      $rootScope.value+=50;
      $ionicPopup.alert({
        title: 'Result',
        templateUrl : 'popup-template-correct.html',
        scope: $scope,
        buttons: [{
          text: 'Next',
          type: 'button-energized',
          onTap: function(e) {
            $location.path("/tab/school-10");
          }
        }]
      }).then(function(res) {
        console.log('This is the answer');
      });
    } else {
      $ionicPopup.alert({
        title: 'Result',
        templateUrl : 'popup-template-incorrect.html',
        scope: $scope,
        buttons: [{
          text: 'Next',
          type: 'button-energized',
          onTap: function(e) {
            $location.path("/tab/school-10");
          }
        }]
      }).then(function(res) {
        console.log('This is the answer');
      });
    }
  };
})

.controller('SchoolTenCtrl', function($scope, $state, $location, $ionicPopup, $rootScope) {
  $scope.score = $rootScope.value;

  $scope.showContent = function( index ) {
    $scope.content = ( "content-" + index );
  };

  $scope.showSchoolTenAlert = function() {
    $scope.data = {}

    var ans = $scope.radioValue

    if (ans == "whiteboard") {
      $rootScope.value+=50;
      $ionicPopup.alert({
        title: 'Result',
        templateUrl : 'popup-template-correct.html',
        scope: $scope,
        buttons: [{
          text: 'Next',
          type: 'button-energized',
          onTap: function(e) {
            $location.path("/tab/school-11");
          }
        }]
      }).then(function(res) {
        console.log('This is the answer');
      });
    } else {
      $ionicPopup.alert({
        title: 'Result',
        templateUrl : 'popup-template-incorrect.html',
        scope: $scope,
        buttons: [{
          text: 'Next',
          type: 'button-energized',
          onTap: function(e) {
            $location.path("/tab/school-11");
          }
        }]
      }).then(function(res) {
        console.log('This is the answer');
      });
    }
  };
})

.controller('SchoolElevenCtrl', function($scope, $state, $location, $ionicPopup, $rootScope) {
  $scope.score = $rootScope.value;

  $scope.showSchoolElevenAlert = function() {
    $scope.data = {}

    var ans = $scope.radioValue

    if (ans == "whiteboard") {
      $rootScope.value+=50;
      $ionicPopup.alert({
        title: 'Result',
        templateUrl : 'popup-template-correct.html',
        scope: $scope,
        buttons: [{
          text: 'Next',
          type: 'button-energized',
          onTap: function(e) {
            $location.path("/tab/school-12");
          }
        }]
      }).then(function(res) {
        console.log('This is the answer');
      });
    } else {
      $ionicPopup.alert({
        title: 'Result',
        templateUrl : 'popup-template-incorrect.html',
        scope: $scope,
        buttons: [{
          text: 'Next',
          type: 'button-energized',
          onTap: function(e) {
            $location.path("/tab/school-12");
          }
        }]
      }).then(function(res) {
        console.log('This is the answer');
      });
    }
  };
})

.controller('SchoolTwelveCtrl', function($scope, $rootScope) {
  $scope.score = $rootScope.value;
})

.controller('SchoolThirteenCtrl', function($scope, $rootScope) {
  $scope.score = $rootScope.value;
})

.controller('SchoolFourteenCtrl', function($scope, $state, $location, $ionicPopup, $rootScope) {
  $scope.score = $rootScope.value;

  $scope.showContent = function( index ) {
    $scope.content = ( "content-" + index );
  };

  $scope.showSchoolFourteenAlert = function() {
    $scope.data = {}

    var ans = $scope.radioValue

    if (ans == "are paying") {
      $rootScope.value+=50;
      $ionicPopup.alert({
        title: 'Result',
        templateUrl : 'popup-template-correct.html',
        scope: $scope,
        buttons: [{
          text: 'Next',
          type: 'button-energized',
          onTap: function(e) {
            $location.path("/tab/school-15");
          }
        }]
      }).then(function(res) {
        console.log('This is the answer');
      });
    } else {
      $ionicPopup.alert({
        title: 'Result',
        templateUrl : 'popup-template-incorrect.html',
        scope: $scope,
        buttons: [{
          text: 'Next',
          type: 'button-energized',
          onTap: function(e) {
            $location.path("/tab/school-15");
          }
        }]
      }).then(function(res) {
        console.log('This is the answer');
      });
    }
  };
})

.controller('SchoolFifteenCtrl', function($scope, $state, $location, $ionicPopup, $rootScope) {
  $scope.score = $rootScope.value;

  $scope.showContent = function( index ) {
    $scope.content = ( "content-" + index );
  };

  $scope.showSchoolFifteenAlert = function() {
    $scope.data = {}

    var ans = $scope.radioValue

    if (ans == "attention") {
      $rootScope.value+=50;
      $ionicPopup.alert({
        title: 'Result',
        templateUrl : 'popup-template-correct.html',
        scope: $scope,
        buttons: [{
          text: 'Next',
          type: 'button-energized',
          onTap: function(e) {
            $location.path("/tab/school-16");
          }
        }]
      }).then(function(res) {
        console.log('This is the answer');
      });
    } else {
      $ionicPopup.alert({
        title: 'Result',
        templateUrl : 'popup-template-incorrect.html',
        scope: $scope,
        buttons: [{
          text: 'Next',
          type: 'button-energized',
          onTap: function(e) {
            $location.path("/tab/school-16");
          }
        }]
      }).then(function(res) {
        console.log('This is the answer');
      });
    }
  };
})

.controller('SchoolSixteenCtrl', function($scope, $state, $location, $ionicPopup, $rootScope) {
  $scope.score = $rootScope.value;

  $scope.showSchoolSixTeenAlert = function() {
    $scope.data = {}

    var ans = $scope.radioValue

    if (ans == "pay attention") {
      $rootScope.value+=50;
      $ionicPopup.alert({
        title: 'Result',
        templateUrl : 'popup-template-correct.html',
        scope: $scope,
        buttons: [{
          text: 'Next',
          type: 'button-energized',
          onTap: function(e) {
            $location.path("/tab/school-17");
          }
        }]
      }).then(function(res) {
        console.log('This is the answer');
      });
    } else {
      $ionicPopup.alert({
        title: 'Result',
        templateUrl : 'popup-template-incorrect.html',
        scope: $scope,
        buttons: [{
          text: 'Next',
          type: 'button-energized',
          onTap: function(e) {
            $location.path("/tab/school-17");
          }
        }]
      }).then(function(res) {
        console.log('This is the answer');
      });
    }
  };
})

.controller('SchoolSeventeenCtrl', function($scope, $state, $location, $ionicPopup, $rootScope) {
  $scope.score = $rootScope.value;

  $scope.showSchoolSevenTeenAlert = function() {
    $scope.data = {}

    var ans = $scope.radioValue

    if (ans == "student") {
      $rootScope.value+=50;
      $ionicPopup.alert({
        title: 'Result',
        templateUrl : 'popup-template-correct.html',
        scope: $scope,
        buttons: [{
          text: 'Next',
          type: 'button-energized',
          onTap: function(e) {
            $location.path("/tab/school-18");
          }
        }]
      }).then(function(res) {
        console.log('This is the answer');
      });
    } else {
      $ionicPopup.alert({
        title: 'Result',
        templateUrl : 'popup-template-incorrect.html',
        scope: $scope,
        buttons: [{
          text: 'Next',
          type: 'button-energized',
          onTap: function(e) {
            $location.path("/tab/school-18");
          }
        }]
      }).then(function(res) {
        console.log('This is the answer');
      });
    }
  };
})

.controller('SchoolEightteenCtrl', function($scope, $state, $location, $ionicPopup, $rootScope) {
  $scope.score = $rootScope.value;

  $scope.showSchoolEightTeenAlert = function() {
    $scope.data = {}

    var ans = $scope.radioValue

    if (ans == "teacher") {
      $rootScope.value+=50;
      $ionicPopup.alert({
        title: 'Result',
        templateUrl : 'popup-template-correct.html',
        scope: $scope,
        buttons: [{
          text: 'Next',
          type: 'button-energized',
          onTap: function(e) {
            $location.path("/tab/school-19");
          }
        }]
      }).then(function(res) {
        console.log('This is the answer');
      });
    } else {
      $ionicPopup.alert({
        title: 'Result',
        templateUrl : 'popup-template-incorrect.html',
        scope: $scope,
        buttons: [{
          text: 'Next',
          type: 'button-energized',
          onTap: function(e) {
            $location.path("/tab/school-19");
          }
        }]
      }).then(function(res) {
        console.log('This is the answer');
      });
    }
  };
})

.controller('SchoolNineteenCtrl', function($scope, $rootScope) {
  $scope.score = $rootScope.value;
})

.controller('SchoolTwentyCtrl', function($scope, $state, $location, $ionicPopup, $rootScope) {
  $scope.score = $rootScope.value;
  $scope.showSchoolTwentyAlert = function() {
    $scope.data = {}
    var ans = $scope.radioValue

    if (ans == "Study") {
      $rootScope.value+=50;
      $ionicPopup.alert({
        title: 'Result',
        templateUrl : 'popup-template-correct.html',
        scope: $scope,
        buttons: [{
          text: 'Next',
          type: 'button-energized',
          onTap: function(e) {
            $location.path("/tab/school-21");
          }
        }]
      }).then(function(res) {
        console.log('This is the answer');
        console.log(ans);
      });
    } else {
      $ionicPopup.alert({
        title: 'Result',
        templateUrl : 'popup-template-incorrect.html',
        scope: $scope,
        buttons: [{
          text: 'Next',
          type: 'button-energized',
          onTap: function(e) {
            $location.path("/tab/school-21");
          }
        }]
      }).then(function(res) {
        console.log('This is the answer');
        console.log(ans);
      });
    }
  };
})

.controller('SchoolTwentyOneCtrl', function($scope, $rootScope) {
  $scope.score = $rootScope.value;
})

.controller('SchoolTwentyTwoCtrl', function($scope, $state, $location, $ionicPopup, $rootScope) {
  $scope.score = $rootScope.value;

  $scope.showContent = function( index ) {
    $scope.content = ( "content-" + index );
  };

  $scope.showSchoolTwentyTwoAlert = function() {
    $scope.data = {}

    var ans = $scope.radioValue

    if (ans == "studied") {
      $rootScope.value+=50;
      $ionicPopup.alert({
        title: 'Result',
        templateUrl : 'popup-template-correct.html',
        scope: $scope,
        buttons: [{
          text: 'Next',
          type: 'button-energized',
          onTap: function(e) {
            $location.path("/tab/school-23");
          }
        }]
      }).then(function(res) {
        console.log('This is the answer');
      });
    } else {
      $ionicPopup.alert({
        title: 'Result',
        templateUrl : 'popup-template-incorrect.html',
        scope: $scope,
        buttons: [{
          text: 'Next',
          type: 'button-energized',
          onTap: function(e) {
            $location.path("/tab/school-23");
          }
        }]
      }).then(function(res) {
        console.log('This is the answer');
      });
    }
  };
})

.controller('SchoolTwentyThreeCtrl', function($scope, $rootScope) {
  $scope.score = $rootScope.value;
})

.controller('SchoolTwentyFourCtrl', function($scope, $state, $location, $ionicPopup, $rootScope) {
  $scope.score = $rootScope.value;

  $scope.showContent = function( index ) {
    $scope.content = ( "content-" + index );
  };

  $scope.showSchoolTwentyFourAlert = function() {
    $scope.data = {}

    var ans = $scope.radioValue

    if (ans == "will study") {
      $rootScope.value+=50;
      $ionicPopup.alert({
        title: 'Result',
        templateUrl : 'popup-template-correct.html',
        scope: $scope,
        buttons: [{
          text: 'Next',
          type: 'button-energized',
          onTap: function(e) {
            $location.path("/tab/school-25");
          }
        }]
      }).then(function(res) {
        console.log('This is the answer');
      });
    } else {
      $ionicPopup.alert({
        title: 'Result',
        templateUrl : 'popup-template-incorrect.html',
        scope: $scope,
        buttons: [{
          text: 'Next',
          type: 'button-energized',
          onTap: function(e) {
            $location.path("/tab/school-25");
          }
        }]
      }).then(function(res) {
        console.log('This is the answer');
      });
    }
  };
})

.controller('SchoolTwentyFiveCtrl', function($scope, $state, $location, $ionicPopup, $rootScope) {
  $scope.score = $rootScope.value;

  $scope.showSchoolTwentyFiveAlert = function() {
    $scope.data = {}

    var ans = $scope.radioValue

    if (ans == "study") {
      $rootScope.value+=50;
      $ionicPopup.alert({
        title: 'Result',
        templateUrl : 'popup-template-correct.html',
        scope: $scope,
        buttons: [{
          text: 'Next',
          type: 'button-energized',
          onTap: function(e) {
            $location.path("/tab/school-26");
          }
        }]
      }).then(function(res) {
        console.log('This is the answer');
      });
    } else {
      $ionicPopup.alert({
        title: 'Result',
        templateUrl : 'popup-template-incorrect.html',
        scope: $scope,
        buttons: [{
          text: 'Next',
          type: 'button-energized',
          onTap: function(e) {
            $location.path("/tab/school-26");
          }
        }]
      }).then(function(res) {
        console.log('This is the answer');
      });
    }
  };
})

.controller('SchoolTwentySixCtrl', function($scope, $state, $location, $ionicPopup, $rootScope) {
  $scope.score = $rootScope.value;
})

.controller('SchoolTwentySevenCtrl', function($scope, $state, $location, $ionicPopup, $rootScope) {
  $scope.score = $rootScope.value;
})

.controller('SchoolTwentyEightCtrl', function($scope, $state, $location, $ionicPopup, $rootScope) {
  $scope.score = $rootScope.value;

  $scope.showSchoolTwentyEightAlert = function() {
    $scope.data = {}

    var ans = $scope.radioValue

    if (ans == "Teacher") {
      $rootScope.value+=70;
      $ionicPopup.alert({
        title: 'Result',
        templateUrl : 'popup-template-correct.html',
        scope: $scope,
        buttons: [{
          text: 'Next',
          type: 'button-energized',
          onTap: function(e) {
            $location.path("/tab/school-27");
          }
        }]
      }).then(function(res) {
        console.log('This is the answer');
      });
    } else {
      $ionicPopup.alert({
        title: 'Result',
        templateUrl : 'popup-template-incorrect.html',
        scope: $scope,
        buttons: [{
          text: 'Next',
          type: 'button-energized',
          onTap: function(e) {
            $location.path("/tab/school-27");
          }
        }]
      }).then(function(res) {
        console.log('This is the answer');
      });
    }
  };
})

.controller('SchoolTwentyNineCtrl', function($scope, $state, $location, $ionicPopup, $rootScope) {
  $scope.score = $rootScope.value;

  $scope.showSchoolTwentyNineAlert = function() {
    $scope.data = {}

    var ans = $scope.radioValue

    if (ans == "Student") {
      $rootScope.value+=70;
      $ionicPopup.alert({
        title: 'Result',
        templateUrl : 'popup-template-correct.html',
        scope: $scope,
        buttons: [{
          text: 'Next',
          type: 'button-energized',
          onTap: function(e) {
            $location.path("/tab/school-27");
          }
        }]
      }).then(function(res) {
        console.log('This is the answer');
      });
    } else {
      $ionicPopup.alert({
        title: 'Result',
        templateUrl : 'popup-template-incorrect.html',
        scope: $scope,
        buttons: [{
          text: 'Next',
          type: 'button-energized',
          onTap: function(e) {
            $location.path("/tab/school-27");
          }
        }]
      }).then(function(res) {
        console.log('This is the answer');
      });
    }
  };
})

.controller('SchoolThirtyCtrl', function($scope, $state, $location, $ionicPopup, $rootScope) {
  $scope.score = $rootScope.value;

  $scope.showSchoolThirtyAlert = function() {
    $scope.data = {}

    var ans = $scope.radioValue

    if (ans == "Study") {
      $rootScope.value+=70;
      $ionicPopup.alert({
        title: 'Result',
        templateUrl : 'popup-template-correct.html',
        scope: $scope,
        buttons: [{
          text: 'Next',
          type: 'button-energized',
          onTap: function(e) {
            $location.path("/tab/school-27");
          }
        }]
      }).then(function(res) {
        console.log('This is the answer');
      });
    } else {
      $ionicPopup.alert({
        title: 'Result',
        templateUrl : 'popup-template-incorrect.html',
        scope: $scope,
        buttons: [{
          text: 'Next',
          type: 'button-energized',
          onTap: function(e) {
            $location.path("/tab/school-27");
          }
        }]
      }).then(function(res) {
        console.log('This is the answer');
      });
    }
  };
})

.controller('SchoolThirtyOneCtrl', function($scope, $state, $location, $ionicPopup, $rootScope) {
  $scope.score = $rootScope.value;

  $scope.showSchoolThirtyOneAlert = function() {
    $scope.data = {}

    var ans = $scope.radioValue

    if (ans == "Whiteboard") {
      $rootScope.value+=70;
      $ionicPopup.alert({
        title: 'Result',
        templateUrl : 'popup-template-correct.html',
        scope: $scope,
        buttons: [{
          text: 'Next',
          type: 'button-energized',
          onTap: function(e) {
            $location.path("/tab/school-27");
          }
        }]
      }).then(function(res) {
        console.log('This is the answer');
      });
    } else {
      $ionicPopup.alert({
        title: 'Result',
        templateUrl : 'popup-template-incorrect.html',
        scope: $scope,
        buttons: [{
          text: 'Next',
          type: 'button-energized',
          onTap: function(e) {
            $location.path("/tab/school-27");
          }
        }]
      }).then(function(res) {
        console.log('This is the answer');
      });
    }
  };
})

.controller('SupermarketOneCtrl', function($scope, $rootScope) {
  $scope.score = $rootScope.value;
})

.controller('SupermarketTwoCtrl', function($scope, $rootScope) {
  $scope.score = $rootScope.value;
})

.controller('SupermarketThreeCtrl', function($scope, $state, $location, $ionicPopup, $rootScope) {
  $scope.score = $rootScope.value;
  $scope.showSupermarketThreeAlert = function() {
    $scope.data = {}
    var ans = $scope.radioValue

    if (ans == "Purchase") {
      $rootScope.value+=50;
      $ionicPopup.alert({
        title: 'Result',
        templateUrl : 'popup-template-correct.html',
        scope: $scope,
        buttons: [{
          text: 'Next',
          type: 'button-assertive',
          onTap: function(e) {
            $location.path("/tab/supermarket-4");
          }
        }]
      }).then(function(res) {
        console.log('This is the answer');
        console.log(ans);
      });
    } else {
      $ionicPopup.alert({
        title: 'Result',
        templateUrl : 'popup-template-incorrect.html',
        scope: $scope,
        buttons: [{
          text: 'Next',
          type: 'button-assertive',
          onTap: function(e) {
            $location.path("/tab/supermarket-4");
          }
        }]
      }).then(function(res) {
        console.log('This is the answer');
        console.log(ans);
      });
    }
  };
})

.controller('SupermarketFourCtrl', function($scope, $rootScope) {
  $scope.score = $rootScope.value;
})

.controller('SupermarketFiveCtrl', function($scope, $state, $location, $ionicPopup, $rootScope) {
  $scope.score = $rootScope.value;
  $scope.showSupermarketFiveAlert = function() {
    $scope.data = {}
    var ans = $scope.radioValue

    if (ans == "Beverage") {
      $rootScope.value+=50;
      $ionicPopup.alert({
        title: 'Result',
        templateUrl : 'popup-template-correct.html',
        scope: $scope,
        buttons: [{
          text: 'Next',
          type: 'button-assertive',
          onTap: function(e) {
            $location.path("/tab/supermarket-6");
          }
        }]
      }).then(function(res) {
        console.log('This is the answer');
        console.log(ans);
      });
    } else {
      $ionicPopup.alert({
        title: 'Result',
        templateUrl : 'popup-template-incorrect.html',
        scope: $scope,
        buttons: [{
          text: 'Next',
          type: 'button-assertive',
          onTap: function(e) {
            $location.path("/tab/supermarket-6");
          }
        }]
      }).then(function(res) {
        console.log('This is the answer');
        console.log(ans);
      });
    }
  };
})

.controller('SupermarketSixCtrl', function($scope, $state, $location, $ionicPopup, $rootScope) {
  $scope.score = $rootScope.value;
  $scope.showSupermarketSixAlert = function() {
    $scope.data = {}
    var ans = $scope.radioValue

    if (ans == "Apparel") {
      $rootScope.value+=50;
      $ionicPopup.alert({
        title: 'Result',
        templateUrl : 'popup-template-correct.html',
        scope: $scope,
        buttons: [{
          text: 'Next',
          type: 'button-assertive',
          onTap: function(e) {
            $location.path("/tab/supermarket-7");
          }
        }]
      }).then(function(res) {
        console.log('This is the answer');
        console.log(ans);
      });
    } else {
      $ionicPopup.alert({
        title: 'Result',
        templateUrl : 'popup-template-incorrect.html',
        scope: $scope,
        buttons: [{
          text: 'Next',
          type: 'button-assertive',
          onTap: function(e) {
            $location.path("/tab/supermarket-7");
          }
        }]
      }).then(function(res) {
        console.log('This is the answer');
        console.log(ans);
      });
    }
  };
})

.controller('SupermarketSevenCtrl', function($scope, $rootScope) {
  $scope.score = $rootScope.value;
})

.controller('SupermarketEightCtrl', function($scope, $state, $location, $ionicPopup, $rootScope) {
  $scope.score = $rootScope.value;

  $scope.showContent = function( index ) {
    $scope.content = ( "content-" + index );
  };

  $scope.showSupermarketEightAlert = function() {
    $scope.data = {}

    var ans = $scope.radioValue

    if (ans == "purchase") {
      $rootScope.value+=50;
      $ionicPopup.alert({
        title: 'Result',
        templateUrl : 'popup-template-correct.html',
        scope: $scope,
        buttons: [{
          text: 'Next',
          type: 'button-assertive',
          onTap: function(e) {
            $location.path("/tab/supermarket-9");
          }
        }]
      }).then(function(res) {
        console.log('This is the answer');
      });
    } else {
      $ionicPopup.alert({
        title: 'Result',
        templateUrl : 'popup-template-incorrect.html',
        scope: $scope,
        buttons: [{
          text: 'Next',
          type: 'button-assertive',
          onTap: function(e) {
            $location.path("/tab/supermarket-9");
          }
        }]
      }).then(function(res) {
        console.log('This is the answer');
      });
    }
  };
})

.controller('SupermarketNineCtrl', function($scope, $state, $location, $ionicPopup, $rootScope) {
  $scope.score = $rootScope.value;

  $scope.showSupermarketNineAlert = function() {
    $scope.data = {}

    var ans = $scope.radioValue

    if (ans == "purchase") {
      $rootScope.value+=50;
      $ionicPopup.alert({
        title: 'Result',
        templateUrl : 'popup-template-correct.html',
        scope: $scope,
        buttons: [{
          text: 'Next',
          type: 'button-assertive',
          onTap: function(e) {
            $location.path("/tab/supermarket-10");
          }
        }]
      }).then(function(res) {
        console.log('This is the answer');
      });
    } else {
      $ionicPopup.alert({
        title: 'Result',
        templateUrl : 'popup-template-incorrect.html',
        scope: $scope,
        buttons: [{
          text: 'Next',
          type: 'button-assertive',
          onTap: function(e) {
            $location.path("/tab/supermarket-10");
          }
        }]
      }).then(function(res) {
        console.log('This is the answer');
      });
    }
  };
})

.controller('SupermarketTenCtrl', function($scope, $state, $location, $ionicPopup, $rootScope) {
  $scope.score = $rootScope.value;

  $scope.showContent = function( index ) {
    $scope.content = ( "content-" + index );
  };

  $scope.showSupermarketTenAlert = function() {
    $scope.data = {}

    var ans = $scope.radioValue

    if (ans == "besides") {
      $rootScope.value+=50;
      $ionicPopup.alert({
        title: 'Result',
        templateUrl : 'popup-template-correct.html',
        scope: $scope,
        buttons: [{
          text: 'Next',
          type: 'button-assertive',
          onTap: function(e) {
            $location.path("/tab/supermarket-11");
          }
        }]
      }).then(function(res) {
        console.log('This is the answer');
      });
    } else {
      $ionicPopup.alert({
        title: 'Result',
        templateUrl : 'popup-template-incorrect.html',
        scope: $scope,
        buttons: [{
          text: 'Next',
          type: 'button-assertive',
          onTap: function(e) {
            $location.path("/tab/supermarket-11");
          }
        }]
      }).then(function(res) {
        console.log('This is the answer');
      });
    }
  };
})

.controller('SupermarketElevenCtrl', function($scope, $state, $location, $ionicPopup, $rootScope) {
  $scope.score = $rootScope.value;

  $scope.showSupermarketElevenAlert = function() {
    $scope.data = {}

    var ans = $scope.radioValue

    if (ans == "apparel") {
      $rootScope.value+=50;
      $ionicPopup.alert({
        title: 'Result',
        templateUrl : 'popup-template-correct.html',
        scope: $scope,
        buttons: [{
          text: 'Next',
          type: 'button-assertive',
          onTap: function(e) {
            $location.path("/tab/supermarket-12");
          }
        }]
      }).then(function(res) {
        console.log('This is the answer');
      });
    } else {
      $ionicPopup.alert({
        title: 'Result',
        templateUrl : 'popup-template-incorrect.html',
        scope: $scope,
        buttons: [{
          text: 'Next',
          type: 'button-assertive',
          onTap: function(e) {
            $location.path("/tab/supermarket-12");
          }
        }]
      }).then(function(res) {
        console.log('This is the answer');
      });
    }
  };
})

.controller('SupermarketTwelveCtrl', function($scope, $state, $location, $ionicPopup, $rootScope) {
  $scope.score = $rootScope.value;

  $scope.showSupermarketTwelveAlert = function() {
    $scope.data = {}

    var ans = $scope.radioValue

    if (ans == "beverage") {
      $rootScope.value+=50;
      $ionicPopup.alert({
        title: 'Result',
        templateUrl : 'popup-template-correct.html',
        scope: $scope,
        buttons: [{
          text: 'Next',
          type: 'button-assertive',
          onTap: function(e) {
            $location.path("/tab/supermarket-13");
          }
        }]
      }).then(function(res) {
        console.log('This is the answer');
      });
    } else {
      $ionicPopup.alert({
        title: 'Result',
        templateUrl : 'popup-template-incorrect.html',
        scope: $scope,
        buttons: [{
          text: 'Next',
          type: 'button-assertive',
          onTap: function(e) {
            $location.path("/tab/supermarket-13");
          }
        }]
      }).then(function(res) {
        console.log('This is the answer');
      });
    }
  };
})

.controller('SupermarketThirteenCtrl', function($scope, $rootScope) {
  $scope.score = $rootScope.value;
})

.controller('SupermarketFourteenCtrl', function($scope, $rootScope) {
  $scope.score = $rootScope.value;
})

.controller('SupermarketFifteenCtrl', function($scope, $state, $location, $ionicPopup, $rootScope) {
  $scope.score = $rootScope.value;

  $scope.showSupermarketFifteenAlert = function() {
    $scope.data = {}

    var ans = $scope.radioValue

    if (ans == "extravagant") {
      $rootScope.value+=50;
      $ionicPopup.alert({
        title: 'Result',
        templateUrl : 'popup-template-correct.html',
        scope: $scope,
        buttons: [{
          text: 'Next',
          type: 'button-assertive',
          onTap: function(e) {
            $location.path("/tab/supermarket-16");
          }
        }]
      }).then(function(res) {
        console.log('This is the answer');
      });
    } else {
      $ionicPopup.alert({
        title: 'Result',
        templateUrl : 'popup-template-incorrect.html',
        scope: $scope,
        buttons: [{
          text: 'Next',
          type: 'button-assertive',
          onTap: function(e) {
            $location.path("/tab/supermarket-16");
          }
        }]
      }).then(function(res) {
        console.log('This is the answer');
      });
    }
  };
})

.controller('SupermarketSixteenCtrl', function($scope, $state, $location, $ionicPopup, $rootScope) {
  $scope.score = $rootScope.value;

  $scope.showSupermarketSixteenAlert = function() {
    $scope.data = {}

    var ans = $scope.radioValue

    if (ans == "bargain") {
      $rootScope.value+=50;
      $ionicPopup.alert({
        title: 'Result',
        templateUrl : 'popup-template-correct.html',
        scope: $scope,
        buttons: [{
          text: 'Next',
          type: 'button-assertive',
          onTap: function(e) {
            $location.path("/tab/supermarket-17");
          }
        }]
      }).then(function(res) {
        console.log('This is the answer');
      });
    } else {
      $ionicPopup.alert({
        title: 'Result',
        templateUrl : 'popup-template-incorrect.html',
        scope: $scope,
        buttons: [{
          text: 'Next',
          type: 'button-assertive',
          onTap: function(e) {
            $location.path("/tab/supermarket-17");
          }
        }]
      }).then(function(res) {
        console.log('This is the answer');
      });
    }
  };
})

.controller('SupermarketSeventeenCtrl', function($scope, $rootScope) {
  $scope.score = $rootScope.value;
})

.controller('SupermarketEightteenCtrl', function($scope, $rootScope) {
  $scope.score = $rootScope.value;
})

.controller('SupermarketNineteenCtrl', function($scope, $state, $location, $ionicPopup, $rootScope) {
  $scope.score = $rootScope.value;

  $scope.showSupermarketNineteenAlert = function() {
    $scope.data = {}

    var ans = $scope.radioValue

    if (ans == "cheap") {
      $rootScope.value+=50;
      $ionicPopup.alert({
        title: 'Result',
        templateUrl : 'popup-template-correct.html',
        scope: $scope,
        buttons: [{
          text: 'Next',
          type: 'button-assertive',
          onTap: function(e) {
            $location.path("/tab/supermarket-20");
          }
        }]
      }).then(function(res) {
        console.log('This is the answer');
      });
    } else {
      $ionicPopup.alert({
        title: 'Result',
        templateUrl : 'popup-template-incorrect.html',
        scope: $scope,
        buttons: [{
          text: 'Next',
          type: 'button-assertive',
          onTap: function(e) {
            $location.path("/tab/supermarket-20");
          }
        }]
      }).then(function(res) {
        console.log('This is the answer');
      });
    }
  };
})

.controller('SupermarketTwentyCtrl', function($scope, $state, $location, $ionicPopup, $rootScope) {
  $scope.score = $rootScope.value;

  $scope.showSupermarketTwentyAlert = function() {
    $scope.data = {}

    var ans = $scope.radioValue

    if (ans == "necessary") {
      $rootScope.value+=50;
      $ionicPopup.alert({
        title: 'Result',
        templateUrl : 'popup-template-correct.html',
        scope: $scope,
        buttons: [{
          text: 'Next',
          type: 'button-assertive',
          onTap: function(e) {
            $location.path("/tab/supermarket-21");
          }
        }]
      }).then(function(res) {
        console.log('This is the answer');
      });
    } else {
      $ionicPopup.alert({
        title: 'Result',
        templateUrl : 'popup-template-incorrect.html',
        scope: $scope,
        buttons: [{
          text: 'Next',
          type: 'button-assertive',
          onTap: function(e) {
            $location.path("/tab/supermarket-21");
          }
        }]
      }).then(function(res) {
        console.log('This is the answer');
      });
    }
  };
})

.controller('SupermarketTwentyOneCtrl', function($scope, $state, $location, $ionicPopup, $rootScope) {
  $scope.score = $rootScope.value;

  $scope.showContent = function( index ) {
    $scope.content = ( "content-" + index );
  };

  $scope.showSupermarketTwentyOneAlert = function() {
    $scope.data = {}

    var ans = $scope.radioValue

    if (ans == "bargained") {
      $rootScope.value+=50;
      $ionicPopup.alert({
        title: 'Result',
        templateUrl : 'popup-template-correct.html',
        scope: $scope,
        buttons: [{
          text: 'Next',
          type: 'button-assertive',
          onTap: function(e) {
            $location.path("/tab/supermarket-22");
          }
        }]
      }).then(function(res) {
        console.log('This is the answer');
      });
    } else {
      $ionicPopup.alert({
        title: 'Result',
        templateUrl : 'popup-template-incorrect.html',
        scope: $scope,
        buttons: [{
          text: 'Next',
          type: 'button-assertive',
          onTap: function(e) {
            $location.path("/tab/supermarket-22");
          }
        }]
      }).then(function(res) {
        console.log('This is the answer');
      });
    }
  };
})

.controller('SupermarketTwentyTwoCtrl', function($scope, $state, $location, $ionicPopup, $rootScope) {
  $scope.score = $rootScope.value;

  $scope.showSupermarketTwentyTwoAlert = function() {
    $scope.data = {}

    var ans = $scope.radioValue

    if (ans == "extravagant") {
      $rootScope.value+=50;
      $ionicPopup.alert({
        title: 'Result',
        templateUrl : 'popup-template-correct.html',
        scope: $scope,
        buttons: [{
          text: 'Next',
          type: 'button-assertive',
          onTap: function(e) {
            $location.path("/tab/supermarket-23");
          }
        }]
      }).then(function(res) {
        console.log('This is the answer');
      });
    } else {
      $ionicPopup.alert({
        title: 'Result',
        templateUrl : 'popup-template-incorrect.html',
        scope: $scope,
        buttons: [{
          text: 'Next',
          type: 'button-assertive',
          onTap: function(e) {
            $location.path("/tab/supermarket-23");
          }
        }]
      }).then(function(res) {
        console.log('This is the answer');
      });
    }
  };
})

.controller('SupermarketTwentyThreeCtrl', function($scope, $state, $location, $ionicPopup, $rootScope) {
  $scope.score = $rootScope.value;

  $scope.showSupermarketTwentyThreeAlert = function() {
    $scope.data = {}

    var ans = $scope.radioValue

    if (ans == "necessary") {
      $rootScope.value+=50;
      $ionicPopup.alert({
        title: 'Result',
        templateUrl : 'popup-template-correct.html',
        scope: $scope,
        buttons: [{
          text: 'Next',
          type: 'button-assertive',
          onTap: function(e) {
            $location.path("/tab/supermarket-24");
          }
        }]
      }).then(function(res) {
        console.log('This is the answer');
      });
    } else {
      $ionicPopup.alert({
        title: 'Result',
        templateUrl : 'popup-template-incorrect.html',
        scope: $scope,
        buttons: [{
          text: 'Next',
          type: 'button-assertive',
          onTap: function(e) {
            $location.path("/tab/supermarket-24");
          }
        }]
      }).then(function(res) {
        console.log('This is the answer');
      });
    }
  };
})

.controller('SupermarketTwentyFourCtrl', function($scope, $state, $location, $ionicPopup, $rootScope) {
  $scope.score = $rootScope.value;
})

.controller('SupermarketTwentyFiveCtrl', function($scope, $state, $location, $ionicPopup, $rootScope) {
  $scope.score = $rootScope.value;
})

.controller('SupermarketTwentySixCtrl', function($scope, $state, $location, $ionicPopup, $rootScope) {
  $scope.score = $rootScope.value;

  $scope.showSupermarketTwentySixAlert = function() {
    $scope.data = {}

    var ans = $scope.radioValue

    if (ans == "Purchase") {
      $rootScope.value+=70;
      $ionicPopup.alert({
        title: 'Result',
        templateUrl : 'popup-template-correct.html',
        scope: $scope,
        buttons: [{
          text: 'Next',
          type: 'button-assertive',
          onTap: function(e) {
            $location.path("/tab/supermarket-25");
          }
        }]
      }).then(function(res) {
        console.log('This is the answer');
      });
    } else {
      $ionicPopup.alert({
        title: 'Result',
        templateUrl : 'popup-template-incorrect.html',
        scope: $scope,
        buttons: [{
          text: 'Next',
          type: 'button-assertive',
          onTap: function(e) {
            $location.path("/tab/supermarket-25");
          }
        }]
      }).then(function(res) {
        console.log('This is the answer');
      });
    }
  };
})

.controller('SupermarketTwentySevenCtrl', function($scope, $state, $location, $ionicPopup, $rootScope) {
  $scope.score = $rootScope.value;

  $scope.showSupermarketTwentySevenAlert = function() {
    $scope.data = {}

    var ans = $scope.radioValue

    if (ans == "Apparel") {
      $rootScope.value+=70;
      $ionicPopup.alert({
        title: 'Result',
        templateUrl : 'popup-template-correct.html',
        scope: $scope,
        buttons: [{
          text: 'Next',
          type: 'button-assertive',
          onTap: function(e) {
            $location.path("/tab/supermarket-25");
          }
        }]
      }).then(function(res) {
        console.log('This is the answer');
      });
    } else {
      $ionicPopup.alert({
        title: 'Result',
        templateUrl : 'popup-template-incorrect.html',
        scope: $scope,
        buttons: [{
          text: 'Next',
          type: 'button-assertive',
          onTap: function(e) {
            $location.path("/tab/supermarket-25");
          }
        }]
      }).then(function(res) {
        console.log('This is the answer');
      });
    }
  };
})

.controller('SupermarketTwentyEightCtrl', function($scope, $state, $location, $ionicPopup, $rootScope) {
  $scope.score = $rootScope.value;

  $scope.showSupermarketTwentyEightAlert = function() {
    $scope.data = {}

    var ans = $scope.radioValue

    if (ans == "Beverage") {
      $rootScope.value+=70;
      $ionicPopup.alert({
        title: 'Result',
        templateUrl : 'popup-template-correct.html',
        scope: $scope,
        buttons: [{
          text: 'Next',
          type: 'button-assertive',
          onTap: function(e) {
            $location.path("/tab/supermarket-25");
          }
        }]
      }).then(function(res) {
        console.log('This is the answer');
      });
    } else {
      $ionicPopup.alert({
        title: 'Result',
        templateUrl : 'popup-template-incorrect.html',
        scope: $scope,
        buttons: [{
          text: 'Next',
          type: 'button-assertive',
          onTap: function(e) {
            $location.path("/tab/supermarket-25");
          }
        }]
      }).then(function(res) {
        console.log('This is the answer');
      });
    }
  };
})

.controller('ReviewCtrl', function($scope, $state, $location, $ionicPopup, $rootScope) {
  $scope.score = $rootScope.value;
})

.controller('MotherReviewCtrl', function($scope, $state, $location, $ionicPopup, $rootScope) {
  $scope.score = $rootScope.value;

  $scope.showMotherReviewAlert = function() {
    $scope.data = {}

    var ans = $scope.radioValue

    if (ans == "Mother") {
      $rootScope.value+=70;
      $ionicPopup.alert({
        title: 'Result',
        templateUrl : 'popup-template-correct.html',
        scope: $scope,
        buttons: [{
          text: 'Next',
          type: 'button-balanced',
          onTap: function(e) {
            $location.path("/tab/family-22");
          }
        }]
      }).then(function(res) {
        console.log('This is the answer');
      });
    } else {
      $ionicPopup.alert({
        title: 'Result',
        templateUrl : 'popup-template-incorrect.html',
        scope: $scope,
        buttons: [{
          text: 'Next',
          type: 'button-balanced',
          onTap: function(e) {
            $location.path("/tab/family-22");
          }
        }]
      }).then(function(res) {
        console.log('This is the answer');
      });
    }
  };
})

.controller('FatherReviewCtrl', function($scope, $state, $location, $ionicPopup, $rootScope) {
  $scope.score = $rootScope.value;

  $scope.showFatherReviewAlert = function() {
    $scope.data = {}

    var ans = $scope.radioValue

    if (ans == "Father") {
      $rootScope.value+=70;
      $ionicPopup.alert({
        title: 'Result',
        templateUrl : 'popup-template-correct.html',
        scope: $scope,
        buttons: [{
          text: 'Next',
          type: 'button-balanced',
          onTap: function(e) {
            $location.path("/tab/family-22");
          }
        }]
      }).then(function(res) {
        console.log('This is the answer');
      });
    } else {
      $ionicPopup.alert({
        title: 'Result',
        templateUrl : 'popup-template-incorrect.html',
        scope: $scope,
        buttons: [{
          text: 'Next',
          type: 'button-balanced',
          onTap: function(e) {
            $location.path("/tab/family-22");
          }
        }]
      }).then(function(res) {
        console.log('This is the answer');
      });
    }
  };
})

.controller('BrotherReviewCtrl', function($scope, $state, $location, $ionicPopup, $rootScope) {
  $scope.score = $rootScope.value;

  $scope.showBrotherReviewAlert = function() {
    $scope.data = {}

    var ans = $scope.radioValue

    if (ans == "Brother") {
      $rootScope.value+=70;
      $ionicPopup.alert({
        title: 'Result',
        templateUrl : 'popup-template-correct.html',
        scope: $scope,
        buttons: [{
          text: 'Next',
          type: 'button-balanced',
          onTap: function(e) {
            $location.path("/tab/family-22");
          }
        }]
      }).then(function(res) {
        console.log('This is the answer');
      });
    } else {
      $ionicPopup.alert({
        title: 'Result',
        templateUrl : 'popup-template-incorrect.html',
        scope: $scope,
        buttons: [{
          text: 'Next',
          type: 'button-balanced',
          onTap: function(e) {
            $location.path("/tab/family-22");
          }
        }]
      }).then(function(res) {
        console.log('This is the answer');
      });
    }
  };
})

.controller('SisterReviewCtrl', function($scope, $state, $location, $ionicPopup, $rootScope) {
  $scope.score = $rootScope.value;

  $scope.showSisterReviewAlert = function() {
    $scope.data = {}

    var ans = $scope.radioValue

    if (ans == "Sister") {
      $rootScope.value+=70;
      $ionicPopup.alert({
        title: 'Result',
        templateUrl : 'popup-template-correct.html',
        scope: $scope,
        buttons: [{
          text: 'Next',
          type: 'button-balanced',
          onTap: function(e) {
            $location.path("/tab/family-22");
          }
        }]
      }).then(function(res) {
        console.log('This is the answer');
      });
    } else {
      $ionicPopup.alert({
        title: 'Result',
        templateUrl : 'popup-template-incorrect.html',
        scope: $scope,
        buttons: [{
          text: 'Next',
          type: 'button-balanced',
          onTap: function(e) {
            $location.path("/tab/family-22");
          }
        }]
      }).then(function(res) {
        console.log('This is the answer');
      });
    }
  };
})

.controller('FinishCtrl', function($scope, $state, $location, $ionicPopup, $rootScope) {
  $scope.score = $rootScope.value;
  $rootScope.hideTabs = 'tabs-item-hide';
  $scope.quit = function () {
    $state.go('tab.dash');
    $rootScope.hideTabs = '';
  }
})

.controller('SchoolFinishCtrl', function($scope, $state, $location, $ionicPopup, $rootScope) {
  $scope.score = $rootScope.value;
  $rootScope.hideTabs = 'tabs-item-hide';
  $scope.quit = function () {
    $state.go('tab.dash');
    $rootScope.hideTabs = '';
  }
})

.controller('SupermarketFinishCtrl', function($scope, $state, $location, $ionicPopup, $rootScope) {
  $scope.score = $rootScope.value;
  $rootScope.hideTabs = 'tabs-item-hide';
  $scope.quit = function () {
    $state.go('tab.dash');
    $rootScope.hideTabs = '';
  }
});