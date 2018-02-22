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