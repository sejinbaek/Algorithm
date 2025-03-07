import java.util.*;

public class Solution {
    public int solution(int n) {
        int answer = 0;
        
        String[] nArr = Integer.toString(n).split("");
        
        for(int i = 0; i < nArr.length; i++) {
            answer += Integer.parseInt(nArr[i]);
        }

        return answer;
    }
}