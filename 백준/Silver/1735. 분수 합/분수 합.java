import java.util.*;

public class Main {
	
	static int A, B;
	
	
	
	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		int d = sc.nextInt();
		
		A = a*d+b*c;
		B = b*d;
		
		divide();
		System.out.println(A+" "+B);
		
		
	}
	
	
	public static void divide() {
		int m = Math.min(A, B);
		for (int i = 2; i <= m; i++) {
			if (A%i==0 && B%i==0) {
				A /= i;
				B /= i;
				divide();
				break;
			}
		}
	}
	
}
