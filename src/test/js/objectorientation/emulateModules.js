// Classic module design pattern
var ValidatorModule = ValidatorModule || (function () {
    var format = 'HTML5';
    return {
        validate: function () {
            console.log('Started validation: ' + format);
        }
    }
})();
ValidatorModule.validate();

// No effect :-)
ValidatorModule.format = 'SGML';
ValidatorModule.validate();

// Revealing-Module-Design-Pattern

// Pattern to prevent this
var ValidatorModule2 = ValidatorModule2 || (function () {
    var format = 'CSS';
    return {
        validate: function () {
            console.log('Started validation: ' + format);
            ValidatorModule2.endedValidation(); // module name has to be before method call
        },
        endedValidation: function () {
            console.log('Ended Validation: ' + format);
        }
    }
})();
ValidatorModule2.validate();

// Now the pattern
var ValidatorModule3 = ValidatorModule3 || (function () {
    var format = 'Javascript';

    function validate() {
        console.log('Started validation: ' + format);
        endedValidation();
    }

    function endedValidation() {
        console.log('Ended Validation: ' + format);
    }

    return {
        validate: validate
    }
})();
ValidatorModule3.validate();

// Importing modules
var PersistenceModule = PersistenceModule || (function () {
    function save(results) {
        console.log('Results saved: ' + results);
    }

    return {
        save: save
    }
})();
var ValidatorModule4 = ValidatorModule4 || (function (persistenceModule) {
    var format = 'Groovy';
    var results = [];

    function validate() {
        console.log('Started validation: ' + format);
        results.push('Test failed');
        persistenceModule.save(results);
    }

    function getResults() {
        return results;
    }

    return {
        validate: validate,
        getResults: getResults
    }
})(PersistenceModule);

ValidatorModule4.validate();

// Module augmentation with loose augmentation
var ValidatorModule5 = (function (modul) {
    var format = 'Java';
    modul.results = [];
    modul.validate = function () {
        console.log('Started validation: ' + format);
        modul.results.push('Test failed');
    };
    modul.getResults = function () {
        return modul.results;
    };
    return modul;
})(ValidatorModule5 || {});

ValidatorModule5.validate();