import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String s = sc.nextLine();
		
		char[] arr = new char[26];
		int[] count = new int[26];
		
		for(int i = 0; i < arr.length; i++) {
			arr[i] = (char) (i + 97);
		}
		
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < s.length(); j++) {
				if(arr[i] == s.charAt(j)) {
					count[i]++;
				}
			}
		}
		
		for(int i = 0; i < arr.length; i++) {
			System.out.print(count[i] + " ");
		}	
	}
}