import java.io.*;
import java.util.*;

class Main {
    static int[] dx = { -1, 0, 1, 0 }; // 상우하좌 (시계 방향 연산 순서)
    static int[] dy = { 0, 1, 0, -1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 행의 개수
        int M = Integer.parseInt(st.nextToken()); // 열의 개수

        int[][] arr = new int[N][M];

        for (int i = 0; i < N; i++) {
            String[] tokens = br.readLine().trim().split("");
            for (int j = 0; j < M; j++) { // 행렬 입력 받기
                arr[i][j] = Integer.parseInt(tokens[j]);
            }
        }
        // 입력 완료
        // 2. 방문 처리 배열 만들기 (이차원 배열로)
        boolean[][] visited = new boolean[N][M];
        // 1. Queue부터 만들기
        Queue<int[]> q = new ArrayDeque<>();
        int startX = 0, startY = 0;
        q.offer(new int[] { startX, startY });
        // 3. 방문 체크하기
        visited[startX][startY] = true;

        while (!q.isEmpty()) { // 4. 큐가 비지 않을 때까지 반복
            int[] curV = q.poll(); // 현재 위치
            int curX = curV[0]; // 현재 위치의 X값
            int curY = curV[1]; // 현재 위치의 Y값

            // 하고 싶은 일 - 목표까지 도달했는지 확인하는 것
            if (curX == N - 1 && curY == M - 1) { // curX와 curY는 인덱스
                System.out.println(arr[curX][curY]); // 부모보다 1 큰 값으로 출력될 것
                break;
            }

            // 5. 4방 탐색하기
            for (int i = 0; i < 4; i++) {
                int nx = curX + dx[i]; // 새로운 x값
                int ny = curY + dy[i]; // 새로운 y값

                // 범위 내에 있고, 갈 수 있고, 방문하지 않았으면
                if (nx >= 0 && nx < N && ny >= 0 && ny < M && arr[nx][ny] == 1 && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    q.offer(new int[] { nx, ny });
                    // 원본 배열에 새로운 위치를(자식 위치) 원본 배열의 현재 위치 + 1로 넣겠다
                    arr[nx][ny] = arr[curX][curY] + 1; // 큐에는 자식이 들어가고, 원본 배열에는 부모 값 + 1한 값 넣기

                }
            }
        }
    }
}