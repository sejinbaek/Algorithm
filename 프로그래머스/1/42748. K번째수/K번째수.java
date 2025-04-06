import java.util.*;

class Solution {
    public ArrayList solution(int[] array, int[][] commands) {
        ArrayList<Integer> answer = new ArrayList<>();
        
        for(int i = 0; i < commands.length; i++) {
            int startIndex = commands[i][0] - 1;
            int endIndex = commands[i][1];
            int k = commands[i][2] - 1;
            
            //배열 자르기
            int[] arr2 = Arrays.copyOfRange(array, startIndex, endIndex);
            
            //자른 배열 정렬하기
            Arrays.sort(arr2);
            answer.add(arr2[k]);
                
        }
        
        return answer;
    }
}