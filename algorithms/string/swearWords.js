let originalTextWithSwearWords = 'Lorem Ipsum is simply fuck dummy text of the printing and typesetting industry. ' +
    'Lorem Ipsum has been the industry\'s standard dummy bloddy text ever since the 1500s, when an unknown printer ' +
    'took a galley of type and scrambled it to make a type specimen shit book. It has survived not only five centuries, ' +
    'but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s ' +
    'with the release of Letraset sheets containing dick Lorem Ipsum passages, and more recently with desktop publishing ' +
    'software like Aldus PageMaker including versions of asshole Lorem Ipsum.';

let swearWords = ["fuck", "bloody", "cock", "shit", "fucker", "fuckstick", "asshole", "dick", "piss", "cunt"];

function countSwearWordsInTheOriginalText(text, array) {
    let hits = {};
    text.split(' ')
        .map(word => word.replace(/[.,\s]/g, ''))
        .filter(word => array.includes(word))
        .forEach((currentValue => {
            if (!hits.hasOwnProperty(currentValue)) {
                hits[currentValue] = 0;
            }
            hits[currentValue]++;
        }));
    return hits;
}

function getCleanText(text, array) {
    return text.split(' ')
        .filter(word => !array.includes(word))
        .join(' ')
}

console.log(countSwearWordsInTheOriginalText(originalTextWithSwearWords, swearWords));
console.log(getCleanText(originalTextWithSwearWords, swearWords));