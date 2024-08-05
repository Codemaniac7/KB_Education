const score = [82, 96, 54, 76, 44, 5, 11];
// score.sort();
console.log(score);
// function compare(left, right) {
//     return left - right;
// }
score.sort((a, b) => {
    return a - b;
});
console.log(score);
