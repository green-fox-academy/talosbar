let originalOrder = ['first', 'second', 'third'];

function swapElements(words) {
    let temp = words[2];
    return words.map(function (item) {
        return item === words[2] ? words[0] : item && item === words[0] ? temp : item;
    })
}

console.log(swapElements(originalOrder));