function calculateHamingDistance(word, string) {
    return word.split('').reduce(
        (distance, char, i) => {
            return distance + ((char !== string.charAt(i)) ? 1 : 0);
        }, 0);
}

function countDistance(string, list) {
    return list
        .filter(word => word.length === string.length)
        .filter(word => {
            return calculateHamingDistance(word, string) <= 3;
        });
}

console.log(countDistance('alma', ['alms', 'sas', 'kslw', 'alom']));