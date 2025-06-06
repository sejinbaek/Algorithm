function isValidMove(nx, ny) {
    // 1. 좌표평면을 벗어나는지 체크하는 함수
    return nx >= -5 && nx <= 5 && ny >= -5 && ny <= 5
}

function updateLocation(x, y, dir) {
    // 2. 명령어를 통해 다음 좌표 설정
    switch(dir) {
        case "U":
            return [x, y + 1];
        case "D":
            return [x, y - 1];
        case "R":
            return [x + 1, y];
        case "L":
            return [x - 1, y];
    }
}

function solution(dirs) {
    let x = 0;
    let y = 0;
    
    // 3. 겹치는 좌표를 1개로 처리하기 위한 Set
    const visited = new Set();
    for(const dir of dirs) {
        // 4. 주어진 명령어로 움직이면서 좌표 저장
        const [nx, ny] = updateLocation(x, y, dir);
    
        // 5. 벗어난 좌표는 무시
        if(!isValidMove(nx, ny)) {
            continue;
        }

        // 6. A에서 B로 간 경우 B에서 A도 추가
        visited.add(`${x}${y}${nx}${ny}`);
        visited.add(`${nx}${ny}${x}${y}`);

        // 7. 좌표를 이동했으므로 업데이트
        [x, y] = [nx, ny];
    }
    
    return visited.size / 2;
}