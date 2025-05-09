class Solution {
    public String solution(String s) {
        String answer = "";
        // 홀수 - 가운데 글자 뽑기
        // 짝수 - 가운데 두 글자 뽑기
        if(s.length() % 2 == 0) {
            answer = s.substring(s.length() / 2 - 1, s.length() / 2 + 1);
        } else {
            answer = String.valueOf(s.charAt(s.length() / 2));
        }
        return answer;
    }
}