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

	static int N, M, ans;
	static int[][] map, map2;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		for (int i = 0; i < N; i++) {
			Arrays.toString(map[i]);
		}
		
		wall(0);
		
		System.out.println(ans);
		
		
	}

	static void wall(int n) {
		if (n>2) {
			map2 = new int[N][M];
			for (int i = 0; i < N; i++) {
				map2[i] = map[i].clone();
			}
			ans = Math.max(ans, BFS());
			return;
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j]==0) {
					map[i][j]=1;
					wall(n+1);
					map[i][j]=0;
				}
			}
		}
	}
	
	static int BFS() {
		Queue<Node> queue = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map2[i][j]==2) {
					Node n = new Node(i, j);
					queue.add(n);
				}
			}
		}
		
		while (!queue.isEmpty()) {
			
			Node n = queue.poll();
			int x = n.x;
			int y = n.y;
			for (int i = 0; i < 4; i++) {
				int a = x + dr[i];
				int b = y + dc[i];
				if (a<0 || a>N-1 || b<0 || b>M-1) {
					continue;
				}else {
					if (map2[a][b]==0) {
						Node nn = new Node(a, b);
						queue.add(nn);
						map2[a][b] = 2;
					}
				}
			}
			
		}
		int count = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map2[i][j] == 0) {
					count++;
				}
			}
		}
		return count;
		
	}
	
	
}
