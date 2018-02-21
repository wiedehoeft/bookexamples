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