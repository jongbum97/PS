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
		dp[0][0] = 1;
		for(int i=0; i<M*N; i++){
			bellmanFord();
		}

		int[][] tmp = new int[N][];
		for(int i=0; i<N; i++){
			tmp[i] = dp[i].clone();
		}
		bellmanFord();

		for(int i=0; i<N; i++){
			for(int j=0; j<M; j++){
				if(tmp[i][j] != dp[i][j]){
					System.out.println(-1);
					return;
				}
				ans = Math.max(ans, dp[i][j]);
			}
		}

		System.out.println(ans);

	}

	static void bellmanFord(){

		for(int i=0; i<N; i++){
			for(int j=0; j<M; j++){
				if(dp[i][j] == -1) continue;
				for(int k=0; k<4; k++){
					int a = i + dr[k]*map[i][j];
					int b = j + dc[k]*map[i][j];
					if(a<0 || a>N-1 || b<0 || b>M-1) continue;
					if(map[a][b] == 24) continue;
					dp[a][b] = Math.max(dp[a][b], dp[i][j] + 1);
				}
			}
		}

	}

}
