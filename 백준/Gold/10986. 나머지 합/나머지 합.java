import java.io.*;
import java.util.*;

public class Main {

	static int N, M, nums[];
	static int dp[];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		nums = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++){
			nums[i] = Integer.parseInt(st.nextToken());
		}

		dp = new int[M];
		int sum = nums[0] % M;
		dp[sum]++;
		for(int i=1; i<N; i++){
			dp[sum = ((sum+nums[i])%M)]++;
		}
		long ans = 0;
		for(int i=0; i<M; i++){
			if(i%M == 0) {
				ans += dp[i];
			}
			ans += (long) dp[i] * (dp[i] - 1) / 2;
		}

		System.out.println(ans);

	}

}
