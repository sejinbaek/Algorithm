import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public int[] solution(int[] answers) {
        
        int[][] pattern = {
            {1,2,3,4,5},
            {2,1,2,3,2,4,2,5},
            {3,3,1,1,2,2,4,4,5,5}
        };
        //수포자들의 점수를 저장할 배열
        int[] scores = new int[3];
        
        //점수를 체크하고 점수 추가하는 로직 작성하기
        for(int i = 0; i < answers.length; i++) {
            for(int j = 0; j < pattern.length; j++) {
                if(answers[i] == pattern[j][i % pattern[j].length]) {
                    scores[j]++;
                }
            }
        }
        //maxscore 구하고
        //maxscore와 같거나 크면 answer에 score 인덱스를 추가하기
        int maxScore = Arrays.stream(scores).max().getAsInt();
        ArrayList<Integer> answer = new ArrayList<>();
        for(int i = 0; i < scores.length; i++) {
            if(maxScore == scores[i]) {
                answer.add(i+1);
            }
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}