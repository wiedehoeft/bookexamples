/** JS Prototypes
 * Objects inherit from objects
 */

/* Prototypes for Object literals => Object is implicit prototype */
var max = {
    name: 'Max',
    lastname: 'Mustermann'
};
console.log(max.__proto__); // "__proto__": Prototype of object
console.log(Object.getPrototypeOf(max));

/* Prototypes for Object.create() => Prototype is passed as param */
var maexchen = Object.create(max);
maexchen.name = 'Maexchen';
console.log(maexchen.__proto__);
console.log(Object.getPrototypeOf(maexchen));
console.log(maexchen.name);
console.log(maexchen.lastname);

/* Prototypes for constructor functions
* __proto__ references prototype which was used to create object. Additionally it has own __proto__ property which refers to prototype of function itself
* constructor function of prototype references constructorFunction */
function Movie(title, productionYear) {
    this.title = title;
    this.productionYear = productionYear;
}

var spiderman = new Movie('Spiderman', 2002);
var starWars = new Movie('Star Wars', 1997);
console.log(spiderman.__proto__);
console.log(starWars.__proto__);
console.log(Object.getPrototypeOf(spiderman));
console.log(Object.getPrototypeOf(starWars));
console.log(spiderman.constructor); //Constructor function
console.log(starWars.constructor); //Constructor function
console.log(spiderman);

/* Inheritance */
console.log('----------Inheritance--------------');
//Prototype inheritance
var animal = {
    name: undefined,
    eat: function () {
        console.log('Eating');
    }
};

var dog = {
    name: undefined,
    bark: function () {
        console.log('Wau');
    }
};

var dog2 = Object.create(animal);
dog2.bark = dog.bark;

var bello = Object.create(dog);
bello.name = 'Bello';

var struppi = Object.create(dog2);
struppi.name = 'Struppi';

dog.bark();
struppi.bark();
bello.bark();

dog2.eat();
struppi.eat();

console.log('Names');
console.log(dog.name);
console.log(bello.name);
console.log(struppi.name);

// Call of functions from prototype
var Animal = {
    eat: function () {
        console.log('Eating');
    }
};

var Dog = Object.create(Animal);
Dog.bark = function () {
    console.log(this.name + ' Wau');
};

var bello = Object.create(Dog);
bello.name = "Bello";

var struppi = Object.create(Dog);
struppi.name = "Struppi";

struppi.bark = function () {
    // Wrong
    Dog.bark();
    Dog.bark();
    // Right
    Dog.bark.call(this);
    Dog.bark.call(this);
};
struppi.bark();