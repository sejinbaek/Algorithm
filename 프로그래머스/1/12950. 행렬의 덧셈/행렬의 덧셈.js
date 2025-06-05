function solution(arr1, arr2) {
    return arr1.map((el, i) => el.map((v, j) => v + arr2[i][j]));
}