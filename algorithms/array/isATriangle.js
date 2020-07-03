// Implement a method that accepts 3 integer values a, b, c.
// The method should return true if a triangle can be built with the sides of given length and false in any other case.
// (In this case, all triangles must have surface greater than 0 to be accepted).

let myIntegers = [2, 0, 3];
let myIntegers2 = [3, 2, 2];
let myIntegers3 = [3, 1, 1];

function isATriangle(numbers) {
    // if (!numbers.reduce((partial, item) => (item > 0) && partial, true)) {
    //     return 'it isn\'t a triangle';
    // } else {
        numbers.sort();
        if (numbers[0] > 0 && numbers[2] < (numbers[0] + numbers[1])) {
            return 'it is an triangle';
        } else {
            return 'it isn\'t a triangle';
        }
    // }
}

console.log(isATriangle(myIntegers));
console.log(isATriangle(myIntegers2));
console.log(isATriangle(myIntegers3));