import java.util.*;

class Node{
	int x;
	int y;
	
	public Node(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Main {
	
	static int N, M,  cnt;
	static boolean[][] visit;
	static int[][] dis;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		visit = new boolean[N][M];
		dis = new int[N][M];
		String[][] s = new String[N][M];
		for (int i = 0; i < N; i++) {
			s[i] = sc.next().split("");
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (s[i][j].equals("1")) {
					visit[i][j] = true;
				}
			}
		}
		BFS(0,0);
		System.out.println(dis[N-1][M-1]+1);
		
	}
	
	static void BFS(int x, int y) {
		
		visit[x][y] = false;
		
		Queue<Node> queue = new LinkedList<>();
		Node n = new Node(x, y);
		queue.add(n);
		
		while (!queue.isEmpty()) {
			
			Node a = queue.remove();
			int p = a.x;
			int q = a.y;

			
			if (p==N-1 && q==M-1) {
				break;
			}
			
			for (int i = 0; i < 4; i++) {
				int d = p + dr[i];
				int c = q + dc[i];
				if (d<0 || d>N-1 || c<0 || c>M-1) {
					continue;
				}else {
					if (visit[d][c]) {
						Node b = new Node(d,c);
						queue.add(b);
						visit[d][c] = false;
						dis[d][c] = dis[p][q] + 1;
					}
				}
			}

		}
		
	}

	
	
}
