// should return [ [ 1, 1, 1 ], [ 2, 2, 2 ], [ 3, 3, 3 ] ]

let myMatrix = [
    [1,2,3],
    [1,2,3],
    [1,2,3],
]

function transponseMatrix(matrix) {
    return matrix[0].map((column, index) => matrix.map(row => row[index]));
}

console.log(transponseMatrix(myMatrix));
