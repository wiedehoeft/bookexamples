function extend(target, source) {
    target = target || {};
    for (var property in source) {
        if (source.hasOwnProperty(property)) {
            target[property] = source[property];
        }
    }
    return target;
}

var person = {
    name: 'Max',
    getName: function () {
        return this.name;
    }
};

var dog = {
    name: 'Bello',
    bark: function () {
        console.log('Wau wau');
    }
};
extend(dog, person);

// Overwriting no has no effect on dog object
person.getName = function () {
    console.log('getName() overwritten');
    return this.name;
};
console.log(person.getName());
console.log(dog.getName());