/* From imperative to functional programming
* Imperative: Code describes how it is done
* Functional: Code describes what is done
*
* Examples for pure functional languages: Haskell, Lisp or Miranda
* Questions: What are Homoikonizität, Lazy Evaluation, Pattern Matching
*/

/* For each example*/
var interpreten = ['Kyuss', 'Dozer', 'Spirtual Baggars', 'Monster Magnet'];
interpreten.forEach(function (interprete, index, interpreten) { //param two and three are optional
    console.log(interprete);
});

/* Map example */
var interpreten = [
    {
        name: "Nick Cave"
    },
    {
        name: "Ben Harper"
    }
];
var names = interpreten.map(function (interpret, index, interpreten) {
    return interpret.name;
});
console.log(names);

/* Filter example */
var alben = [
    {
        title: 'Push the Sky Away',
        interprete: 'Nick Cave',
        release: 2013
    },
    {
        title: 'No more shall we part',
        interprete: 'Nick Cave',
        release: 2001
    },
    {
        title: 'The Will to Live',
        interprete: 'Ben Harper',
        release: 1997
    },
    {
        title: 'Live from Mars',
        interprete: 'Ben Harper',
        release: 2013
    }
];

var before2000 = alben.filter(function (album, index, alben) {
    return album.release < 2000;
});
console.log(before2000);

/* Reduce example */
var interpreten = [
    {
        name: "Nick Cave",
        alben: [
            {
                title: 'Push the sky away',
                release: 2013
            },
            {
                title: 'No more shall we part',
                release: 2001
            }
        ]
    },
    {
        name: 'Ben Harper',
        alben: [
            {
                title: 'Live from Mars',
                release: 2013
            },
            {
                title: 'The Will to Live',
                release: 1997
            }
        ]
    }
];

var albenCount = interpreten.reduce(function (result, interprete, index, interpreten) {
    return result + interprete.alben.length;
}, 0);
console.log(albenCount);

/* Find interprets name which have one album after 2000 and print them to console */
function after2000(album) {
    return album.release > 2000;
}

function hasAlbumAfter2000(interpret) {
    return interpret.alben.filter(after2000).length > 0;
}

function asName(interpret) {
    return interpret.name;
}

interpreten.filter(hasAlbumAfter2000).map(asName).forEach(console.log);


/* Composition f(g(x)) to combine methods */
var naiveComposition = function (f, g) {
    return function (x) {
        return f(g(x))
    }
};

var compositionWithContext = function (f, g) {
    return function () {
        return f.call(this, g.apply(this, arguments))
    }
};

function addFourTo(x) {
    return x + 4;
}

function multiplyBySeven(x) {
    return x * 7;
}

var addFourMultiplyBySeven = compositionWithContext(multiplyBySeven, addFourTo);
var multiplyBySevenAddFour = compositionWithContext(addFourTo, multiplyBySeven);

console.log(addFourMultiplyBySeven(2)); // 42
console.log(multiplyBySeven(addFourTo(2))); // 42
console.log(multiplyBySevenAddFour(2)); //18
console.log(addFourTo(multiplyBySeven(2))); //18

var compositionForAnyFunctionCount = function () {
    var functions = arguments;
    return function () {
        var args = arguments;
        for (var i = functions.length; i-- > 0;) {
            args = [functions[i].apply(this, args)];
        }
        return args[0];
    };
};

var addEightMultiplySeven = compositionForAnyFunctionCount(multiplyBySeven, addFourTo, addFourTo);
console.log(addEightMultiplySeven(2)); // 70

/* Recursion */
var fibonacci = function (n) {
    return n < 2 ? n : fibonacci(n - 1) + fibonacci(n - 2);
};
console.log(fibonacci(11)); // 89

/* Closures */
function counter(name) {
    var i = 0;
    return function () {
        i++;
        console.log(name + ": " + i);
    }
}

var counter1 = counter('Counter 1');
var counter2 = counter('Counter 2');
// Function calls are independent from each other
counter1();
counter2();
counter1();
counter2();

/* Memoization Design Pattern */
var fibonnaciWithCache = function () {
    var cache = [0, 1];
    var fibonacci = function (n) {
        var result = cache[n];
        if (typeof result !== 'number') {
            console.log('Neuberechnung für: ' + n);
            result = fibonacci(n - 1) + fibonacci(n - 2);
            cache[n] = result;
        }
        return result;
    };
    return fibonacci;
};

var fibonacci = fibonnaciWithCache();
console.log(fibonacci(11));
console.log(fibonacci(11));
console.log(fibonacci(12));