// Public properties
function Employer(name, lastname, id) {
    this.name = name;
    this.lastname = lastname;
    this.id = id;
}

var max = new Employer('Max', 'Mustermann', 1);
console.log(max.name);
console.log(max.lastname);
console.log(max.id);

// Private properties
function EmployerPrivate(name, lastname, id) {
    var name = name;
    var lastname = lastname;
    var id = id;
}

var max = new EmployerPrivate('Max', 'Mustermann', 1);
console.log(max.name);
console.log(max.lastname);
console.log(max.id);

// Privileged public methods; methods defined on this(); can be called from outside and have access to private fields
function EmployerPrivilegedPrivate(name, lastname, id) {
    var name = name;
    var lastname = lastname;
    var id = id;

    this.getName = function () {
        return name;
    }

    this.setName = function (newName) {
        name = newName;
    }
}

var max = new EmployerPrivilegedPrivate('Max', 'Mustermann', 1);
console.log(max.name);
console.log(max.getName());
max.setName("Mäxchen");
console.log(max.getName());

// Prefer to define methods at Prototype object because they dont exist per object (needs less memory). These methods are called
// unprivileged public methods
function EmployerUnPrivilegedPrivate(name, lastname, id) {
    this._name = name;
    this._lastname = lastname;
    this._id = id;
}

EmployerUnPrivilegedPrivate.prototype.getName = function () {
    return this._name;
};
var max = new EmployerUnPrivilegedPrivate('Max', 'Mustermann', 1);
max._name = 'Moritz';
console.log(max.getName());

//Combination of private properties, privileged public and unprivileged public methods
var EmployeeComplex = (function () {
    function Employeer(name, lastname, id) {
        var name = name;
        var lastname = lastname;
        var id = id;
        this.getName = function () {
            return name;
        }
    }

    return Employeer;
})();
var max = new EmployeeComplex('Max', 'Mustermann', 1);
max._name = 'Moritz';
console.log(max.getName());

// Private methods
function EmployeePrivateMethods() {
    function getName() {
        return undefined;
    }
}

var employeePrivateMethods = new EmployeePrivateMethods();
console.log(employeePrivateMethods.getName());