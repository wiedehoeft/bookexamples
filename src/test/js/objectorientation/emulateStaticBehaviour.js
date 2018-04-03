function Person(name, lastname) {
    this.name = name;
    this.lastname = lastname;
}

Person.MAX_WEIGHT = 2000;

Person.createDummy = function () {
    return new Person('Max', 'Mustermann');
};
Person.prototype.getName = function () {
    return this.name;
};
Person.prototype.getLastname = function () {
    return this.lastname;
};

console.log(Person.MAX_WEIGHT);
console.log(Person.createDummy());
console.log(Person.getName);
console.log(new Person('Moritz', 'Mustermann').getName());
console.log(new Person().createDummy());
