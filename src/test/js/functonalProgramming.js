/* First class functions */

function addition(x, y) {
    return x + y;
}

var operation = addition;

var ergebnis = addition(1, 4);
var ergebnis2 = operation(2, 2);

console.log(ergebnis);
console.log(ergebnis2);
console.log(addition(2, 35));

function subtraction(x, y) {
    return x - y;
}

function multiplication(x, y) {
    return x * y;
}

function division(x, y) {
    return x / y;
}

console.log("Use functions in arrays");

var operations = [
    addition,
    subtraction,
    multiplication,
    division
];

for (var i = 0; i < operations.length; i++) {
    operation = operations[i];
    console.log(operation(2, 2));
}

console.log("Use functions as function params");

function metaOperation(operation, x, y) {
    return operation(x, y)
}

//Callback design pattern
function asyncFunction(callback) {
    var result = 0;
    callback(result);
}

console.log("Use functions as return type");

function operationFabric(name) {
    switch (name) {
        case 'addition':
            return function (x, y) {
                return x + y;
            };
        case 'subtraction':
            return function (x, y) {
                return x - y;
            };
        case'multiply':
            return function (x, y) {
                return x * y;
            };
        case 'division':
            return function (x, y) {
                return x / y;
            };

        default:
            return function () {
                return NaN;
            }
    }
}

var addition = operationFabric("addition");
console.log(addition(2, 2));

var subtraction = operationFabric("subtraction");
console.log(subtraction(2, 2));

console.log(operationFabric("division")(2, 2));
console.log(operationFabric("multiply")(2, 2));
console.log(operationFabric('any')(2, 2));

console.log("Object methods");

var operations = {
    addition: function (x, y) {
        return x + y;
    },
    //in ES6
    subtraction(x, y) {
        return x - y;
    }
};

console.log(operations.addition(3, 3));
console.log(operations.subtraction(3, 2));

/* This Operator */
// this bears on object where function is executed, not where function was defined

// simple 'Java' like way => this refers object person
var person = {
    name: "Max",
    getName() {
        return this.name;
    }
};

console.log(person.getName());

// more complex way
function getNameGlobal() {
    return this.name; //this refers global object, e.g. window
}

console.log(getNameGlobal());

var person2 = {
    name: "Lisa",
    getName: getNameGlobal
};
var rockKings = {
    name: "Kyuss",
    getName: getNameGlobal
};

console.log(person2.getName());
console.log(rockKings.getName());

/* Hoisting example */
function example(x) {
    console.log(x);
    console.log(y); //udefined instead of referenceError

    if (x) {
        var y = "4711";
    }
}

example(4);

/* Function overloading */

function createPerson(lastName, name) {
    return {
        lastName: lastName,
        name: name
    }
}

function createPerson(lastName, name, age) { //overrides first method declaration!
    return {
        lastName: lastName,
        name: name,
        age: age
    }
}

console.log(createPerson("Hugo", "Egon"));

var createPerson = true;

// console.log(createPerson("Hugo", "Egon")); //TypeError: createPerson is not a function!!!

//Always need one function, which handles different behaviour.
//Solution 1: explicit declaration of all variables, from obligation to optional
function sum(x, y, log) {
    var result = x + y;
    if (log) {
        console.log(result);
    }
}

sum(2, 2);
sum(3, 3, true);

//Solution 2: dont declare optional parameter

function sum(x, y) {
    var result = x + y;
    if (arguments[2]) {
        console.log(result);
    }
}

sum(2, 2);
sum(3, 3, true);

//Solution 3: Optional params as config object => best practice

function sum(x, y, config) {
    var result = x + y;
    if (config && config.log) {
        console.log(result);
    }
}

var config = {
    log: true
}

sum(2, 2);
sum(3, 3, config);

/* Constructor function */
function Album(title) {
    this.title = title;
}

var album = new Album("Demo");


console.log(album.constructor);
console.log(album.title);

/* Default methods for every function (call, apply, bind) */

//bind() => since ES5
var button = {
    handler: null,
    // Function, which expects Callback-handler
    onClick: function (handler) {
        this.handler = handler;
    },
    click: function () {
        this.handler();
    }
};

var handler = {
    log: function (message) {
        console.log("Button clicked. " + message);
    },
    //Object method, which is registered as callback handler
    handle: function (message) {
        this.log(message);
    }
};

// Register callback handler
// button.onClick(handler.handle); => TypeError: this.log is not a function
button.onClick(handler.handle.bind(handler, "Called with bind")); // bind this so handler object (ExecutionContext)
button.click();


// Alternative
button.onClick(function () {
    handler.handle("Called as anonymous function");
});
button.click();

//call() => defines execution context like bind, but creates not a function object instead function is directly called. First param is
// execution context, second optional parameter
function printName() {
    console.log(arguments);
    // arguments.forEach(function (argument) { //TypeError, arguments is not an array
    //     console.log(argument);
    // })
}

printName('Leo', 'Pold');

// Use function borrowing
function printName2() {
    var forEachMethodFromGlobalArray = Array.prototype.forEach; // this is not a call
    forEachMethodFromGlobalArray.call(arguments, function (argument) {
        console.log(argument);
    })
}

printName2('Max', 'Moritz');


//apply() => like call(), but params from called functions are passed as array

function printName3() {
    Array.prototype.forEach.apply(arguments, [function (argument) {
        console.log(argument);
    }]);
}

printName3('Lisa', 'Luna');

// Example for variadic function call with apply
console.log(Math.max(24, 44)); // can be called with any parameter

var digits = [24, 14, 44, 88];
console.log(Math.max(digits)); // Returns NaN

console.log(Math.max(digits[0], digits[1], digits[2], digits[3])); // This works, but is ugly

console.log(Math.max.apply(null, digits)); //easier call with apply ()
