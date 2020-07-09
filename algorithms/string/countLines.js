let poem = 'Nincsen apám, se anyám,\n' +
    'se istenem, se hazám,\n' +
    'se bölcsőm, se szemfedőm,\n' +
    'se csókom, se szeretőm.\n' +
    '\n' +
    'Harmadnapja nem eszek,\n' +
    'se sokat, se keveset.\n' +
    'Húsz esztendőm hatalom,\n' +
    'húsz esztendőm eladom.\n' +
    '\n' +
    'Hogyha nem kell senkinek,\n' +
    'hát az ördög veszi meg.\n' +
    'Tiszta szívvel betörök,\n' +
    'ha kell, embert is ölök.\n' +
    '\n' +
    'Elfognak és felkötnek,\n' +
    'áldott földdel elfödnek\n' +
    's halált hozó fű terem\n' +
    'gyönyörűszép szívemen.';

function countLines(inputText) {
    return inputText.split(/\n/g || '').length;
}

console.log(countLines(poem));
