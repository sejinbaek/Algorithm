import java.util.*;
import java.io.IOException;

class Main {
    static int[] dx = { -1, 0, 1, 0 };
    static int[] dy = { 0, 1, 0, -1 };

    // 그림 하나의 너비를 구하는 bfs 메서드
    static int getPictureSize(int[][] arr, boolean[][] visited, int startX, int startY, int n, int m) {
        Queue<int[]> q = new LinkedList<>();
        // 시작점을 큐에 넣고 방문 처리하기
        q.offer(new int[] { startX, startY });
        visited[startX][startY] = true;
        int size = 1; // 현재 그림 크기

        while (!q.isEmpty()) {
            int[] now = q.poll();
            int currentX = now[0];
            int currentY = now[1];

            // 4방 탐색하기
            for (int i = 0; i < 4; i++) {
                int nextX = currentX + dx[i]; // 다음 x값
                int nextY = currentY + dy[i]; // 다음음 y값

                // 범위 내에 있고, 갈 수 있고, 방문하지 않았으면
                if (nextX >= 0 && nextX < n && nextY >= 0 && nextY < m && arr[nextX][nextY] == 1
                        && !visited[nextX][nextY]) {
                    visited[nextX][nextY] = true;
                    q.offer(new int[] { nextX, nextY });
                    size++;
                }
            }
        }
        return size;
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // 도화지의 세로 크기
        int m = sc.nextInt(); // 도화지의 가로 크기

        int[][] arr = new int[n][m];

        sc.nextLine(); // 버퍼 처리용
        for (int i = 0; i < n; i++) {
            String oneLine = sc.nextLine(); // 한 줄씩 입력 받기
            String[] tokens = oneLine.split(" ");

            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(tokens[j]); // 문자열을 정수로 변환
            }
        }
        // 입력 완료

        boolean[][] visited = new boolean[n][m];

        int count = 0; // 그림의 개수
        int maxSize = 0; // 그림 중 가장 큰 그림의 크기

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // (i,j)가 1이고 아직 방문하지 않았다면 새로운 그림의 시작점 의미
                if (arr[i][j] == 1 && !visited[i][j]) {
                    // 새로운 그림 추가
                    count++;
                    // bfs를 진행한 메서드 호출 후 반환값을 size에 저장
                    int size = getPictureSize(arr, visited, i, j, n, m);
                    maxSize = Math.max(maxSize, size);
                }
            }
        }

        System.out.println(count);
        System.out.println(maxSize);

    }
}