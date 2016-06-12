angular.module('starter.services', [])

.factory('Searches', function() {
  // Might use a resource here that returns a JSON array

  // Some fake testing data
  var searches = [
    { id: 0, name: 'Brother', "meaning": 'Saudara laki-laki', "syntax": '(n) kata benda' },
    { id: 1, name: 'Father', "meaning": 'Ayah', "syntax": '(n) kata benda' },
    { id: 2, name: 'Mother', "meaning": 'Ibu', "syntax": '(n) kata benda' },
    { id: 3, name: 'Sister', "meaning": 'Saudara perempuan', "syntax": '(n) kata benda' },
    { id: 4, name: 'Watch', "meaning": 'Menonton', "syntax": '(n) kata benda' },
    { id: 0, name: 'Brother', "meaning": 'Saudara laki-laki', "syntax": '(n) kata benda' },
    { id: 1, name: 'Father', "meaning": 'Ayah', "syntax": '(n) kata benda' },
    { id: 2, name: 'Mother', "meaning": 'Ibu', "syntax": '(n) kata benda' },
    { id: 3, name: 'Sister', "meaning": 'Saudara perempuan', "syntax": '(n) kata benda' },
    { id: 4, name: 'Watch', "meaning": 'Menonton', "syntax": '(n) kata benda' },
    { id: 0, name: 'Brother', "meaning": 'Saudara laki-laki', "syntax": '(n) kata benda' },
    { id: 1, name: 'Father', "meaning": 'Ayah', "syntax": '(n) kata benda' },
    { id: 2, name: 'Mother', "meaning": 'Ibu', "syntax": '(n) kata benda' },
    { id: 3, name: 'Sister', "meaning": 'Saudara perempuan', "syntax": '(n) kata benda' },
    { id: 4, name: 'Watch', "meaning": 'Menonton', "syntax": '(n) kata benda' },
    { id: 0, name: 'Brother', "meaning": 'Saudara laki-laki', "syntax": '(n) kata benda' },
    { id: 1, name: 'Father', "meaning": 'Ayah', "syntax": '(n) kata benda' },
    { id: 2, name: 'Mother', "meaning": 'Ibu', "syntax": '(n) kata benda' },
    { id: 3, name: 'Sister', "meaning": 'Saudara perempuan', "syntax": '(n) kata benda' },
    { id: 4, name: 'Watch', "meaning": 'Menonton', "syntax": '(n) kata benda' }
  ];

  return {
    all: function() {
      return searches;
    },
    get: function(searchId) {
      // Simple index lookup
      return searches[searchId];
    }
  }
});