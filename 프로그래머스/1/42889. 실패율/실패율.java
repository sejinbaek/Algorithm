import java.util.HashMap;

class Solution {
    public int[] solution(int N, int[] stages) {
        //1. 스테이지별 도전자 수를 구한다.
        int[] challenger = new int[N + 2];
        for(int i = 0; i < stages.length; i++) {
            challenger[stages[i]] += 1;
        }
        
        //2. 스테이지별 실패한 사용자 수를 계산한다.
        HashMap<Integer, Double> fails = new HashMap<>();
        double total = stages.length;
        
        //3. 각 스테이지를 순회하며, 실패율 계산
        for(int i = 1; i <= N; i++) {
            if(challenger[i] == 0) { //4. 도전한 사람이 없는 경우
                fails.put(i, 0.); //실패율은 0
            }
            else {
                fails.put(i, challenger[i] / total); //5. 실패율을 구한다.
                total -= challenger[i]; //6. 다음 스테이지 실패율을 구하기 위해 현재 스테이지의 인원을 뺀다.
            }
        }
        //7. 실패율이 높은 스테이지부터 내림차순으로 정렬한다.
        return fails.entrySet().stream().sorted((o1, o2) -> Double.compare(o2.getValue(), o1.getValue())).mapToInt(HashMap.Entry::getKey).toArray();
    }
}