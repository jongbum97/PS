import java.util.*;

public class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {

			long N = sc.nextInt();
			long A = sc.nextInt();
			long B = sc.nextInt();
			
			long min = 999999999999999999l;
			
			for(long R=1; R<=Math.sqrt(N); R++){
				for(long C=1; C<=N/R; C++){
					min = Math.min(min, (A*Math.abs(R-C)+B*(N-R*C)));
				}
			}

			System.out.println("#"+tc+" "+min);

		}
	}
}
