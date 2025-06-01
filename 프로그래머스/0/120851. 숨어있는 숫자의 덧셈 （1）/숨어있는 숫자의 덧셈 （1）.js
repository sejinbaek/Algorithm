function solution(my_string) {
    return my_string.split("").filter(el => !isNaN(el)).map(Number).reduce((acc, cur) => acc + cur, 0);
}