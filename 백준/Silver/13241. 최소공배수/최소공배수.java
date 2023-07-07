import java.util.*;

public class Main {
	public static void main(String args[]) throws Exception {

		Scanner sc = new Scanner(System.in);
		
		long A = sc.nextInt();
		long B = sc.nextInt();
		
		long ans = 0;
		for (long i = 1; i <= B; i++) {
			if ((A*i)%B==0) {
				ans = A*i;
				break;
			}
		}
		
		System.out.println(ans);

	}
}