import java.util.*;

public class Main {

	static int R, C, ans;
	static int[][] board;
	static boolean[] check;
	static boolean[][] visit;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		R = sc.nextInt();
		C = sc.nextInt();
		board = new int[R][C];
		check = new boolean[26];
		visit = new boolean[R][C];
		char[][] s = new char[R][C];
		for (int i = 0; i < R; i++) {
			s[i] = sc.next().toCharArray();
		}
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				board[i][j] = s[i][j]-'A';
			}
		}

		DFS(0, 0, 1);
		System.out.println(ans);
	}

	static void DFS(int x, int y, int d) {
		ans = Math.max(d, ans);
		visit[x][y] = true;
		check[board[x][y]] = true;
		
		for (int i = 0; i < 4; i++) {
			int a = x + dr[i];
			int b = y + dc[i];
			if (a<0 || a>R-1 || b<0 || b>C-1) {
				continue;
			}
			if (visit[a][b]) {
				continue;
			}
			if (check[board[a][b]]) {
				continue;
			}
			DFS(a, b, d+1);
			
		}
		
		visit[x][y] = false;
		check[board[x][y]] = false;
		
	}
}
