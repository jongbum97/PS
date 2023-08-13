import java.io.*;
import java.util.*;

public class Main {

	static int N, M, C ,map[][], dr[]={-1,0,1,0}, dc[]={0,1,0,-1}, ans, count;
	static boolean visit[][];

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j]==2) C++;
			}
		}
		ans = Integer.MAX_VALUE;
		del(0, 0, 0);
		System.out.println(ans);
		
	}
	
	static void BFS() {
		
		Queue<Node> q = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j]==2) q.add(new Node(i, j, 0));
			}
		}
		
		while (!q.isEmpty()) {
			
			Node n = q.remove();
			
			if (map[n.x][n.y]==1) {
				count += n.d;
			}
			
			for (int i = 0; i < 4; i++) {
				int a = n.x + dr[i];
				int b = n.y + dc[i];
				if(a<0||a>N-1||b<0||b>N-1) continue;
				if(visit[a][b]) continue;
				q.add(new Node(a, b, n.d+1));
				visit[a][b] = true;
			}
			
			
		}
		
		
		
		
	}
	
	
	
	static void del(int n, int x, int y) {
		
		if(n==C-M) {
			visit = new boolean[N][N];
			count = 0;
			BFS();
			ans = Math.min(ans, count);
			return;
		}
		
		for (int i = x; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(i==x && j<y) continue;
				if (map[i][j]==2) {
					map[i][j] = 0;
					del(n+1, i, j+1);
					map[i][j] = 2;
				}
			}
		}
		
	}
	
	
}
class Node{
	int x;
	int y;
	int d;
	Node(int x, int y, int d){
		this.x = x;
		this.y = y;
		this.d = d;
	}
}