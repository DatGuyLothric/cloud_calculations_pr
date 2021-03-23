// Pure UniqueItemsFinder
function uniqueLetters(array) {
    const temp = [];
    array.forEach(element => {
        if (!temp.includes(element[0])) temp.push(element[0]);
    });
    return temp;
}

function maxLetters(array) {
    const temp = uniqueLetters(array);
    array.forEach(element => {
        let currentMaxIndex = temp.findIndex(e => e[0] === element[0]);
        if (temp[currentMaxIndex].length < element.length) temp[currentMaxIndex] = element;
    });
    return temp;
}

function mapToResultArray(array) {
    return maxLetters(array).map(element => `${ element } -> ${ element.length }`);
}

// Example
console.log(mapToResultArray(['aaaaaaa', 'bbbbbb', 'ccc', 'd', 'aaa', 'c', 'bb']));
console.log(mapToResultArray(['qqqqqq', 'qqqq', 'qq', 'q']));
console.log(mapToResultArray(['mmmmmmmmmmmmmmmmmm']));

// Console output
// [ 'aaaaaaa -> 7', 'bbbbbb -> 6', 'ccc -> 3', 'd -> 1' ]
// [ 'qqqqqq -> 6' ]
// [ 'mmmmmmmmmmmmmmmmmm -> 18' ]
