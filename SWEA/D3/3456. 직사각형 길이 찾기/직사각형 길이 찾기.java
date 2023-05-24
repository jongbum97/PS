import java.util.*;

public class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {

			int[] square = new int[3];
			for (int i = 0; i < 3; i++) {
				square[i] = sc.nextInt();
			}

			int ans;
			if (square[0] == square[1]) {
				ans = square[2];
			}else if (square[2] == square[1]) {
				ans = square[0];
			}else {
				ans = square[1];
			}

			System.out.println("#"+tc+" "+ans);

		}
	}
}
