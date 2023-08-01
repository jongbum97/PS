import java.util.*;
import java.io.*;

public class Main {

	static int[][] map;
	static int[][][] dp;
	static boolean[][] visit;
	static int N;

	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N+1][N+1];
		dp = new int[3][N+1][N+1];
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		//가로 세로 대각선
		dp[0][1][2] = 1;
		for (int i = 1; i <= N; i++) {
			for (int j = 2; j <= N; j++) {
				if (map[i][j]==1) {
					continue;
				}
				if (i==1&&j==2) {
					continue;
				}
				dp[0][i][j] = dp[0][i][j-1] + dp[2][i][j-1];
				dp[1][i][j] = dp[1][i-1][j] + dp[2][i-1][j];
				if (map[i-1][j]==1 || map[i][j-1]==1) {
					continue;
				}
				dp[2][i][j] = dp[0][i-1][j-1] + dp[1][i-1][j-1] + dp[2][i-1][j-1];
			}
		}

		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(dp[0][N][N]+dp[1][N][N]+dp[2][N][N]+"\n");
		bw.close();
	}

	

}