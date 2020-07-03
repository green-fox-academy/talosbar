// should return [ [ 1, 1, 1 ], [ 2, 2, 2 ], [ 3, 3, 3 ] ]

let myMatrix = [
    [1,2,3,4],
    [1,2,3,4],
    [1,2,3,4],
]
//
// function transponseMatrix(matrix) {
//     return matrix[0].map((column, index) => matrix.map(row => row[index]));
// }
//
// console.log(transponseMatrix(myMatrix));

function createMatrixRows(n) {
    return Array(n).fill(null).map(() => []);
}

function rotateMatrixWithLoops(matrix) {
    let newMatrix = createMatrixRows(matrix[0].length);
    for (i = 0; i < matrix[0].length; i++) {
        for (j = 0; j <  matrix.length; j++) {
            newMatrix[i][j] = matrix[(matrix.length-1)-j][i];
        }
    }
    return newMatrix;

    // return matrix.map((row, i) => row.map((itemOfColumn, j) => matrix[2-j][i]));
}

console.log(rotateMatrixWithLoops(myMatrix));
