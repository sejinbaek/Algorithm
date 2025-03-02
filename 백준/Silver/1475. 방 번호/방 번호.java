import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String N = sc.nextLine();
	
		
		int[] cnt = new int[10];
		
		for(int i = 0; i < N.length(); i++) {
			int num = N.charAt(i) - '0';
			if(num == 6 || num == 9) {
				cnt[6]++;
			} else {
				cnt[num]++;
			}
		}
		
		cnt[6] = (cnt[6] + 1) / 2;
		
		int maxCount = 0;
		for(int i = 0; i < cnt.length; i++) {
			if(cnt[i] > maxCount) {
				maxCount = cnt[i];
			}
		}
		
		System.out.println(maxCount);
	}
}