import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        LinkedList<Integer> deque = new LinkedList<>();

        for(int i = 1; i <= N; i++) { //덱에 1부터 N까지 수 넣기기
            deque.add(i);
        }

        int count = 0;

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++) {
            int number = Integer.parseInt(st.nextToken()); //뽑을 원소 받기

            while(deque.peekFirst() != number) {
                if(deque.indexOf(number) <= deque.size() / 2) {
                    deque.addLast(deque.pollFirst());
                }
                else {
                    deque.addFirst(deque.pollLast());
                }
                count++;
            }

            if(deque.peekFirst() == number) {
                deque.pollFirst();
            }
        }
        System.out.println(count);
    }
}