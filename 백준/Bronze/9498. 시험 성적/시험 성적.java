import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int note = sc.nextInt();
		
		if(note >= 90) {
			System.out.println("A");
		} else if(note >= 80) {
			System.out.println("B");
		} else if(note >= 70) {
			System.out.println("C");
		} else if(note >= 60) {
			System.out.println("D");
		} else {
			System.out.println("F");
		}

	}

}
