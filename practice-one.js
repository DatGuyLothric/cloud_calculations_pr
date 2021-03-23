// Pure SumArray
function sumArray(array, sum = 0, index = 0) {
    return index >= array.length
        ? sum
        : sumArray(array, sum + array[index], index + 1);
}

// Example
console.log(sumArray([1, 2, 3, 4, 5, 6, 7]));
console.log(sumArray([-3, -2, -1, 0, 1, 2, 3]));
console.log(sumArray([10]));

// Console output
// 28
// 0
// 10
