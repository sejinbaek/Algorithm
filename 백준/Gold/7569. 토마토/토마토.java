import java.io.*;
import java.util.*;

class Main {
    static int[] dx = { -1, 0, 1, 0, 0, 0 }; // 상우하좌 (행 이동)
    static int[] dy = { 0, 1, 0, -1, 0, 0 }; // 열 이동
    static int[] dz = { 0, 0, 0, 0, 1, -1}; // 위, 아래

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken()); // 상자의 가로 칸의 수
        int N = Integer.parseInt(st.nextToken()); // 상자의 세로 칸의 수
        int H  = Integer.parseInt(st.nextToken()); // 상자의 수

        int[][][] arr = new int[H][N][M]; // 토마토의 상태를 저장할 배열
        boolean[][][] visited = new boolean[H][N][M]; // 방문 여부를 확인할 배열

        Queue<int[]> q = new ArrayDeque<>();
        for(int h = 0; h < H; h++) {
            for (int n = 0; n < N; n++) {
                st = new StringTokenizer(br.readLine());
                for (int m = 0; m < M; m++) {
                    arr[h][n][m] = Integer.parseInt(st.nextToken());
                    if (arr[h][n][m] == 1) { // 익은 토마토를 큐에 넣기 (시작점이 여러 개)
                        q.offer(new int[] { h, n, m }); //높이, 세로, 가로
                        visited[h][n][m] = true;
                    }
                }
            }
        }
        // 입력 완료

        bfs(arr, visited, q, H, N, M);

        // 0이면 익지 않은 토마토
        // 1이면 익은 토마토
        // -1이면 토마토 X

        // 하고 싶은 일 - 모든 토마토가 익을 최소 일자 구하기
        int days = 0; // 일수
        boolean unripeExists = false; // 안 익은 토마토 존재 여부를 확인할 불리언 값

        for(int h = 0; h < H; h++) {
            for (int n = 0; n < N; n++) {
                for (int m = 0; m < M; m++) {
                    if (arr[h][n][m] == 0) { // 0이면 익지 않은 토마토
                        unripeExists = true; // 안 익은 토마토 존재 처리
                    }
                    // arr[i][j]에는 그 칸의 토마토가 며칠 째에 익었는지에 대한 정보 저장
                    days = Math.max(days, arr[h][n][m]); // 일수 업데이트
                }
            }
        }

        if (unripeExists) {
            System.out.println(-1);
        } else {
            // 시작은 1로 했고, 실제로는 0일부터 익은 토마토이기 때문에 -1을 해줘야 함
            System.out.println(days - 1);
        }
    }

    static void bfs(int[][][] arr, boolean[][][] visited, Queue<int[]> q, int H, int N, int M) {
        while (!q.isEmpty()) {
            int[] now = q.poll();
            int cz = now[0];
            int cx = now[1];
            int cy = now[2];

            for (int i = 0; i < 6; i++) {
                int nz = cz + dz[i];
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nz >= 0 && nz < H && nx >= 0 && nx < N && ny >= 0 && ny < M) {
                    if (!visited[nz][nx][ny] && arr[nz][nx][ny] == 0) {
                        visited[nz][nx][ny] = true;
                        q.offer(new int[] { nz, nx, ny });
                        arr[nz][nx][ny] = arr[cz][cx][cy] + 1; // 일수 업데이트
                    }
                }
            }
        }
    }
}