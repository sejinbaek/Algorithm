import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        
        ArrayDeque<Character> queue = new ArrayDeque<>();
        //이미 나온 문자와 인덱스를 저장하는 맵
        Map<Character, Integer> map = new HashMap<>();
        
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            queue.offer(c);
            
            if(map.containsKey(c)) {
                answer[i] = i - map.get(c);
            } else {
                answer[i] = -1;
            }
            
            map.put(c, i);
        }

        return answer;
    }
}