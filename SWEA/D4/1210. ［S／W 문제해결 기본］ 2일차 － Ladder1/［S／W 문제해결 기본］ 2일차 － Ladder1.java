import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

	static short[][] board;
	static boolean[][] visit;
	static boolean state;
	static int[] dr = {0, 0, 1};
	static int[] dc = {1, -1, 0};

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int tc = 1; tc <= 10; tc++) {
			int T = Integer.parseInt(br.readLine());
			state = false;
			board = new short[100][100];
			for (int i = 0; i < 100; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 100; j++) {
					board[i][j] = Short.parseShort(st.nextToken());
				}
			}
			
			for (int i = 0; i < 100; i++) {
				if (board[0][i]==1) {
					visit = new boolean[100][100];
					DFS(0,i);
					if (state) {
						System.out.println("#"+tc+" "+i);
						break;
					}
				}
			}

		}

	}

	static void DFS(int x, int y) {
		
		visit[x][y] = true;
		
		if (board[x][y]==2) {
			state = true;
			return;
		}
		
		for (int i = 0; i < 3; i++) {
			int a = x + dr[i];
			int b = y + dc[i];
			if (a>99 || b<0 || b>99) continue;
			if (board[a][b]==0 || visit[a][b]) continue;
			DFS(a, b);
			return;
		}
		
		
	}

}