import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        
        ArrayList<Integer> list = new ArrayList<>();

        int N = sc.nextInt();
        sc.nextLine();

        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < N; i++) {
            String command = sc.nextLine();
            if(command.startsWith("push")) {
                int number = Integer.parseInt(command.substring(5));
            	stack.push(number);
            } else if(command.startsWith("pop")) {
            	list.add(stack.isEmpty() ? -1 : stack.pop());
            } else if(command.startsWith("size")) {
            	list.add(stack.size());
            } else if(command.startsWith("top")) {
            	list.add(stack.isEmpty() ? -1 : stack.peek());
            } else {
            	list.add(stack.isEmpty() ? 1 : 0);
            }
        }
        
        for(int i = 0; i < list.size(); i++)
        {
        	System.out.println(list.get(i));
        }
    }
}
