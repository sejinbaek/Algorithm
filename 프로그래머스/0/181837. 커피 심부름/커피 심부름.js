function solution(order) {
    let answer = 0;
    for(i = 0; i < order.length; i++) {
        (order[i].includes("americano") || order[i] == "anything") ? answer += 4500 : answer += 5000
    }
    return answer;
}