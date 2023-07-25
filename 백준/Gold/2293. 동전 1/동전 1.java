import java.util.*;

public class Main {

	static int N, K;
	static int[] value;
	static int[][] ans;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		K = sc.nextInt();
		value = new int[K+1];
		ans = new int[N+1][K+1];
		for (int i = 1; i <= N; i++) {
			int a = sc.nextInt();
			if (a>K) {
				continue;
			}
			value[i] = a;
			ans[i][a]++;
		}
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= K; j++) {
				if (j-value[i]<0) {
					ans[i][j] =  ans[i-1][j];
					continue;
				}
				ans[i][j] += ans[i][j-value[i]] + ans[i-1][j];
			}
		}
		System.out.println(ans[N][K]);
		
		
		
	}

	

}
