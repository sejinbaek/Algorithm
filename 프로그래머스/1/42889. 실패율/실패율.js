function solution(N, stages) {
    // 각 스테이지별 사용자 수를 저장할 배열
    let user = new Array(N + 2).fill(0);
    
    for(let stage of stages) {
        user[stage]++;
    }
    
    // 실패율을 저장할 배열
    let failureRate = [];
    let total = stages.length;
    
    for(let i = 1; i <= N; i++) {
        if(total === 0) {
            failureRate.push({stage: i, rate: 0})
        } else {
            // 클리어하지 못한 사용자 수
            let unsuccessfulUser = user[i];
            failureRate.push({stage: i, rate: unsuccessfulUser / total})
            total -= unsuccessfulUser;
        }
    }
    failureRate.sort((a, b) => {
        if(b.rate !== a.rate) return b.rate - a.rate
        // 실패율이 같을 때 스테이지 번호가 낮은 순으로 정렬
        return a.stage - b.stage;
    })
    return failureRate.map(el => el.stage);
}