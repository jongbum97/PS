import java.util.*;

class Node{
	int x;
	int y;
	int cnt;
	boolean destroyed;
	Node(int x, int y, int cnt, boolean d) {
		this.x = x;
		this.y = y;
		this.cnt = cnt;
		this.destroyed = d;
	}
}

public class Main {

	static int N, M;
	static boolean[][] map;
	static boolean[][][] visit;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		map = new boolean[N][M];
		char[][] idx = new char[N][M];
		for (int i = 0; i < N; i++) {
			idx[i] = sc.next().toCharArray();
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (idx[i][j]=='1') {
					map[i][j] = true;
				}
			}
		}
		
		visit = new boolean[N][M][2];
		BFS();
		
		
	}
	
	static void BFS() {
		
		Queue<Node> queue = new LinkedList<>();
		queue.add(new Node(0, 0, 1, false));
		visit[0][0][0] = true;
		
		while (!queue.isEmpty()) {
			
			Node n = queue.remove();
			if (n.x==N-1 && n.y==M-1) {
				System.out.println(n.cnt);
				return;
			}
			
			for (int i = 0; i < 4; i++) {
				int x = n.x + dr[i];
				int y = n.y + dc[i];
				
				if (x<0 || x>N-1 || y<0 || y>M-1) {
					continue;
				}

				if (!map[x][y]) {
					if (!n.destroyed && !visit[x][y][0]) {
						queue.add(new Node(x, y, n.cnt+1, false));
						visit[x][y][0] = true;
					}else if (n.destroyed && !visit[x][y][1]) {
						queue.add(new Node(x, y, n.cnt+1, true));
						visit[x][y][1] = true;
					}
				}else{
					if (!n.destroyed) {
						queue.add(new Node(x, y, n.cnt+1, true));
						visit[x][y][1] = true;
					}
				}
				
				

			}
			
			
			
			
		}
		
		System.out.println(-1);
		
		
	}

}
