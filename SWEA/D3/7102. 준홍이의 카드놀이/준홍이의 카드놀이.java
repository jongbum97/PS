import java.util.*;

public class Solution {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int tc = 0; tc < T; tc++) {
			int N = sc.nextInt();
			int M = sc.nextInt();

			// 풀이시작
			int[] nums = new int[N + M + 1];
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= M; j++) {
					nums[i + j]++;
				}
			}
			int max = 0;
			for(int i=0; i<N+M+1; i++){
				max = Math.max(max, nums[i]);
			}
			int[] ans = new int[N + M + 1];
			
			System.out.print("#" + (tc + 1) + " ");
			for (int i = 0; i <= N + M; i++) {
				if (max == nums[i]) {
					System.out.print(i+" ");
				}
			}
			System.out.println();
		}
	}

}