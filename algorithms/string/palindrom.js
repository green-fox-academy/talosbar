//write a function shich decides whether a text is palindrom (it's the same whether zou read it forwards or backwards)
//e.g. abba, rotator, stats. You might assume that the input string is not null, the legnth is greater than 1 and less one
//million. Strive for the low memory complexity!

let myWord = 'alma';
let myWord2 = 'görög';

function isAPalindrom(word) {
    let temp = word.split('').reverse().join('');
    return (!word || word.length <= 1 || word.length > 1e6)
        ? 'input is not valid'
        : (temp === word);
}

console.log(isAPalindrom(myWord));
console.log(isAPalindrom(myWord2));