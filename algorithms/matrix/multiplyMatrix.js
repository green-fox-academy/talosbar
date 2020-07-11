let myMatrix = [
    [4, 3, 9],
    [4, 2, 6],
    [7, 5, 3],
];

let myNumber = 3;

function multiplyMatrix(matrix, number) {
    return matrix.map((row, i) =>
        row.map((itemOfColumn, j) =>
            matrix[i][j] * number));
}

console.log(multiplyMatrix(myMatrix, myNumber));