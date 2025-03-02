import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();
		
		int[] count = new int[10]; //0 - 9까지 개수만큼 크기 지정
		
		String sum = Integer.toString(A * B * C); //A, B, C의 곱
		
		for(int i = 0; i < sum.length(); i++) {
			int num = sum.charAt(i) - '0';
			count[num]++;
		}
		
		for(int i = 0; i < count.length; i++) {
			System.out.println(count[i]);
		}
	}
}

