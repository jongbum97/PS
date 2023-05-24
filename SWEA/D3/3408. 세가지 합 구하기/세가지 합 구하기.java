import java.util.*;

public class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {

			long N = sc.nextLong();
			
			long s1 = N*(N+1)/2;
			long s2 = N*N;
			long s3 = N*(N+1);
			

			System.out.println("#"+tc+" "+s1+" "+s2+" "+s3);

		}
	}
}
