import java.util.*;
import java.math.BigInteger;

public class Main {
	public static void main(String args[]) throws Exception {

		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		BigInteger ans = BigInteger.ZERO;
		
		for (int i = 1; i <= n/2+1; i++) {
			BigInteger b1 = factorial(n-i+1);
			BigInteger b2 = factorial(n-2*i+2);
			BigInteger b3 = factorial(i-1);
			
			ans = ans.add(b1.divide(b2.multiply(b3)));
			
		}
		
		
		System.out.println(ans.mod(BigInteger.valueOf(10007)));

	}
	
	public static BigInteger factorial(int n) {
		
		
		BigInteger b1 = BigInteger.ONE;
		for (int i = 2; i <= n; i++) {
			b1 = b1.multiply(BigInteger.valueOf(i));
		}
		return b1;
		
	}
	
}