// Your goal in this kata is to implement a difference function, which subtracts one list from another and returns the result.
// It should remove all values from list a, which are present in list b.

var array1 = [1, 2];
var array2 = [1];

function subtractArrays(array1, array2) {
    return array1.filter(n => !array2.includes(n));
}

console.log(subtractArrays(array1, array2));