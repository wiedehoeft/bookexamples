// Attribute Checking: Every objects has a String-Array with implemented interfaces
var box = function (length, width, height) {
    this.length = length;
    this.width = width;
    this.height = height;
    this.implementedInterfaces = ['Box'];

    this.getLength = function () {
        return length;
    };

    this.getWidth = function () {
        return width;
    };

    this.getHeight = function () {
        return height;
    };
    return {
        implementedInterfaces: this.implementedInterfaces,
        getLength:
            this.getLength(),
        getWidth:
            this.getWidth(),
        getHeight:
            this.getHeight()
    }
};

/**
 * Dummy impl, see Pro JavaSCript Design Patterns (Apress 2007) for further information
 * @returns {boolean}
 */
function implements(object, name) {
    return true;
}

function calculateVolume() {
    var volume = 0;
    if (implements(box, 'Box')) {
        volume = box.getLength * box.getWidth * box.getHeight;
    }
    return volume;
}

// Duck Typing
var Box = new Interface('Box', ['getLength', 'getWidth', 'getHeight']);

function calculateVolume(box) {
    var volume = 0;
    if (Interface.ensureImplements(box, Box)) {
        volume = box.getLength * box.getWidth * box.getHeight;
    }
    return volume;
}