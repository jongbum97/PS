import java.util.*;

public class Main {
	
	static boolean[] visit;
	static int[][] graph;
	static int n, m, ans;
	

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		ans = -1;
		n = sc.nextInt();
		visit = new boolean[n+1];
		graph = new int[n+1][n+1];
		m = sc.nextInt();
		for (int i = 0; i < m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			graph[a][b]++;
			graph[b][a]++;
		}
		dfs(1);
		System.out.println(ans);
		
	}
	
	static void dfs(int v) {
		
		ans++;
		visit[v] = true;
		
		for (int i = 0; i < graph[v].length; i++) {
			if (graph[v][i]==1 && !visit[i]) {
				dfs(i);
			}
		}
		
	}
	
	

}
