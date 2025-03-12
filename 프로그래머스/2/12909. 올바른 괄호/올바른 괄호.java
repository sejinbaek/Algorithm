import java.util.*;

class Solution {
    boolean solution(String s) {
        
        Stack<Character> stack = new Stack<>();
        
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(') { //'('이면 stack에 넣기
                stack.push(s.charAt(i)); 
            } else { //')'인데
                if(stack.isEmpty()) { //stack이 비어있다면
                    return false;
                } 
                stack.pop();
            }
        }
        
        if(stack.isEmpty()) {
            return true;
        } else {
            return false;
        }

    }
}