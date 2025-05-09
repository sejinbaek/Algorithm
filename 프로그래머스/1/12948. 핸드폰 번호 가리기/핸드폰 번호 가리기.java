class Solution {
    public String solution(String phone_number) {
        String answer = "";
        for(int i = 0; i < phone_number.length() - 4; i++) {
            answer += "*";
        }
        String phone_number_b = phone_number.substring(phone_number.length() -4);
        return answer += phone_number_b;
    }
}