//Create a function named rotateMatrix that takes an n×n integer
// matrix (array of arrays) as parameter and returns a matrix
// which elements are rotated 90 degrees clockwise.

let myMatrix = [
    [1, 2, 3],
    [4, 5, 6],
    [7, 8, 9],
]

function rotateMatrix(twoDimensionalArray) {
    return twoDimensionalArray.map((row, i) =>
        row.map((itemOfColumn, j) =>
            twoDimensionalArray[2 - j][i]))
}

console.log(rotateMatrix(myMatrix));
