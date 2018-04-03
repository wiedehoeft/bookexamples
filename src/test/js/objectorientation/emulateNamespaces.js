// Namespace-Design Pattern
var Validator = Validator || {}; //prevent that existing object is overwritten
Validator.format = 'HTML5';
Validator.validate = function () {
    console.log('Started Validation: ' + this.format);
};
Validator.validate();

// Missing encapsulation :-(
Validator.validate = function () {
};
Validator.format = 'SGML';

// As Object-literals
var Validator = Validator || {
    format: 'HTML5',
    validate: function () {
        console.log('Started validation: ' + this.format);
    }
};
Validator.validate();

// Nested namespacing
var de = de || {};
de.wiedehoeft = de.wiedehoeft || {};
de.wiedehoeft.js = de.wiedehoeft.js || {};

// As Object-literals
var de = de || {
    wiedehoeft: {
        javascript: {}
    }
};