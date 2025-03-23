function solution(arr) {
  const stack = [];

  for (let i = 0; i < arr.length; i++) {
    if (stack.length > 0 && stack[stack.length - 1] === arr[i]) {
      stack.pop();
    }
    stack.push(arr[i]);
  }

  return stack;
}