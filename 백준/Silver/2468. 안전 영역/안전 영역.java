import java.util.*;

class Node{
	int x;
	int y;
	Node(int x, int y){
		this.x = x;
		this.y = y;
	}
}

public class Main{
	
	static int N, ans;
	static boolean[][] visit;
	static int[][] area;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		visit = new boolean[N][N];
		area = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				area[i][j] = sc.nextInt();
			}
		}
		ans = 1;
		for (int k = 1; k <= 100; k++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (area[i][j]<=k) {
						visit[i][j] = true;
					}else {
						visit[i][j] = false;
					}
				}
			}
			int count = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (!visit[i][j]) {
						DFS(i, j);
						count++;
					}
				}
			}
			ans = Math.max(ans, count);
			
		}
		System.out.println(ans);
		
	}
	
	static void DFS(int x, int y) {
		visit[x][y] = true;
		Queue<Node> queue = new LinkedList<>();
		Node n = new Node(x, y);
		queue.add(n);
		
		while(!queue.isEmpty()) {
			Node nn = queue.remove();
			int p = nn.x;
			int q = nn.y;
			for (int i = 0; i < 4; i++) {
				int a = p+dr[i];
				int b = q+dc[i];
				if (a<0 || a>N-1 || b<0 || b>N-1) {
					continue;
				}else {
					if (!visit[a][b]) {
						Node nnn = new Node(a, b);
						queue.add(nnn);
						visit[a][b] = true;
					}
				}
			}
			
			
		}
	}
	
	
	
	
}
