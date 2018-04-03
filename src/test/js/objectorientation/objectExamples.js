/**
 * There are three types of JS-objects:
 * 1) native: predefined objects like Array, String, etc.
 * 2) host objects: runtime provided like window or document
 * 3) custom: created by developer
 **/

/* Creating objects */

// 1) Object literal (key-value pairs). Always Singleton
var luigi = {
    name: 'Luigi',
    type: 'Turtle'
};

var max = {
    name: 'Max',
    lastname: 'Mustermann',
    sayHello: function () {
        console.log('Hallo');
    },
    pets: [{
        name: 'Bello',
        type: 'Dog'
    }, luigi]
};

max.sayHello();
console.log(max.name);
console.log(max.pets);

// 2) Constructor function
function Album(title) {
    this.title = title;
};

var album = new Album("HardRock");
console.log(album.title);

// Call with 'new' adds implicit return to constructor function, otherwise album would be undefined. This can
// raise critical errors because this refers global context, when function is not called with new (and would overwrite this global property!!!)
// Album with fallback to avoid global properties overriding
function Album2(title) {
    if (!(this instanceof Album2)) {
        return new Album2(title);
    }
    this.title = title;
}

var album = Album2("HardRock");
console.log(album.title);

// 3) Object.create()
var max = Object.create(Object.prototype);
max.name = 'Max';
max.lastname = 'Mustermann';
console.dir(max); //see MDN, dont use dir in production!

// With property descriptor
var max = Object.create(Object.prototype, {
    name: {
        value: 'Max',
        writable: false,
        configurable: true, //attributes changeable
        enumerable: true //shown while iteration of object properties
    },
    lastname: {
        value: 'Mustermann',
        writable: true,
        configurable: true,
        enumerable: true
    }
});
console.dir(max);

// 4) ES6-classes (later)