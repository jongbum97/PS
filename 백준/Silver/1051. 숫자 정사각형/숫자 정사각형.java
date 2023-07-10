import java.util.*;

public class Main {
	public static void main(String args[]) throws Exception {

		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[][] nums = new int[N][M];
		for (int i = 0; i < N; i++) {
			String[] s = new String[M];
			s = sc.next().split("");
			for (int j = 0; j < M; j++) {
				nums[i][j] = Integer.parseInt(s[j]);
			}
		}
		
		int ans = 0;
		int n = Math.min(N, M);
		while(n>0) {
			
			outer : for (int i = 0; i <= N-n; i++) {
				for (int j = 0; j <= M-n; j++) {
					if (nums[i][j]==nums[i+n-1][j] && nums[i][j]==nums[i][j+n-1] && nums[i][j]==nums[i+n-1][j+n-1]) {
						ans = n*n;
						break outer;
					}
				}
			}

			if (ans == 0) {
				n--;
			}else {
				break;
			}
			
		}
		
		System.out.println(ans);

	}
}