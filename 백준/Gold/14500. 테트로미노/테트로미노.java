import java.io.*;
import java.util.*;

public class Main {

	static int N, M, dr[]={-1,1,0,0},dc[]= {0,0,-1,1}, map[][], max;
	static boolean visit[][];

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		visit = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				visit[i][j] = true;
				DFS(i, j, 1, map[i][j]);
				visit[i][j] = false;
			}
		}
		System.out.println(max);
		

	}
	
	static void DFS(int x, int y, int count, int sum){
		
		if (count==4) {
			max = Math.max(max, sum);
			return;
		}
		
		for (int i = 0; i < 4; i++) {
			int a = x + dr[i];
			int b = y + dc[i];
			if(a<0||a>N-1||b<0||b>M-1) continue;
			if(visit[a][b]) continue;
			if (count==2) {
				visit[a][b] = true;
				DFS(x, y, count +1 , sum + map[a][b]);
				visit[a][b] = false;
			}
			visit[a][b] = true;
			DFS(a, b, count +1 , sum + map[a][b]);
			visit[a][b] = false;
			
		}
		
		
		
	}

}
