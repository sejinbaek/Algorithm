import java.util.*;
class Solution {
    public int solution(String s) {
        String[] numArr = {"zero", "one","two","three","four","five","six","seven","eight","nine"};
        StringBuilder temp = new StringBuilder();
        StringBuilder result = new StringBuilder();
        
        for(char c : s.toCharArray()) {
            if(Character.isDigit(c)) {
                result.append(c);
            } else {
                temp.append(c);
                for(int i = 0; i < numArr.length; i++) {
                    if(temp.toString().equals(numArr[i])) {
                        result.append(i);
                        temp.setLength(0);
                        break;
                    }
                }
            }
        }
        return Integer.parseInt(result.toString());
    }
}