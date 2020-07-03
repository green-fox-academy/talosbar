let firstArrayOfNumbers = [1, 2, 3];
let secondArrayOfNumbers = [4, 5];

function compareLength(firstArray, secondArray) {
    return firstArray.length > secondArray.length ? 'First array is longer' : 'Second array is longer';
}

console.log(compareLength(firstArrayOfNumbers, secondArrayOfNumbers));