//should return [ [ 2, 3, 4 ], [ 9, 5, 2 ], [ 7, 6, 1 ] ]

let myMatrix = [
    [4, 3, 2],
    [2, 5, 9],
    [1, 6, 7]
]

function transponseMatrix(matrix) {
    let i;
    for (i = 0; i < matrix.length; i++) {
        matrix[i].reverse();
    }
    return matrix;
}

console.log(transponseMatrix(myMatrix));


//should return [ [ 1, 6, 7], [2, 5, 9], [4, 3, 2 ] ]