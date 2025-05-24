function solution(numbers) {
    let answer = 1;
    let max = Number.MIN_SAFE_INTEGER;
    for(let i = 0; i < numbers.length; i++) {
        for(let j = i + 1; j < numbers.length; j++) {
            answer = numbers[i] * numbers[j];
            
            if(answer > max) {
                max = answer;
            }
        }
    }
    return max;
}