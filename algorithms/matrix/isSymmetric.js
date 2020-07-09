//Create a function named isSymmetric that takes an n×n integer matrix (two dimensional array/list)
//    as a parameter and returns true if the matrix is symmetric or false if it is not.
//    Symmetric means it has identical values along its diagonal
//    axis from top-left to bottom-right, as in the first example.

let mySymmetricMatrix = [
    [1, 1, 1],
    [1, 1, 1],
    [1, 1, 1],
]

let myNonSymmetricMatrix = [
    [1, 1, 1, 2],
    [1, 1, 1, 2],
    [1, 1, 1, 2],
]

function isSymmetric(twoDimensionalArray) {
    for (i = 0; i < twoDimensionalArray.length; i++) {
        if (twoDimensionalArray.length === twoDimensionalArray[i].length) {
            return true;
        }
    }
    return false;
}

console.log(isSymmetric(mySymmetricMatrix));
console.log(isSymmetric(myNonSymmetricMatrix));