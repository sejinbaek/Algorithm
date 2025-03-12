import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        
        for(int i = 0; i < N; i++) {
            String PS = br.readLine();
            
            Stack<Character> stack = new Stack<>();
            
            boolean isValid = true;
            
            for(int j = 0; j < PS.length(); j++) {
            	char PSC = PS.charAt(j);
            	
            	if(PSC == '(') {
            		stack.push(PSC);
            	} else {
            		if(stack.isEmpty()) {
            			isValid = false;
            			break;
            		}
            		stack.pop();
            	}
            }  
            if(isValid && stack.isEmpty()) {
            	System.out.println("YES");
            } else {
            	System.out.println("NO");
            }
        }
    }
}