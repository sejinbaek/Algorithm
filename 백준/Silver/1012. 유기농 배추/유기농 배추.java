import java.io.*;
import java.util.*;

class Main {
    static int[] dx = { -1, 0, 1, 0 }; // 상우하좌 (행 이동)
    static int[] dy = { 0, 1, 0, -1 }; // 열 이동

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine()); //테스트 케이스의 개수
        
        for (int i = 0; i < T; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken()); //배추밭의 가로길이
            int N = Integer.parseInt(st.nextToken()); //배추밭의 세로길이
            int K = Integer.parseInt(st.nextToken()); //심어진 배추의 위치

            int[][] field = new int[N][M]; //배추밭 배열
            boolean[][] visited = new boolean[N][M];
    
            for(int j = 0; j < K; j++) {
                st = new StringTokenizer(br.readLine());
                int X = Integer.parseInt(st.nextToken()); //배추의 x좌표
                int Y = Integer.parseInt(st.nextToken()); //배추의 y좌표
                // 입력은 (X, Y)지만, 배열은 [Y][X]
                field[Y][X] = 1; //배추밭에 1로 표시
            }
            //입력 완료

            int count = 0;
            
            //하고 싶은 일
            for(int y = 0; y < N; y++) {
                for(int x = 0; x < M; x++) {
                    if (field[y][x] == 1 && !visited[y][x]) { // 1의 시작점이라면
                        bfs(field, visited, y, x, N, M);
                        count++;
                    }
                }
            }
            System.out.println(count);
        }
    }

    static void bfs(int[][] field, boolean[][] visited, int startY, int startX, int height, int width) {
        Queue<int[]> q = new ArrayDeque<>();
        // 시작점을 큐에 넣고 방문 처리하기
        q.offer(new int[] { startX, startY });
        //N이 행이고, M이 열이기 때문에 (startY, startX)
        visited[startY][startX] = true;

        // 큐가 비어 있지 않을 동안 반복
        while (!q.isEmpty()) {
            int[] now = q.poll();
            int currentX = now[0];
            int currentY = now[1];

            // 4방 탐색하기
            for (int i = 0; i < 4; i++) {
                int nextX = currentX + dx[i]; // 다음 x값
                int nextY = currentY + dy[i]; // 다음 y값

                // 범위 내에 있고, 갈 수 있고, 방문하지 않았으면
                if (nextX >= 0 && nextX < width && nextY >= 0 && nextY < height && field[nextY][nextX] == 1
                        && !visited[nextY][nextX]) {
                    visited[nextY][nextX] = true;
                    q.offer(new int[] { nextX, nextY });
                }
            }
        }
    }
}