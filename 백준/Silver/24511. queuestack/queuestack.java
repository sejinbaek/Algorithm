import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        // 타입 배열 입력 (0 = queue, 1 = stack)
        int[] type = Arrays.stream(br.readLine().split(" "))
                           .mapToInt(Integer::parseInt)
                           .toArray();

        // 초기 데이터 입력
        int[] originalData = Arrays.stream(br.readLine().split(" "))
                              .mapToInt(Integer::parseInt)
                              .toArray();

        // 큐 타입만 Deque에 넣기
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            if (type[i] == 0) {
                deque.offerFirst(originalData[i]);
            }
        }
        

        int M = Integer.parseInt(br.readLine());

        // 삽입할 값들 입력
        int[] insertData = Arrays.stream(br.readLine().split(" "))
                                 .mapToInt(Integer::parseInt)
                                 .toArray();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            deque.offerLast(insertData[i]);              // 뒤에 삽입
            sb.append(deque.pollFirst()).append(" ");    // 앞에서 출력
        }

        System.out.println(sb);
    }
}