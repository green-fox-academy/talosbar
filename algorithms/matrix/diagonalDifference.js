let squareMatrix = [
    [1, 2, 3],
    [4, 5, 6],
    [9, 8, 9]
]

let squareMatrix2 = [
    [11, 2, 4],
    [4, 5, 6],
    [10, 8, -12]
]

function diagonalDifference(matrix) {
    let sumOfLeftToRightDiagonal = 0;
    let sumOfRightToLeftDiagonal = 0;
    let length = matrix.length;
    for (let i = 0; i < length; i++) {
        sumOfLeftToRightDiagonal += matrix[i][i]; //0 0, 1 1, 2 2
        sumOfRightToLeftDiagonal += matrix[length - 1 - i][i]; //0 2, 1 1, 2 0
    }
    return Math.abs(sumOfRightToLeftDiagonal - sumOfLeftToRightDiagonal);
}

console.log(diagonalDifference(squareMatrix2));
