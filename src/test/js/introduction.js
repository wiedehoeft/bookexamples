/* Datatypes
String, Number, Boolean, null, undefined, Object
All digits are 64-Bit floating digits
But there are to methods to parse Number from String => parseInt() and parseFloat()
Infinity => digit too big
NaN => Not a number
*/

/*Strings
UCS2-Coded <=> completely congruently with UTF-16/UTF-32
 */

// Booleans => null, undefined, empty Strings, 0, NaN are falsy; others truthy

console.log(false == 0); // true
console.log(false == ""); // true
console.log(0 == ""); // true

//null and undefined are only same at each other
console.log(null == false); // false
console.log(null == true); // false
console.log(null == null); // true
console.log(undefined == undefined); // true
console.log(null == undefined); // true

//NaN is same to nothing
console.log(NaN == false); // false
console.log(NaN == null); // false
console.log(NaN == NaN); // false

// in boolean expressions truthy valus become true, falsy values false

console.log(false == null); //false
if (null) {
    console.log("null");
} else if (!null) {
    console.log("!null"); // Output
}
console.log(true == {}); // false
if ({}) {
    console.log("{}"); // Output
} else if (!{}) {
    console.log("!{}");
}

// use strict compare with === or !== because they check type and value of variable

// undefined is a global variable, non initialized variables, non existing object properties and not
// existing function parameters have value undefined

/* Objects */
var person = {
    name: 'Max',
    lastName: 'Mustermann',
    speak: function () {
        console.log('Hello');
    }
};
console.log(person.name);
console.log(person['lastName']);

person.name = 'Moritz';
person['lastName'] = 'Tester';
console.log(person.name);
console.log(person.lastName);
person.speak();
person['speak']();

delete person.name;
console.log(person.name);

/* Wrapper => avoid using because type is always object; let JS use in background for internals*/
var digit = new Number(4);
var floatingDigit = new Number(4.4);
var stringObject = new String('Hello');
var booleanObject = new Boolean(true);

4711 == "4711" // true
4711 === "4711" // false

/* Arrays */
var interprete = new Array();
interprete[0] = 'Kyuss';
interprete[1] = 'Baby Woodrose';

var interprete = [
    'Kyuss',
    'Baby Woodrose'
]
new Array(10); //create array with length 10
new Array(10, 11) //creates array with digits 10 and 11

/*RegEx
* use constrcutor or /[...]/; check string with test() or exec(), or replace(), search(), split() and match()
* */
/*Variables have dynamic types!!
* Variables without var are global
*/

/*
functions: dont create with new, because they are not usable as closures
 */

var addition = function add(digita, digitb) {
    return digita + digitb;
};

// anonymous
var addition = function (digita, digitb) {
    return digita + digitb;
};

console.log(addition(2, 2)); // 4
console.log(addition('Hello', 'World')); // Hello World !!

function addAll() {
    var result = 0;
    for (var i = 0; i < arguments.length; i++) {
        result += arguments[i];
    }
    return result;

// in ES6
}
function addAll2(...digit) {
    var result = 0;
    for (var i = 0; i < arguments.length; i++) {
        result += arguments[i];
    }
    return result;
}

// Control structures and loops
function example(param) {
    if(param) {
        console.log("Param set");
    }
}