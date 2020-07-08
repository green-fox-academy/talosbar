//You have a long string that has some meaning on a real language. For example a whole novel in a single string.
//Write a function that counts the occurence of each word inside the string and writes them to the output in the
//following format: word: number of occurences. You might assume that the input is not null and not empty.
//The order of the words on the output does not matter. The solution might be case insensitive, you don't have
//to differentiate between capital and non-capital letters. The punctuation marks and line endings are not part
//of the words!

let myString = 'Boci, boci tarka, se füle, se farka.';

function countTheWords(text) {
    let hits = {};
    text.split(' ')
        .map(word => word.replace(/[.,\s]/g, ''))
        .forEach((currentValue => {
            if(!hits.hasOwnProperty(currentValue)) {
                hits[currentValue] = 0;
            }
            hits[currentValue]++;
        }));
    return (!text && text.length === 0)
        ? 'input is not valid'
        : hits
}

console.log(countTheWords(myString));