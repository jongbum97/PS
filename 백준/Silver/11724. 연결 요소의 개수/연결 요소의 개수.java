import java.util.*;

public class Main {
	
	static int N, M, ans;
	static boolean[] visit;
	static boolean[][] tree;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
			ans = 0;
			N = sc.nextInt();
			M = sc.nextInt();
			visit = new boolean[N+1];
			tree = new boolean[N+1][N+1];
			for (int i = 0; i < M; i++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				tree[a][b] = true;
				tree[b][a] = true;
			}
			
			for (int i = 1; i <= N; i++) {
					if (!visit[i]) {
						ans++;
						DFS(i);
					}
			}
			
			System.out.println(ans);
			
		
		
	}
	
	static void DFS(int x) {
		visit[x] = true;
		
		for (int i = 1; i <= N; i++) {
			if (!visit[i] && tree[x][i]) {
				DFS(i);
			}
		}
		
	}
	
	
	
}
