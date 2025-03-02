import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int[] nArr = new int[n];
		
		for(int i = 0; i < n; i++) {
			nArr[i] = sc.nextInt();
		}
		
		int x = sc.nextInt();
		
		int cnt = 0;
		
		Set<Integer> set = new HashSet<>();
		
		for(int num : nArr) {
			int target = x - num;
			if(set.contains(target)) {
				cnt++;
			}
			set.add(num);
		}
		
		System.out.println(cnt);
		
	}
}