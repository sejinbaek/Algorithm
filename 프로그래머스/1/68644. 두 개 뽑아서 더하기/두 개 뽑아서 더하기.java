import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        ArrayList<Integer> list = new ArrayList<>();
        
        // 서로 다른 두 개의 수를 더한다.
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                list.add(numbers[i] + numbers[j]);
            }
        }
        
        // 중복 제거 + 오름차순 정렬 + int 배열로 변환
        return list.stream()
                   .distinct()
                   .sorted()
                   .mapToInt(Integer::intValue)
                   .toArray();
    }
}
