const { user1, user2 } = require('./users-1');
const hello = require('./hello');

hello(user1);
hello(user2);

console.log(__dirname);
console.log(__filename);
