function solution(arr) {
    const min = Math.min(...arr)
    const filtered = arr.filter(el => el !== min)
    return filtered.length ? filtered : [-1];
}