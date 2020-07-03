let myNumbers = [1, 2, 3, 4, 5];

function incrementElement(numbers) {
    return numbers.map(function(item) {
        return item === numbers[2] ? item + 2 : item;
    })
}

console.log(incrementElement(myNumbers));