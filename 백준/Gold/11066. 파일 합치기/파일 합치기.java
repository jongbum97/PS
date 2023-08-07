import java.io.*;
import java.util.*;

public class Main {

	static int K, dp[][], page[], sum[];

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			
			K = Integer.parseInt(br.readLine());
			page = new int[K];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < K; i++) {
				page[i] = Integer.parseInt(st.nextToken());
			}
			sum = new int[K+1];
			sum[1] = page[0];
			for (int i = 1; i < K; i++) {
				sum[i+1] = sum[i] + page[i];
			}
			dp = new int[K][K];
			bw.write(ddpp(0, K-1)+"\n");
			
			
		}
		bw.close();
		
		

	}

	static int ddpp(int x, int y) {
		
		if (x==y) return dp[x][x] = page[x];
		if (y-x==1) return dp[x][y] = page[x]+page[y];
		if(dp[x][y] != 0) return dp[x][y];
		
		dp[x][y] = Integer.MAX_VALUE;
		for (int k = x; k < y; k++) {
			if (k==x) {
				dp[x][y] = Math.min(dp[x][y], ddpp(x, k) + ddpp(k+1, y) + sum[y+1] - sum[x+1]);
			}else if (k==y-1) {
				dp[x][y] = Math.min(dp[x][y], ddpp(x, k) + ddpp(k+1, y) + sum[y] - sum[x]);
			}
			else {
				dp[x][y] = Math.min(dp[x][y], ddpp(x, k) + ddpp(k+1, y) + sum[y+1] - sum[x]);
			}
		}
		
		return dp[x][y];
		
		
	}
	

}
