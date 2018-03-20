/* IIFE-Pattern (Immediately invoked function expression) => emulating scopes */
(function () {
    console.log("Function is declared and immediately called");
})();

// is equivalent to
var functionWithName = function () {
    console.log("Function is declared and immediately called");
};
functionWithName();

(function () {
    var x = 11;
    if (x < 20) {
        (function () {
            var x = 4;
            console.log(x);
        })();
    }
    if (x > 2) {
        (function () {
            var x = 7;
            console.log(x);
        })();
    }
    console.log(x);
})();

/* Callback-Pattern => function accepts function as parameter */
function aFunction(callback) {
    if (typeof callback === "function") {
        callback();

    } else {
        console.log("Not a function: " + callback);
    }
}

function anotherFunction() {
    console.log("It's me :-)");
}

aFunction(anotherFunction);

// When functions are only needed once use an anonymous one
//afunction(function () {
//    console.log("Anonymous function");
//});

// With Params
function sumAsCallback(x, y, callback) {
    var result = x + y;
    if (typeof callback === "function") {
        callback(result);
    }
}

sumAsCallback(2, 2, function (result) {
    console.log("Result is: " + result);
});

// Callbacks for async programming
function asyncFunction() {
    var x;
    setTimeout(function () {
        throw new Error("Too late to be catched"); //Uncomment to show result, too late too ;)
        x = 4711;
        console.log(x);
    }, Math.random() * 3000);
    return x;
    try {
        var result = asyncFunction();
    } catch (error) {
        console.error("Error: " + error)
    }
}

console.log("Too early :-( " + asyncFunction());

//Best practice: Two Callback functions every with one parameter
function aSyncFunctionBP(success, error) {
    setTimeout(function () {
        var result = -1; // Change me!!!
        if (result < 0) {
            error(new Error("Result less than 0!"));
        } else {
            success(result);
        }
    }, 2000);
}

aSyncFunctionBP(function (result) {
    console.log("Result from async call: " + result);
}, function (result) {
    console.log(result);
});

// Best Practice: One Callback function with tow parameters
function aSyncFunctionBP2(callback) {
    setTimeout(function () {
        var result = 4711;
        if (result < 0) {
            callback(new Error("Result less than 0"), result);
        } else {
            callback(null, result);
        }
    }, 2000);
}

aSyncFunctionBP2(function (error, result) {
    if (error) {
        console.log(error);
    } else {
        console.log(result);
    }
});

/* Self Defining Functions */
function firstOneThenTwo() {
    console.log(1);
    firstOneThenTwo = function () {
        console.log(2);
    }
}

var functionReference = firstOneThenTwo;
firstOneThenTwo();
firstOneThenTwo();

functionReference();
functionReference();

var functionRefereceAfter = firstOneThenTwo;
functionRefereceAfter();

// Lazy instantiation
/* public int getResult() {
     if(this.result == null) {
       this.result = this.calculate();
     }
     return result;
  }
 */

function init() {
    console.log("Init");
    return "Result";
}

function getResult() {
    var result = init();
    getResult = function () {
        return result;
    };
    return result;
}

console.log("-------------");
console.log(getResult());
console.log(getResult());
console.log(getResult());
console.log(getResult());

