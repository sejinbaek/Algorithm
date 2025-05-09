import java.util.List;
import java.util.Arrays;

class Solution {
    public int solution(int[] numbers) {
        int answer = 0;
        Integer[] integerArray = Arrays.stream(numbers).boxed().toArray(Integer[]::new);
        List<Integer> list = Arrays.asList(integerArray);
        for(int i = 0; i < 10 ;i++) {
            if(!list.contains(i)) {
                answer += i;
            }
        }
        // 정렬을 한다.
        // 정렬한 배열 요소가 해당 인덱스와 다르다면
        // answer += i
        
        return answer;
    }
}