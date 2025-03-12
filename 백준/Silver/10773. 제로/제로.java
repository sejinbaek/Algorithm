import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        
        ArrayList<Integer> list = new ArrayList<>();

        int K = sc.nextInt();
        sc.nextLine();

        Stack<Integer> stack = new Stack<>();
        
        for(int i = 0; i < K; i++) {
            int num = sc.nextInt();
            
            if(!stack.empty() && num == 0) {
            	stack.pop();
            } else {
            	stack.push(num);
            }
        }
        
        int sum = 0;
        
        for(int i = 0; i < stack.size(); i++) {
        	sum += stack.get(i);
        }
        
        System.out.println(sum);
    }
}
