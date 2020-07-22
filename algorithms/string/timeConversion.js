let timeIn12HourFormat = '12:40:45PM';

function timeConversion(s) {
    let arrayWithStrings = s.split(':');
    let maxIndex = arrayWithStrings[arrayWithStrings.length - 1];
    let newValueOfFirstIndex;
    let originalFirstIndex = parseInt(arrayWithStrings[0]);
    if (maxIndex.endsWith('PM') && originalFirstIndex !== 12) {
        newValueOfFirstIndex = originalFirstIndex + 12;
        if (newValueOfFirstIndex === 24) {
            newValueOfFirstIndex = '00';
        }
        arrayWithStrings[0] = newValueOfFirstIndex;
    }
    if (maxIndex.endsWith('AM') && originalFirstIndex === 12) {
        newValueOfFirstIndex = '00';
        arrayWithStrings[0] = newValueOfFirstIndex;
    }
    let newMaxIndex = maxIndex.slice(0, -2);
    arrayWithStrings.pop();
    arrayWithStrings.push(newMaxIndex);
    return arrayWithStrings.join(':');
}

console.log(timeConversion(timeIn12HourFormat));