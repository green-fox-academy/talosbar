let myString = 'Semmi sem olyan jellemző egy költőre, mint a képei, hasonlatai. ' +
    'Mutasd meg hasonlatodat, és megmondom, ki vagy, mondja a kritikus a költőnek.';

function countCharacters(text) {
    let hits = {};
    text
        .replace(/[.,\s]/g, '')
        .toLowerCase()
        .split('')
        .forEach((currentValue => {
            if (!hits.hasOwnProperty(currentValue)) {
                hits[currentValue] = 0;
            }
            hits[currentValue]++;
        }));
    return hits;
}

function getItemsWithMaxOccurence(unordered) {
    let topTwoValues = Object
        .keys(unordered)
        .sort(function (a, b) {
            return unordered[b] - unordered[a];
        })
    return topTwoValues[0] + ', ' + topTwoValues[1];
}

console.log(getItemsWithMaxOccurence(countCharacters(myString)));