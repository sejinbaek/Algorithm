import java.io.*;
import java.util.*;

class Main {
    static int[] dx = { -1, 0, 1, 0 }; // 상우하좌 (행 이동)
    static int[] dy = { 0, 1, 0, -1 }; // 열 이동

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt(); //테스트 케이스의 개수

        for (int i = 0; i < T; i++){
            int M = sc.nextInt();
            int N = sc.nextInt();
            int K = sc.nextInt();

            int[][] field = new int[N][M]; //배추밭 배열
            boolean[][] visited = new boolean[N][M];
    
            for(int j = 0; j < K; j++) {
                int X = sc.nextInt();
                int Y = sc.nextInt();
                field[Y][X] = 1;
            }

            int count = 0;

            for(int y = 0; y < N; y++) {
                for(int x = 0; x < M; x++) {
                    if (field[y][x] == 1 && !visited[y][x]) {
                        bfs(field, visited, x, y, M, N);
                        count++;
                    }
                }
            }
            System.out.println(count);
        }
    }

    static void bfs(int[][] field, boolean[][] visited, int startX, int startY, int n, int m) {
        Queue<int[]> q = new ArrayDeque<>();
        // 시작점을 큐에 넣고 방문 처리하기
        q.offer(new int[] { startX, startY });
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
                if (nextX >= 0 && nextX < n && nextY >= 0 && nextY < m && field[nextY][nextX] == 1
                        && !visited[nextY][nextX]) {
                    visited[nextY][nextX] = true;
                    q.offer(new int[] { nextX, nextY });
                }
            }
        }
    }
}