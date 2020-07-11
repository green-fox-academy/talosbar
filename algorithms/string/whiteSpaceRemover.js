let myText = 'Abrakadabra.      Sarah elment boltba.    A sas leszállt  a fára.';
let myText2 = '    hello world     ';

function removeWhiteSpaces(text) {
    // return text
    //     .split('  ')
    //     .filter(element => element !== '')
    //     .join(' ');

    return text.replace(/[ ]{2,}/g, ' ');
}

console.log(removeWhiteSpaces(myText));

function removeWhiteSpaces2(text) {
    return text.trim();
}

console.log(removeWhiteSpaces2(myText2));