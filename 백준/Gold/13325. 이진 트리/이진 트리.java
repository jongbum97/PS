import java.io.*;
import java.util.*;

public class Main {

	static int N, dp[][], line[], ans, max;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		line = new int[(1<<(N+1))-2];
		for (int i = 0; i < line.length; i++) {
			line[i] = Integer.parseInt(st.nextToken());
			ans += line[i];
		}
		dp = new int[N+1][];
		dp[0] = new int[1];
		dp[0][0] = 0;
		int c = 0;
		for (int i = 1; i <= N; i++) {
			dp[i] = new int[1<<i];
			for (int j = 0; j < 1<<i; j++) {
				dp[i][j] = dp[i-1][j/2] + line[c++];
			}
		}
		for (int j = 0; j < 1<<N ; j++) {
			max = Math.max(max, dp[N][j]);
		}
		
		tree();
		
		System.out.println(ans);
		
	}

	static void tree() {
		
		for (int i = N-1; i >= 0 ; i--) {
			
			int p = 1<<i;
			int q = (1<<N)/p;
			
			for (int j = 0; j < q; j++) {
				int m = 0;
				for (int k = j*p; k < (j+1)*p; k++) {
					m = Math.max(m, dp[N][k]);
				}
				int t = max - m;
				ans += t;
				for (int k = j*p; k < (j+1)*p; k++) {
					dp[N][k] += t;
				}
			}
		}
	}
	
	
	

}