import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        
        Queue<Integer> queue = new LinkedList<>(); //대기열
        Stack<Integer> stack = new Stack<>(); //추가 대기열
        
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for(int i = 0; i < N; i++) {
        	queue.offer(Integer.parseInt(st.nextToken()));
        }
        
        int start = 1;
        
        while(!queue.isEmpty()) {
        	if(queue.peek() == start) {
        		queue.poll();
        		start++;
        	} else if (!stack.isEmpty() && stack.peek() == start) {
        		stack.pop();
        		start++;
        	} else { //큐 대기열에 있는 학생 순서가 start와 동일하지 않다면
        		stack.push(queue.poll()); //큐에서 빼고 스택에 넣기
        	}
        }
        
        while(!stack.isEmpty()) {
        	if(stack.peek() == start) {
        		stack.pop();
        		start++;
        	} else {
        		System.out.println("Sad");
        		return;
        	}
        }
        System.out.println("Nice");
    }
}
