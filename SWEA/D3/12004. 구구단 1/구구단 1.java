import java.util.*;

public class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {

			int N = sc.nextInt();

			String ans = " No";
			outer:for (int i = 1; i < 10; i++) {
				for (int j = 1; j < 10; j++) {
					if (i * j == N) {
						ans = " Yes";
						break outer;
					}
				}
			}
			
			System.out.println("#"+tc+ans);

		}
	}
}
