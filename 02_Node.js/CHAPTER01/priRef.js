// function swap(x, y) {
//     let temp = x;
//     x = y;
//     console.log(x);
//     y = temp;
//     console.log(y);
// }

// let a = 100;
// let b = 200;

// console.log(`swap 호출 전 -> a:${a},b:${b}`);
// swap(a, b);
// console.log(`swap 호출 후 -> a:${a},b:${b}`);

function swap(numbers) {
    let temp = numbers[0];
    numbers[0] = numbers[1];
    numbers[1] = temp;
    console.log(`swap 함수 안 -> numbers:${numbers}`);
}

let arr = [100, 200];

console.log(`swap 호출 전 -> arr:${arr}`);
swap(arr);
console.log(`swap 호출 후 -> arr:${arr}`);
