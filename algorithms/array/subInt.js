//  Create a function that takes a number and an array of integers as a parameter
//  Returns the indices of the integers in the array of which the first number is a part of
//  Or returns an empty array if the number is not part of any of the integers in the array

let firstNumber = 1;
let secondNumber = 9;

let myArray = [1, 11, 34, 52, 61];

function subInt(number, listOfNumbers) {
    return listOfNumbers
        .filter(item => item.toString().includes(number.toString()))
        .map(filteredItem => listOfNumbers.indexOf(filteredItem));
}

console.log(subInt(firstNumber, myArray));
console.log(subInt(secondNumber, myArray));