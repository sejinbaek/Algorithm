class Solution {
    public int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;
        // 0보다 작으면 음수
        // 0보다 크면 양수
        for(int i = 0; i < signs.length; i++) {
            if(signs[i] == true) {
                answer += absolutes[i];
            } else {
                answer -= absolutes[i];
            }
        }
        return answer;
    }
}