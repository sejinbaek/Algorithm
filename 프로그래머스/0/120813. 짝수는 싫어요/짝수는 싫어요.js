function solution(n) {
    return Array.from(new Array(n), (_, i) => i + 1).filter(i => i % 2 == 1);
}