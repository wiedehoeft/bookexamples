function Animal(name) {
    this.name = name;
}

console.log(Animal.prototype);

Animal.prototype.eat = function () {
    console.log('Eating');
};

function Dog(name, race) {
    Animal.call(this, name);
    this.race = race;
}

Dog.prototype = new Animal();

console.log('No constructor defined');
console.log(Dog.prototype);
console.log(Dog.prototype.__proto__);

Dog.prototype.constructor = Dog;

console.log('No it is');
console.log(Dog.prototype);
console.log(Dog.prototype.__proto__);

Dog.prototype.bark = function () {
    console.log(this.name + ' Wau');
};

var bello = new Dog('Bello', 'Malteser');
var struppi = new Dog('Struppi', 'Havaneser');

struppi.bark = function () {
    Dog.prototype.bark.call(this);
    Dog.prototype.bark.call(this);
};
bello.bark();
struppi.bark();