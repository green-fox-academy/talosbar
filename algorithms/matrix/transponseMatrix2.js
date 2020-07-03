// should return [ [ 3, 3, 3 ], [ 2, 2, 2 ], [ 1, 1, 1 ] ]

let myMatrix = [
    [1,2,3],
    [1,2,3],
    [1,2,3],
]

function rotateMatrix(matrix) {
    const flipMatrix = matrix[0].map((column, index) => matrix.map(row => row[index]));
    return flipMatrix.reverse();
}

console.log(rotateMatrix(myMatrix));