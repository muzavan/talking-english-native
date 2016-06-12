// Ionic Starter App

// angular.module is a global place for creating, registering and retrieving Angular modules
// 'starter' is the name of this angular module example (also set in a <body> attribute in index.html)
// the 2nd parameter is an array of 'requires'
// 'starter.services' is found in services.js
// 'starter.controllers' is found in controllers.js
angular.module('starter', ['ionic', 'starter.controllers', 'starter.services', 'app.directives', 'ui.router', 'ionic-timepicker'])

.run(function($ionicPlatform, $rootScope) {
  $rootScope.value = 0;
  $ionicPlatform.ready(function() {
    // Hide the accessory bar by default (remove this to show the accessory bar above the keyboard
    // for form inputs)
    if (window.cordova && window.cordova.plugins && window.cordova.plugins.Keyboard) {
      cordova.plugins.Keyboard.hideKeyboardAccessoryBar(true);
      cordova.plugins.Keyboard.disableScroll(true);

    }
    if (window.StatusBar) {
      // org.apache.cordova.statusbar required
      StatusBar.styleDefault();
    }
  });
})

.config(function($stateProvider, $urlRouterProvider, $ionicConfigProvider) {

  $ionicConfigProvider.views.maxCache(500);
  // Ionic uses AngularUI Router which uses the concept of states
  // Learn more here: https://github.com/angular-ui/ui-router
  // Set up the various states which the app can be in.
  // Each state's controller can be found in controllers.js
  $stateProvider

  // setup an abstract state for the tabs directive
  .state('signin', {
    url: '/sign-in',
    templateUrl: 'templates/sign-in.html',
    controller: 'SignInCtrl'
  })

  .state('tab', {
    url: '/tab',
    abstract: true,
    templateUrl: 'templates/tabs.html'
  })

  // Each tab has its own nav history stack:
  
  .state('tab.dash', {
    url: '/dash',
    views: {
      'tab-dash': {
        templateUrl: 'templates/tab-dash.html',
        controller: 'DashCtrl'
      }
    }
  })

    .state('tab.beginner', {
      url: '/beginner',
      views: {
        'tab-dash': {
          templateUrl: 'templates/beginner.html',
          controller: 'BeginnerCtrl'
        }
      }
    })

      .state('tab.content-intro', {
        url: '/content-intro',
        views: {
          'tab-dash': {
            templateUrl: 'templates/content-intro.html'
          }
        }
      })

      .state('tab.family-1', {
        url: '/family-1',
        views: {
          'tab-dash': {
            templateUrl: 'templates/family-1.html',
            controller: 'FamilyOneCtrl'
          }
        }
      })

      .state('tab.family-2', {
        url: '/family-2',
        views: {
          'tab-dash': {
            templateUrl: 'templates/family-2.html',
            controller: 'FamilyCtrl'
          }
        }
      })

      .state('tab.family-3', {
        url: '/family-3',
        views: {
          'tab-dash': {
            templateUrl: 'templates/family-3.html',
            controller: 'FamilyThreeCtrl'
          }
        }
      })

      .state('tab.family-4', {
        url: '/family-4',
        views: {
          'tab-dash': {
            templateUrl: 'templates/family-4.html',
            controller: 'famFatherCtrl'
          }
        }
      })

      .state('tab.family-5', {
        url: '/family-5',
        views: {
          'tab-dash': {
            templateUrl: 'templates/family-5.html',
            controller: 'FamilyFiveCtrl'
          }
        }
      })

      .state('tab.family-6', {
        url: '/family-6',
        views: {
          'tab-dash': {
            templateUrl: 'templates/family-6.html',
            controller: 'SwitchCtrl'
          }
        }
      })

      .state('tab.family-7', {
        url: '/family-7',
        views: {
          'tab-dash': {
            templateUrl: 'templates/family-7.html'
          }
        }
      })

      .state('tab.family-8', {
        url: '/family-8',
        views: {
          'tab-dash': {
            templateUrl: 'templates/family-8.html',
            controller: 'FamilyEightCtrl'
          }
        }
      })

      .state('tab.family-9', {
        url: '/family-9',
        views: {
          'tab-dash': {
            templateUrl: 'templates/family-9.html'
          }
        }
      })

      .state('tab.family-10', {
        url: '/family-10',
        views: {
          'tab-dash': {
            templateUrl: 'templates/family-10.html'
          }
        }
      })

      .state('tab.family-11', {
        url: '/family-11',
        views: {
          'tab-dash': {
            templateUrl: 'templates/family-11.html',
            controller: 'FamLipCtrl'
          }
        }
      })

      .state('tab.family-12', {
        url: '/family-12',
        views: {
          'tab-dash': {
            templateUrl: 'templates/family-12.html',
            controller: 'FamLipCtrl'
          }
        }
      })

      .state('tab.family-13', {
        url: '/family-13',
        views: {
          'tab-dash': {
            templateUrl: 'templates/family-13.html',
            controller: 'FamilyThirteenCtrl'
          }
        }
      })

      .state('tab.family-14', {
        url: '/family-14',
        views: {
          'tab-dash': {
            templateUrl: 'templates/family-14.html',
            controller: 'FamilyFourteenCtrl'
          }
        }
      })

      .state('tab.family-15', {
        url: '/family-15',
        views: {
          'tab-dash': {
            templateUrl: 'templates/family-15.html',
            controller: 'BrotherCtrl'
          }
        }
      })

      .state('tab.family-16', {
        url: '/family-16',
        views: {
          'tab-dash': {
            templateUrl: 'templates/family-16.html',
            controller: 'SisterCtrl'
          }
        }
      })

      .state('tab.family-17', {
        url: '/family-17',
        views: {
          'tab-dash': {
            templateUrl: 'templates/family-17.html',
            controller: 'FamilySeventeenCtrl'
          }
        }
      })

      .state('tab.family-18', {
        url: '/family-18',
        views: {
          'tab-dash': {
            templateUrl: 'templates/family-18.html',
            controller: 'FamilyEighteenCtrl'
          }
        }
      })

      .state('tab.family-19', {
        url: '/family-19',
        views: {
          'tab-dash': {
            templateUrl: 'templates/family-19.html'
          }
        }
      })

      .state('tab.family-20', {
        url: '/family-20',
        views: {
          'tab-dash': {
            templateUrl: 'templates/family-20.html'
          }
        }
      })

      .state('tab.family-21', {
        url: '/family-21',
        views: {
          'tab-dash': {
            templateUrl: 'templates/family-21.html'
          }
        }
      })

      .state('tab.family-22', {
        url: '/family-22',
        views: {
          'tab-dash': {
            templateUrl: 'templates/family-22.html'
          }
        }
      })

      .state('tab.family-23', {
        url: '/family-23',
        views: {
          'tab-dash': {
            templateUrl: 'templates/family-23.html'
          }
        }
      })

      .state('tab.family-24', {
        url: '/family-24',
        views: {
          'tab-dash': {
            templateUrl: 'templates/family-24.html'
          }
        }
      })

      .state('tab.family-25', {
        url: '/family-25',
        views: {
          'tab-dash': {
            templateUrl: 'templates/family-25.html'
          }
        }
      })

      .state('tab.family-26', {
        url: '/family-26',
        views: {
          'tab-dash': {
            templateUrl: 'templates/family-26.html'
          }
        }
      })

      .state('tab.family-27', {
        url: '/family-27',
        views: {
          'tab-dash': {
            templateUrl: 'templates/family-27.html',
            controller: 'FinishCtrl'
          }
        }
      })

    .state('tab.intermediate', {
      url: '/intermediate',
      views: {
        'tab-dash': {
          templateUrl: 'templates/intermediate.html',
          controller: 'IntermediateCtrl'
        }
      }
    })

      .state('tab.school-1', {
        url: '/school-1',
        views: {
          'tab-dash': {
            templateUrl: 'templates/school-1.html',
            controller: 'SchoolOneCtrl'
          }
        }
      })

      .state('tab.school-2', {
        url: '/school-2',
        views: {
          'tab-dash': {
            templateUrl: 'templates/school-2.html',
            controller: 'SchoolTwoCtrl'
          }
        }
      })

      .state('tab.school-3', {
        url: '/school-3',
        views: {
          'tab-dash': {
            templateUrl: 'templates/school-3.html',
            controller: 'SchoolThreeCtrl'
          }
        }
      })

      .state('tab.school-4', {
        url: '/school-4',
        views: {
          'tab-dash': {
            templateUrl: 'templates/school-4.html',
            controller: 'SchoolFourCtrl'
          }
        }
      })

      .state('tab.school-5', {
        url: '/school-5',
        views: {
          'tab-dash': {
            templateUrl: 'templates/school-5.html',
            controller: 'SchoolFiveCtrl'
          }
        }
      })

      .state('tab.school-6', {
        url: '/school-6',
        views: {
          'tab-dash': {
            templateUrl: 'templates/school-6.html',
            controller: 'SchoolSixCtrl'
          }
        }
      })

      .state('tab.school-7', {
        url: '/school-7',
        views: {
          'tab-dash': {
            templateUrl: 'templates/school-7.html',
            controller: 'SchoolSevenCtrl'
          }
        }
      })

      .state('tab.school-8', {
        url: '/school-8',
        views: {
          'tab-dash': {
            templateUrl: 'templates/school-8.html',
            controller: 'SchoolEightCtrl'
          }
        }
      })

      .state('tab.school-9', {
        url: '/school-9',
        views: {
          'tab-dash': {
            templateUrl: 'templates/school-9.html',
            controller: 'SchoolNineCtrl'
          }
        }
      })

      .state('tab.school-10', {
        url: '/school-10',
        views: {
          'tab-dash': {
            templateUrl: 'templates/school-10.html',
            controller: 'SchoolTenCtrl'
          }
        }
      })

      .state('tab.school-11', {
        url: '/school-11',
        views: {
          'tab-dash': {
            templateUrl: 'templates/school-11.html',
            controller: 'SchoolElevenCtrl'
          }
        }
      })

      .state('tab.school-12', {
        url: '/school-12',
        views: {
          'tab-dash': {
            templateUrl: 'templates/school-12.html',
            controller: 'SchoolTwelveCtrl'
          }
        }
      })

      .state('tab.school-13', {
        url: '/school-13',
        views: {
          'tab-dash': {
            templateUrl: 'templates/school-13.html',
            controller: 'SchoolThirteenCtrl'
          }
        }
      })

      .state('tab.school-14', {
        url: '/school-14',
        views: {
          'tab-dash': {
            templateUrl: 'templates/school-14.html',
            controller: 'SchoolFourteenCtrl'
          }
        }
      })

      .state('tab.school-15', {
        url: '/school-15',
        views: {
          'tab-dash': {
            templateUrl: 'templates/school-15.html',
            controller: 'SchoolFifteenCtrl'
          }
        }
      })

      .state('tab.school-16', {
        url: '/school-16',
        views: {
          'tab-dash': {
            templateUrl: 'templates/school-16.html',
            controller: 'SchoolSixteenCtrl'
          }
        }
      })

      .state('tab.school-17', {
        url: '/school-17',
        views: {
          'tab-dash': {
            templateUrl: 'templates/school-17.html',
            controller: 'SchoolSeventeenCtrl'
          }
        }
      })

      .state('tab.school-18', {
        url: '/school-18',
        views: {
          'tab-dash': {
            templateUrl: 'templates/school-18.html',
            controller: 'SchoolEightteenCtrl'
          }
        }
      })

      .state('tab.school-19', {
        url: '/school-19',
        views: {
          'tab-dash': {
            templateUrl: 'templates/school-19.html',
            controller: 'SchoolNineteenCtrl'
          }
        }
      })

      .state('tab.school-20', {
        url: '/school-20',
        views: {
          'tab-dash': {
            templateUrl: 'templates/school-20.html',
            controller: 'SchoolTwentyCtrl'
          }
        }
      })

      .state('tab.school-21', {
        url: '/school-21',
        views: {
          'tab-dash': {
            templateUrl: 'templates/school-21.html',
            controller: 'SchoolTwentyOneCtrl'
          }
        }
      })

      .state('tab.school-22', {
        url: '/school-22',
        views: {
          'tab-dash': {
            templateUrl: 'templates/school-22.html',
            controller: 'SchoolTwentyTwoCtrl'
          }
        }
      })

      .state('tab.school-23', {
        url: '/school-23',
        views: {
          'tab-dash': {
            templateUrl: 'templates/school-23.html',
            controller: 'SchoolTwentyThreeCtrl'
          }
        }
      })

      .state('tab.school-24', {
        url: '/school-24',
        views: {
          'tab-dash': {
            templateUrl: 'templates/school-24.html',
            controller: 'SchoolTwentyFourCtrl'
          }
        }
      })

      .state('tab.school-25', {
        url: '/school-25',
        views: {
          'tab-dash': {
            templateUrl: 'templates/school-25.html',
            controller: 'SchoolTwentyFiveCtrl'
          }
        }
      })

      .state('tab.school-26', {
        url: '/school-26',
        views: {
          'tab-dash': {
            templateUrl: 'templates/school-26.html',
            controller: 'SchoolTwentySixCtrl'
          }
        }
      })

      .state('tab.school-27', {
        url: '/school-27',
        views: {
          'tab-dash': {
            templateUrl: 'templates/school-27.html',
            controller: 'SchoolTwentySevenCtrl'
          }
        }
      })

      .state('tab.school-28', {
        url: '/school-28',
        views: {
          'tab-dash': {
            templateUrl: 'templates/school-28.html',
            controller: 'SchoolTwentyEightCtrl'
          }
        }
      })

      .state('tab.school-29', {
        url: '/school-29',
        views: {
          'tab-dash': {
            templateUrl: 'templates/school-29.html',
            controller: 'SchoolTwentyNineCtrl'
          }
        }
      })

      .state('tab.school-30', {
        url: '/school-30',
        views: {
          'tab-dash': {
            templateUrl: 'templates/school-30.html',
            controller: 'SchoolThirtyCtrl'
          }
        }
      })

      .state('tab.school-31', {
        url: '/school-31',
        views: {
          'tab-dash': {
            templateUrl: 'templates/school-31.html',
            controller: 'SchoolThirtyOneCtrl'
          }
        }
      })

      .state('tab.school-32', {
        url: '/school-32',
        views: {
          'tab-dash': {
            templateUrl: 'templates/school-32.html',
            controller: "SchoolFinishCtrl"
          }
        }
      })

    .state('tab.advance', {
      url: '/advance',
      views: {
        'tab-dash': {
          templateUrl: 'templates/advance.html',
          controller: 'AdvanceCtrl'
        }
      }
    })

      .state('tab.supermarket-1', {
        url: '/supermarket-1',
        views: {
          'tab-dash': {
            templateUrl: 'templates/supermarket-1.html',
            controller: 'SupermarketOneCtrl'
          }
        }
      })

      .state('tab.supermarket-2', {
        url: '/supermarket-2',
        views: {
          'tab-dash': {
            templateUrl: 'templates/supermarket-2.html',
            controller: 'SupermarketTwoCtrl'
          }
        }
      })

      .state('tab.supermarket-3', {
        url: '/supermarket-3',
        views: {
          'tab-dash': {
            templateUrl: 'templates/supermarket-3.html',
            controller: 'SupermarketThreeCtrl'
          }
        }
      })

      .state('tab.supermarket-4', {
        url: '/supermarket-4',
        views: {
          'tab-dash': {
            templateUrl: 'templates/supermarket-4.html',
            controller: 'SupermarketFourCtrl'
          }
        }
      })

      .state('tab.supermarket-5', {
        url: '/supermarket-5',
        views: {
          'tab-dash': {
            templateUrl: 'templates/supermarket-5.html',
            controller: 'SupermarketFiveCtrl'
          }
        }
      })

      .state('tab.supermarket-6', {
        url: '/supermarket-6',
        views: {
          'tab-dash': {
            templateUrl: 'templates/supermarket-6.html',
            controller: 'SupermarketSixCtrl'
          }
        }
      })

      .state('tab.supermarket-7', {
        url: '/supermarket-7',
        views: {
          'tab-dash': {
            templateUrl: 'templates/supermarket-7.html',
            controller: 'SupermarketSevenCtrl'
          }
        }
      })

      .state('tab.supermarket-8', {
        url: '/supermarket-8',
        views: {
          'tab-dash': {
            templateUrl: 'templates/supermarket-8.html',
            controller: 'SupermarketEightCtrl'
          }
        }
      })

      .state('tab.supermarket-9', {
        url: '/supermarket-9',
        views: {
          'tab-dash': {
            templateUrl: 'templates/supermarket-9.html',
            controller: 'SupermarketNineCtrl'
          }
        }
      })

      .state('tab.supermarket-10', {
        url: '/supermarket-10',
        views: {
          'tab-dash': {
            templateUrl: 'templates/supermarket-10.html',
            controller: 'SupermarketTenCtrl'
          }
        }
      })

      .state('tab.supermarket-11', {
        url: '/supermarket-11',
        views: {
          'tab-dash': {
            templateUrl: 'templates/supermarket-11.html',
            controller: 'SupermarketElevenCtrl'
          }
        }
      })

      .state('tab.supermarket-12', {
        url: '/supermarket-12',
        views: {
          'tab-dash': {
            templateUrl: 'templates/supermarket-12.html',
            controller: 'SupermarketTwelveCtrl'
          }
        }
      })

      .state('tab.supermarket-13', {
        url: '/supermarket-13',
        views: {
          'tab-dash': {
            templateUrl: 'templates/supermarket-13.html',
            controller: 'SupermarketThirteenCtrl'
          }
        }
      })

      .state('tab.supermarket-14', {
        url: '/supermarket-14',
        views: {
          'tab-dash': {
            templateUrl: 'templates/supermarket-14.html',
            controller: 'SupermarketFourteenCtrl'
          }
        }
      })

      .state('tab.supermarket-15', {
        url: '/supermarket-15',
        views: {
          'tab-dash': {
            templateUrl: 'templates/supermarket-15.html',
            controller: 'SupermarketFifteenCtrl'
          }
        }
      })

      .state('tab.supermarket-16', {
        url: '/supermarket-16',
        views: {
          'tab-dash': {
            templateUrl: 'templates/supermarket-16.html',
            controller: 'SupermarketSixteenCtrl'
          }
        }
      })

      .state('tab.supermarket-17', {
        url: '/supermarket-17',
        views: {
          'tab-dash': {
            templateUrl: 'templates/supermarket-17.html',
            controller: 'SupermarketSeventeenCtrl'
          }
        }
      })

      .state('tab.supermarket-18', {
        url: '/supermarket-18',
        views: {
          'tab-dash': {
            templateUrl: 'templates/supermarket-18.html',
            controller: 'SupermarketEightteenCtrl'
          }
        }
      })

      .state('tab.supermarket-19', {
        url: '/supermarket-19',
        views: {
          'tab-dash': {
            templateUrl: 'templates/supermarket-19.html',
            controller: 'SupermarketNineteenCtrl'
          }
        }
      })

      .state('tab.supermarket-20', {
        url: '/supermarket-20',
        views: {
          'tab-dash': {
            templateUrl: 'templates/supermarket-20.html',
            controller: 'SupermarketTwentyCtrl'
          }
        }
      })

      .state('tab.supermarket-21', {
        url: '/supermarket-21',
        views: {
          'tab-dash': {
            templateUrl: 'templates/supermarket-21.html',
            controller: 'SupermarketTwentyOneCtrl'
          }
        }
      })

      .state('tab.supermarket-22', {
        url: '/supermarket-22',
        views: {
          'tab-dash': {
            templateUrl: 'templates/supermarket-22.html',
            controller: 'SupermarketTwentyTwoCtrl'
          }
        }
      })

      .state('tab.supermarket-23', {
        url: '/supermarket-23',
        views: {
          'tab-dash': {
            templateUrl: 'templates/supermarket-23.html',
            controller: 'SupermarketTwentyThreeCtrl'
          }
        }
      })

      .state('tab.supermarket-24', {
        url: '/supermarket-24',
        views: {
          'tab-dash': {
            templateUrl: 'templates/supermarket-24.html',
            controller: 'SupermarketTwentyFourCtrl'
          }
        }
      })

      .state('tab.supermarket-25', {
        url: '/supermarket-25',
        views: {
          'tab-dash': {
            templateUrl: 'templates/supermarket-25.html',
            controller: 'SupermarketTwentyFiveCtrl'
          }
        }
      })

      .state('tab.supermarket-26', {
        url: '/supermarket-26',
        views: {
          'tab-dash': {
            templateUrl: 'templates/supermarket-26.html',
            controller: 'SupermarketTwentySixCtrl'
          }
        }
      })

      .state('tab.supermarket-27', {
        url: '/supermarket-27',
        views: {
          'tab-dash': {
            templateUrl: 'templates/supermarket-27.html',
            controller: 'SupermarketTwentySevenCtrl'
          }
        }
      })

      .state('tab.supermarket-28', {
        url: '/supermarket-28',
        views: {
          'tab-dash': {
            templateUrl: 'templates/supermarket-28.html',
            controller: 'SupermarketTwentyEightCtrl'
          }
        }
      })

      .state('tab.supermarket-29', {
        url: '/supermarket-29',
        views: {
          'tab-dash': {
            templateUrl: 'templates/supermarket-29.html',
            controller: 'SupermarketFinishCtrl'
          }
        }
      })

  .state('tab.chats', {
      url: '/chats',
      views: {
        'tab-chats': {
          templateUrl: 'templates/tab-chats.html',
          controller: 'ChatsCtrl'
        }
      }
    })

    .state('tab.chat-detail', {
      url: '/chats/:chatId',
      views: {
        'tab-chats': {
          templateUrl: 'templates/chat-detail.html',
          controller: 'ChatDetailCtrl'
        }
      }
    })

  .state('tab.search', {
    url: '/search',
    views: {
      'tab-search': {
        templateUrl: 'templates/tab-search.html',
        controller: 'SearchCtrl'
      }
    }
  })

    .state('tab.search-detail', {
      url: '/search/:searchId',
      views: {
        'tab-search': {
          templateUrl: 'templates/search-detail.html',
          controller: 'SearchDetailCtrl'
        }
      }
    })

    .state('tab.mother', {
      url: '/search/mother',
      views: {
        'tab-search': {
          templateUrl: 'templates/mother.html'
        }
      }
    })

  .state('setting', {
    url: '/setting',
    templateUrl: 'templates/setting.html',
    controller: 'SettingCtrl'
  });

  // if none of the above states are matched, use this as the fallback
  $urlRouterProvider.otherwise('/sign-in');

});
