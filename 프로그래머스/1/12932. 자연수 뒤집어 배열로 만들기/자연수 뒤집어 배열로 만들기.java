import java.util.*;
class Solution {
    public List solution(long n) {
        ArrayList<Integer> answer = new ArrayList<>();

        String[] n_arr = String.valueOf(n).split("");
        for(int i = 0; i < n_arr.length; i++) {
            int num = Integer.parseInt(n_arr[i]);
            answer.add(num);
        }
        Collections.reverse(answer);
        return answer;
    }
}