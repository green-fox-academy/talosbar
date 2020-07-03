let myNumbers = [1, 2, 3, 8, 5, 6];

function changeElementIfItIs8(numbers) {
    return numbers.map(function (item) {
        return item === 8 ? 4 : item;
    })
}

console.log(changeElementIfItIs8(myNumbers));