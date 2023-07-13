import java.math.BigInteger;
import java.util.*;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		M = Math.min(M, N-M);
		
		BigInteger ans = BigInteger.ONE;
		for (int i = N; i > N-M; i--) {
			ans = ans.multiply(BigInteger.valueOf(i));
		}
		for (int i = 2; i <= M ; i++) {
			ans = ans.divide(BigInteger.valueOf(i));
		}
		
		System.out.println(ans);

	}
	
}
