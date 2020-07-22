let myNumbers = [3, 4, 5, 6, 7];

function sumAll(numbers) {
    return numbers.reduce((partialSum, a) => partialSum + a, 0);
}

console.log(sumAll(myNumbers));




