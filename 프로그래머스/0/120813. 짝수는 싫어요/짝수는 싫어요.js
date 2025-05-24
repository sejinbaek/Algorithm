function solution(n) {
    return Array.from(new Array(n), (x, i) => i + 1).filter(i => i % 2 == 1).sort((a, b) => a - b);
}