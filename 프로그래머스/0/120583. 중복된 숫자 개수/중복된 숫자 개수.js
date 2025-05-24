function solution(array, n) {
    let answer = 0;
    answer = array.filter(e => e === n);
    return answer.length;
}