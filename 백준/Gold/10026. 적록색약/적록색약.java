import java.util.*;

class Node{
	int x;
	int y;
	Node(int x, int y){
		this.x = x;
		this.y = y;
	}
}

public class Main {
	
	static char[][] board;
	static boolean[][] visit; 
	static int N;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		board = new char[N][N];
		for (int i = 0; i < N; i++) {
			board[i] = sc.next().toCharArray();
		}
		
		System.out.println(nomal()+" "+abnomal());
		
		
	}
	
	static void BFS(int x, int y,  char c) {
		visit[x][y] = true;
		Queue<Node> queue = new LinkedList<>();
		queue.add(new Node(x, y));
		
		while (!queue.isEmpty()) {
			
			Node n = queue.remove();
			int a = n.x;
			int b = n.y;
			for (int i = 0; i < 4; i++) {
				int p = a + dr[i];
				int q = b + dc[i];
				if (p<0 || p>N-1 || q<0 || q>N-1) {
					continue;
				}else {
					if (board[p][q]==c && !visit[p][q]) {
						queue.add(new Node(p, q));
						visit[p][q] = true;
					}
				}
			}
			
		}
	}
	
	static int nomal() {
		return rCheck()+gCheck()+bCheck();
	}
	static int abnomal() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (board[i][j]=='G') {
					board[i][j]='R';
				}
			}
		}
		return rCheck()+bCheck();
	}
	
	
	
	static int rCheck() {
		visit = new boolean[N][N];
		int count = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (board[i][j]=='R' && !visit[i][j]) {
					BFS(i, j, 'R');
					count++;
				}
			}
		}
		return count;
	}
	
	static int gCheck() {
		visit = new boolean[N][N];
		int count = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (board[i][j]=='G' && !visit[i][j]) {
					BFS(i, j, 'G');
					count++;
				}
			}
		}
		return count;
	}
	
	static int bCheck() {
		visit = new boolean[N][N];
		int count = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (board[i][j]=='B' && !visit[i][j]) {
					BFS(i, j, 'B');
					count++;
				}
			}
		}
		return count;
	}
}
