import java.util.*;

public class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			float N = sc.nextInt();
			int D = sc.nextInt();
			System.out.println("#"+tc+" "+(int)Math.ceil(N/(2*D+1)));
		}
	}
}