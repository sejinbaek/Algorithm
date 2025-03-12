import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        ArrayList<Integer> list = new ArrayList<>();

        int N = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();
        
        for(int i = 0; i < N; i++) {
            String command = br.readLine();
            
            if(command.charAt(0) == '1') {
                int x = Integer.parseInt(command.substring(2));
            	stack.push(x);
            } else if (command.charAt(0) == '2') {
            	sb.append(!stack.isEmpty() ? stack.pop() : -1).append("\n");
            } else if (command.charAt(0) == '3') {
            	sb.append(stack.size()).append("\n");
            } else if (command.charAt(0) == '4') {
            	sb.append(stack.isEmpty() ? 1 : 0).append("\n");
            } else {
            	sb.append(!stack.isEmpty() ? stack.peek() : -1).append("\n");
            }
        }
        
        System.out.print(sb.toString());

    }
}
