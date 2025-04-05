import java.io.*;
import java.util.*;

class Main {
    static int[] dx = { -1, 0, 1, 0 };
    static int[] dy = { 0, 1, 0, -1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken()); // 상자의 가로 칸의 수
        int N = Integer.parseInt(st.nextToken()); // 상자의 세로 칸의 수

        int[][] arr = new int[N][M]; // 토마토의 상태를 저장할 배열
        boolean[][] visited = new boolean[N][M]; // 방문 여부를 확인할 배열

        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            String[] tokens = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(tokens[j]);
                if (arr[i][j] == 1) { // 익은 토마토를 큐에 넣기
                    q.offer(new int[] { i, j });
                    visited[i][j] = true;
                }
            }
        }
        // 입력 완료

        // 0이면 익지 않은 토마토
        // 1이면 익은 토마토
        // -1이면 토마토 X

        // BFS 수행하기
        while (!q.isEmpty()) {
            int[] now = q.poll(); // 현재 위치
            int cx = now[0];
            int cy = now[1];

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i]; // 다음 값
                int ny = cy + dy[i];

                if (nx >= 0 && nx < N && ny >= 0 && ny < M && arr[nx][ny] == 0 && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    q.offer(new int[] { nx, ny });
                    arr[nx][ny] = arr[cx][cy] + 1; // 일수 업데이트
                }
            }
        }

        // 하고 싶은 일 - 모든 토마토가 익을 최소 일자 구하기
        int days = 0; // 일수
        boolean unripeExists = false; // 안 익은 토마토 존재 여부를 확인할 불리언 값

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 0) { // 0이면 익지 않은 토마토
                    unripeExists = true; // 익지 않은 토마토 존재 처리
                }
                days = Math.max(days, arr[i][j]); // 일수 업데이트
            }
        }

        if (unripeExists) {
            System.out.println(-1);
        } else {
            System.out.println(days - 1);
        }
    }
}