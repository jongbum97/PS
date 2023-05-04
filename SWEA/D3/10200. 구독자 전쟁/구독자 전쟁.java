import java.util.*;

public class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			
			int N = sc.nextInt();
			int Ps = sc.nextInt();
			int Ts = sc.nextInt();
			
			System.out.println("#"+tc+" "+Math.min(Ps, Ts)+" "+((N-Ps-Ts>0)? 0:Ps+Ts-N));
		}
	}
}
