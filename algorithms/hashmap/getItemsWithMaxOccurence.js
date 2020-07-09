let myObject = {
    Boci: 1,
    boci: 1,
    tarka: 1,
    se: 2,
    fule: 1,
    farka: 1,
}

function getItemsWithMaxOccurence(unordered) {
    let topTwoValues = Object
        .keys(unordered)
        .sort(function (a, b) {
        return unordered[b] - unordered[a];
    });
    return topTwoValues[0] + ', ' + topTwoValues[1];
}

function getItemsSortedByKeys(unordered) {
    const ordered = {};
    Object.keys(unordered).sort().forEach(function (key) {
        ordered[key] = unordered[key];
    });
    return JSON.stringify(ordered);
}

console.log(getItemsWithMaxOccurence(myObject));
console.log(getItemsSortedByKeys(myObject));