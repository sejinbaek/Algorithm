import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        
        Deque<Integer> deque = new ArrayDeque<>();
        List<Integer> list = new ArrayList<>();
        
        for(int i = 1; i <= N; i++) {
        	deque.add(i);
        }
        
        while(deque.size() > 1) {
        	for(int i = 0; i < K - 1; i++) {
        		deque.addLast(deque.pollFirst());
        	}
        	list.add(deque.pollFirst());
        }
        
        list.add(deque.pollFirst());
        
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        for(int i = 0; i < list.size(); i++) {
        	sb.append(list.get(i));
        	if(i != list.size()-1) {
        		sb.append(", ");
        	}
        }
        sb.append(">");
        
        System.out.println(sb);
        
    }
}