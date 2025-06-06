function solution(d, budget) {
    d.sort((a, b) => a - b); // 금액 오름차순 정렬
    let sum = 0;
    let count = 0;

    for (let i = 0; i < d.length; i++) {
        sum += d[i];
        if (sum > budget) break;
        count++;
    }

    return count;
}
