import java.io.*;
import java.util.*;

public class Main {

	static int N, dr[] = { -1, 0, 1, 0 }, dc[] = { 0, 1, 0, -1 }, map[][], dp[][];

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		dp = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(dp[i][j]==0) {
					DFS(i, j);
				}
			}
		}
		int ans = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				ans = Math.max(ans, dp[i][j]);
			}
		}
		bw.write(ans+"\n");
		bw.close();

	}

	static int DFS(int x, int y) {
//		for (int i = 0; i < N; i++) {
//			System.out.println(Arrays.toString(dp[i]));
//		}System.out.println();
		if (dp[x][y]!=0) {
			return dp[x][y];
		}
		dp[x][y] = 1;
		for (int i = 0; i < 4; i++) {
			int a = x + dr[i];
			int b = y + dc[i];
			if(a<0||a>N-1||b<0||b>N-1) continue;
			if(map[x][y]<=map[a][b]) continue;
			dp[x][y] = Math.max(dp[x][y], DFS(a, b)+1);
		}
		return dp[x][y];
	}

}