import java.util.*;

public class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {

			int L = sc.nextInt();
			int U = sc.nextInt();
			int X = sc.nextInt();
			
			int ans = (X<L)? L-X:(X<U)? 0:-1;
			

			System.out.println("#"+tc+" "+ans);

		}
	}
}
