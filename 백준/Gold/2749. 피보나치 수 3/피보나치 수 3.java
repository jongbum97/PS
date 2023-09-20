import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException{
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(System.in);
		BigInteger N = sc.nextBigInteger();
		int n = Integer.parseInt(N.mod(new BigInteger("1500000")).toString());
		int[] dp = new int[n+2];
		dp[1] = 0;
		dp[2] = 1;
		for (int i = 3; i <= n+1; i++) {
			dp[i] = (dp[i-1] + dp[i-2])%1000000;
		}
		
		System.out.println(dp[n+1]);
		
	}

}

