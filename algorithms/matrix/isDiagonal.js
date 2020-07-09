let myMatrix = [
    [1, 0, 0],
    [0, 2, 0],
    [0, 0, 3],
]

let myMatrix2 = [
    [1, 0, 0],
    [0, 2, 3],
    [0, 0, 3],
]

function isDiagonal(twoDimensionalArray) {
    for (i = 0; i < twoDimensionalArray.length; i++) {
        for (j = 0; j < twoDimensionalArray[i].length; j++) {
            if (i !== j && twoDimensionalArray[i][j] !== 0) {
                return false;
            }
        }
    }
    return true;
}

console.log(isDiagonal(myMatrix));
console.log(isDiagonal(myMatrix2));