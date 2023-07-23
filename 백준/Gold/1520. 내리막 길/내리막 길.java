import java.util.*;

public class Main {

	static int N, M, ans;
	static int[][] map, dp;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N][M];
		dp = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				dp[i][j] = -1;
			}
		}
		
		
		System.out.println(DFS(0, 0));
		
		
	}
	
	static int DFS(int x, int y) {
		
		if (x==N-1 && y==M-1) {
			return 1;
		}
		if (dp[x][y] != -1) {
			return dp[x][y];
		}
		
		
		dp[x][y] = 0;
		for (int i = 0; i < 4; i++) {
			
			int a = x + dr[i];
			int b = y + dc[i];
			
			if (a<0 || a>N-1 || b<0 || b>M-1) {
				continue;
			}	
			
			if (map[x][y] > map[a][b]) {
				dp[x][y] += DFS(a, b);
			}
			
			
		}
		
		return dp[x][y];
	}
	
}
