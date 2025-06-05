function solution(n, m) {
    const gcd1 = gcd(n, m);
    const lcm = n * m / gcd1;
    return [gcd1, lcm];
}

// 최대 공약수 구하기
function gcd(n, m) {
    if(m === 0) {
        return n;
    }
    return gcd(m, n % m);
}