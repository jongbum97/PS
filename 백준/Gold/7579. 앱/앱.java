import java.io.*;
import java.util.*;

public class Main {

	static int N, M, memory[], cost[], dp[][];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		memory = new int[N+1];
		cost = new int[N+1];
		dp = new int[N+1][10_001];
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<=N; i++){
			memory[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<=N; i++){
			cost[i] = Integer.parseInt(st.nextToken());
			dp[i][cost[i]] = memory[i];
		}

		for(int i=1; i<=N; i++){
			dp[i][0] = Math.max(dp[i][0], dp[i-1][0]);
			if(cost[i] == 0){
				dp[i][0] = Math.max(dp[i][0], dp[i-1][0] + memory[i]);
			}
			for(int j=1; j<10001; j++){
				dp[i][j] = Math.max(dp[i][j], Math.max(dp[i-1][j], dp[i][j-1]));
				if(j - cost[i] >= 0){
					dp[i][j] = Math.max(dp[i][j], dp[i-1][j-cost[i]] + memory[i]);
				}
			}
		}

		for(int i=0; i<=10001; i++){
			if(dp[N][i] >= M){
				System.out.println(i);
				return;
			}
		}


	}

}
