import java.util.*;
class Solution {
    public long solution(long n) {
        long answer = 0;
        double sqrt = Math.sqrt(n);
        if(sqrt == (long) sqrt) {
            answer = (long) Math.pow((long)sqrt + 1, 2);
        } else {
            answer = -1;
        }
        return answer;
    }
}