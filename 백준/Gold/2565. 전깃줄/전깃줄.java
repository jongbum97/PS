import java.util.*;
import java.io.*;

public class Main {

	static int N, ans, idx;
	static int[][] line;
	static int[] dp;

	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		line = new int[501][2];
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			line[i][0] = Integer.parseInt(st.nextToken());
			line[i][1] = Integer.parseInt(st.nextToken());
		}
		for (int i = 0; i < N-1; i++) {
			for (int j = 1; j < N-i ; j++) {
				if (line[j][0]>line[j+1][0]) {
					int[] tmp = line[j].clone();
					line[j] = line[j+1];
					line[j+1] = tmp;
				}
			}
		}
		dp = new int[501];
		dp[1] = 1;
		for (int i = 2; i <=N ; i++) {
			dp[i] = 1;
			for (int j = 1; j < i; j++) {
				if (line[j][1] < line[i][1]) {
					dp[i] = Math.max(dp[i], dp[j]+1);
				}
			}
		}
		int ans = Integer.MIN_VALUE;
		for (int i = 1; i <= N; i++) {
			if (dp[i]>ans) {
				ans = dp[i];
			}
		}
		
		
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write((N-ans)+"\n");
		bw.close();
		
		
		
		
		
		
	
		
	}
	



}

