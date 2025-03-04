import java.util.ArrayList;

class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        
        ArrayList<Long> list = new ArrayList<>();

        for(int i = 0; i <= t.length(); i++) {
            if(t.length() - i < p.length()) break;
            else {
                list.add(Long.parseLong(t.substring(i, i + p.length())));
            }
        }
        
        for(int j = 0; j < list.size(); j++) {
            if(list.get(j) <= Long.parseLong(p)) {
                answer++;
            }
        }
        
        return answer;
    }
}