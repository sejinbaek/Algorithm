import java.util.Stack;
class Solution {
    boolean solution(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            char parentheses = s.charAt(i);
            if(parentheses == '(') {
                stack.push(parentheses);
            } else { // ')'라면
                if(!stack.isEmpty()) stack.pop();
                else return false;
            }
        }

        return stack.isEmpty();
    }
}