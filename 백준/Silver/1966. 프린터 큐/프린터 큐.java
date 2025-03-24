//문서마다 중요도 존재
//앞에서 꺼낸 문서보다 더 중요한 문서가 남아 있으면 뒤로 보내고 없으면 출력
//특정 문서가 몇 번째로 출력되는지지

import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(br.readLine()); //테스트케이스 개수

        for (int t = 0; t < tc; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken()); //문서의 개수
            int M = Integer.parseInt(st.nextToken()); //문서의 인덱스

            Deque<int[]> deque = new LinkedList<>(); //int[0] -> 문서 번호, int[1] -> 중요도
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                int priority = Integer.parseInt(st.nextToken());
                deque.add(new int[] {j, priority}); //모든 문서를 deque에 저장
            }

            //인쇄 시작
            int cnt = 0;

            while (!deque.isEmpty()) {
                int[] current = deque.pollFirst(); //맨 앞 문서를 꺼내서 current에 넣기
                boolean isMax = true;

                //더 중요한 문서가 있는지 확인하는 forEach문
                for (int[] doc : deque) {
                    if (doc[1] > current[1]) { //더 중요한 문서가 존재한다면 다시 뒤로 보내기
                        isMax = false;
                        break;
                    }
                }

                if (isMax) {
                    cnt++; //인쇄 횟수 증가
                    if (current[0] == M) break; //우리가 찾던 문서면 빠져나오기
                } else {
                    deque.offerLast(current); //우리가 찾던 문서가 아니면 뒤로 보내기
                }
            }

            sb.append(cnt).append("\n");
        }

        System.out.print(sb);
    }
}
