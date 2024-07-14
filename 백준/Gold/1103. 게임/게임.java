import java.io.*;
import java.util.*;

public class Main {

	static int N, M, map[][], ans, dp[][];
	static boolean visit[][];
	static final int[] dr = {-1, 0, 1, 0}, dc = {0, 1, 0, -1};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);
		map = new int[N][M];
		for(int i=0; i<N; i++){
			String s = br.readLine();
			for(int j=0; j<M; j++){
				map[i][j] = s.charAt(j) - '0';
			}
		}

		visit = new boolean[N][M];
		dp = new int[N][M];
		for(int i=0; i<N; i++){
			Arrays.fill(dp[i], -1);
		}
		dfs(0, 0, 1);

		System.out.println(ans);

	}

	static void dfs(int x, int y, int cnt){

		if(visit[x][y] || ans == -1){
			ans = -1;
			return;
		}
		visit[x][y] = true;
		dp[x][y] = cnt;

		for(int i=0; i<4; i++){
			int a = x + dr[i]*map[x][y];
			int b = y + dc[i]*map[x][y];
			if(a<0 || a>N-1 || b<0 || b> M-1) continue;
			if(map[a][b] == 24) continue;
			if(dp[a][b] > cnt) continue;
			dfs(a, b, cnt+1);
		}

		visit[x][y] = false;
		if(ans != -1){
			ans = Math.max(ans, cnt);
		}
	}

}
