import java.util.*;

public class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {

			int N = sc.nextInt();
			int K = sc.nextInt();
			int[] score = new int[N];
			for(int i=0; i<N; i++){
				score[i] = sc.nextInt();
			}
			
			Arrays.sort(score);
			int ans = 0;
			for(int i=0; i<K; i++){
				ans += score[N-i-1];
			}
			
			System.out.println("#"+tc+" "+ans);
			
			
			
		}

	}
}
