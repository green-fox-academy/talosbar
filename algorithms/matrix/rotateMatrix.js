//Create a function named rotateMatrix that takes an n×n integer
// matrix (array of arrays) as parameter and returns a matrix
// which elements are rotated 90 degrees clockwise.

let myMatrix = [
    [1, 2, 3],
    [4, 5, 6],
    [7, 8, 9],
]

//csak negyzetes matrixnal
function rotateMatrix(twoDimensionalArray) {
    return twoDimensionalArray.map((row, i) =>
        row.map((itemOfColumn, j) =>
            twoDimensionalArray[2 - j][i]))
}

//nem negyzetes matrixnal is mukodik
function createMatrixRows(n) {
    return Array(n).fill(null).map(() => []);
}

function rotateMatrix2(twoDimensionalArray) {
    let newMatrix = createMatrixRows(twoDimensionalArray[0].length);
    for (i = 0; i < twoDimensionalArray[0].length; i++) {
        for (j = 0; j < twoDimensionalArray.length; j++) {
            newMatrix[i][j] = twoDimensionalArray[2 - j][i];
        }
    }
    return newMatrix;
}

console.log(rotateMatrix(myMatrix));
console.log(rotateMatrix2(myMatrix));


function getSzorzoTabla(number) {
    let array = [];
    for (let i = 0; i < number; i++) {
        array[i] = [];
        for (let j = 0; j < number; j++) {
            array[i][j] = (i + 1) * (j + 1);
        }
    }
    return array;
}

console.log(getSzorzoTabla(4));

function rotateMatrix3(matrix) {
    let newMatrix = [];
    let maxIndex = matrix.length - 1;
    for (let i = 0; i < matrix.length; i++) {
        newMatrix[i] = [];
        for (let j = 0; j < matrix.length; j++) {
            newMatrix[i][j] = matrix[maxIndex - i][j];
            //newMatrix[0][0] = matrix[2-0 = 2][0]
            //newMatrix[1][0] = matrix[2-1 = 1][0]
            //newMatrix[2][0] = matrix[2-2 = 0][0]
        }
    }
    return newMatrix;
}

console.log(myMatrix);
console.log(rotateMatrix3(myMatrix));