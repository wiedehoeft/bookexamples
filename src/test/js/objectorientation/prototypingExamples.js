/* Prototypes for Object literals */
var max = {
    name: 'Max',
    lastname: 'Mustermann'
};
console.log(max.__proto__);
console.log(Object.getPrototypeOf(max));

/* Prototypes for Object.create() */
var maexchen = Object.create(max);
maexchen.name = 'Maexchen';
console.log(maexchen.__proto__);
console.log(Object.getPrototypeOf(maexchen));
console.log(maexchen.name);
console.log(maexchen.lastname);

/* Prototypes for constructor functions
* __proto__ references prototype which was used to create object. Additionally it has own __proto__ property which refers to prototype function itself
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
console.log(spiderman.constructor);
console.log(starWars.constructor);
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

var dog2 = Object.create(animal);

var dog = {
    name: undefined,
    bark: function () {
        console.log('Wau');
    }
};
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