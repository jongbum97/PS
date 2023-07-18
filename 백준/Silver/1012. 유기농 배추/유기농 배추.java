import java.util.*;

public class Main {
	
	static int M, N, K, ans;
	static boolean[][] visit;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			ans = 0;
			M = sc.nextInt();
			N = sc.nextInt();
			K = sc.nextInt();
			visit = new boolean[N][M];
			for (int i = 0; i < K; i++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				visit[b][a]=true;
			}
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (visit[i][j]) {
						ans++;
						DFS(i, j);
					}
				}
			}
			
			System.out.println(ans);
			
			
			
			
		}
		
		
	}
	
	static void DFS(int x, int y) {
		visit[x][y] = false;
		
		for (int i = 0; i < 4; i++) {
			int r = x + dr[i];
			int c = y + dc[i];
			if (r<0 || r>N-1 || c<0 || c>M-1) {
				continue;
			}else {
				if (visit[r][c]) {
					DFS(r, c);
				}
			}
		}
	}
	
	
	
}
