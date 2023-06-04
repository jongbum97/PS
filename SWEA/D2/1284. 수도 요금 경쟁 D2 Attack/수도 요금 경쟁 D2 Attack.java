import java.util.*;

public class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			int P = sc.nextInt();
			int Q = sc.nextInt();
			int R = sc.nextInt();
			int S = sc.nextInt();
			int W = sc.nextInt();
			
			int A = W*P;
			int B = ((W<=R)? Q:((W-R)*S)+Q);
			
			
			
			System.out.println("#"+tc+" "+Math.min(A, B));

		}
	}
}
