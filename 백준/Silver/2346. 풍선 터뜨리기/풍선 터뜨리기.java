import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        ArrayDeque<int[]> deque = new ArrayDeque<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int move = Integer.parseInt(st.nextToken());
            deque.addLast(new int[]{i + 1, move}); // 풍선 번호는 1부터 시작
        }

        while (!deque.isEmpty()) {
            int[] current = deque.pollFirst(); // 풍선 터뜨림
            sb.append(current[0]).append(" ");  // 번호 기록

            if (deque.isEmpty()) break;

            int move = current[1];

            // 양수: 오른쪽 → 앞에서 빼서 뒤로 move - 1번
            if (move > 0) {
                for (int i = 0; i < move - 1; i++) {
                    deque.addLast(deque.pollFirst());
                }
            }
            // 음수: 왼쪽 → 뒤에서 빼서 앞으로 abs(move)번
            else {
                for (int i = 0; i < Math.abs(move); i++) {
                    deque.addFirst(deque.pollLast());
                }
            }
        }

        System.out.println(sb.toString());
    }
}
