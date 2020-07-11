let listToOrder = [1, 1, 1, 2, 2, 3];
let listToOrder2 = [8, 9, 3, 8, 9, 9, 9, 3, 1, 1];

function countFrequency(numbers) {
    let hits = {};
    numbers.forEach(currentValue => {
        if (!hits.hasOwnProperty(currentValue)) {
            hits[currentValue] = 0;
        }
        hits[currentValue]++;
    });
    return hits;
}

function orderByFrequency(unordered) {
    return Object
        .keys(unordered)
        .sort(function (a, b) {
            return unordered[b] - unordered[a];
        })
}

console.log(orderByFrequency(countFrequency(listToOrder)));
console.log(orderByFrequency(countFrequency(listToOrder2)));