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
	static int[][] board;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		M = sc.nextInt();
		N = sc.nextInt();
		board = new int[N][M];
		Queue<Node> queue = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				int a = sc.nextInt();
				board[i][j] = a;
				if (a==1) {
					Node n = new Node(i, j);
					queue.add(n);
				}
			}
		}
		
		while (!queue.isEmpty()) {
			
			Node n = queue.remove();
			int x = n.x;
			int y = n.y;
			
			for (int i = 0; i < 4; i++) {
				int a = x + dr[i];
				int b = y + dc[i];
				if (a<0 || a>N-1 || b<0 || b>M-1) {
					continue;
				}else {
					if (board[a][b]==0) {
						Node nn = new Node(a, b);
						queue.add(nn);
						board[a][b] = board[x][y]+1;
					}
				}
			}
			
		}

		
		outer : for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (board[i][j]==0) {
					ans = 0;
					break outer;
				}else {
					ans = Math.max(ans, board[i][j]);
				}
			}
		}
		
		System.out.println(ans-1);
		
		
		
	}

	
	
}
