let myMatrix = [
    [4, 3, 9],
    [4, 2, 6],
    [7, 5, 3],
]

function isDivisibleWithTwo(matrix) {
    return matrix.map((row, i) =>
        row.map((itemOfColumn, j) =>
            matrix[i][j] % 2 === 0))
}

console.log(isDivisibleWithTwo(myMatrix));