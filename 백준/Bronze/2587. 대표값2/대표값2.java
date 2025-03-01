import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int result = 0;
		ArrayList<Integer> list = new ArrayList<>(); 
		
		for(int i = 0; i < 5; i++) {
			int a = sc.nextInt();
			list.add(a);
			result += a;
		}
		result /= 5;
		
		Collections.sort(list);
		
		System.out.println(result);
		System.out.println(list.get(2));
		
	}
}