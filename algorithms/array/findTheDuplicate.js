//You have an array that contains strings. Every item in the array is unique except one which is present in the array exactly twice.
//Write a function which finds the string that is present twice in the array. You might assume that the input array is not null,
//the length is greater or equal to 2 and less than one million. Strive for the low time complexity!

let myStrings = ['Mike', 'Matt', 'Nancy', 'Adam', 'Adam', 'Jenny', 'Nancy', 'Carl', 'Adam'];

function findTheDuplicate(words) {
    let hits = {};
    return (!words || words.length < 2 || words.length > 1e6)
    ? 'input is not valid'
    //: words.filter((currentValue, index) => words.indexOf(currentValue) !== index);
    : words.filter((currentValue) => {
            if(!hits.hasOwnProperty(currentValue)) {
                hits[currentValue] = 0;
            }
            hits[currentValue]++;
            return hits[currentValue] === 2;
        });
}

console.log(findTheDuplicate(myStrings));