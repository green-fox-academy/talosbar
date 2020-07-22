let arrayOfIntegers = [-4, 3, -9, 0, 4, 1];

function plusMinus(arr) {
    let quantityOfPlus = 0;
    let quantityOfMinus = 0;
    let quantityOfZero = 0;
    for (let i = 0; i < arr.length; i++) {
        if (arr[i] < 0) {
            quantityOfMinus++;
        } else if (arr[i] === 0) {
            quantityOfZero++;
        } else {
            quantityOfPlus++;
        }
    }
    let ratioOfPlus = (quantityOfPlus / arr.length).toFixed(6);
    let ratioOfMinus = (quantityOfMinus / arr.length).toFixed(6);
    let ratioOfZero = (quantityOfZero / arr.length).toFixed(6);
    return '' + ratioOfPlus + '\n' + ratioOfMinus + '\n' + ratioOfZero;
}

console.log(plusMinus(arrayOfIntegers));