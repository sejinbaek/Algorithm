import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int[] NArr = new int[N];
		
		for(int i = 0; i < N; i++) {
			NArr[i] = sc.nextInt();
		}
		
		int V = sc.nextInt();
		
		int cnt = 0;
		
		for(int num : NArr) {
			if(num == V) {
				cnt++;
			}
		}
		
		System.out.println(cnt);
		
	}
}