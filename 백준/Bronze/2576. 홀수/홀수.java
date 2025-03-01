import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int result = 0;
		ArrayList<Integer> list = new ArrayList<>(); 
		
		for(int i = 0; i < 7; i++) {
			int a = sc.nextInt();
			if(a % 2 == 1) {
				list.add(a);
				result += a;
			}
		}
		if(list.isEmpty()) {
			System.out.println(-1);
		} else {
			Collections.sort(list);
		
			System.out.println(result);
			System.out.println(list.get(0));
		}
		
	}
}

