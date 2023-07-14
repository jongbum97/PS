import java.util.*;

public class Solution {
	
	static int[] dr = {0, 1, 0, -1};
	static int[] dc = {1, 0, -1, 0};
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			
			int N = sc.nextInt();
			int[][] board = new int[N][N];
			int r = 0;
			int c = 0;
			int x = 0;
			for (int i = 1; i <= N*N; i++) {
				board[r][c] = i;
				if (c+dc[x]>N-1 || r+dr[x]<0 || r+dr[x]>N-1 || c+dc[x]<0 || board[r+dr[x]][c+dc[x]]!=0) {
					x++;
					x %= 4;
					
				}
				r = r+dr[x];
				c = c+dc[x];
			}
			
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					sb.append(board[i][j]);
					sb.append(" ");
				}
				sb.append("\n");
			}
			
			
			
			
			System.out.print("#"+tc+"\n"+sb);
			
		}
		
		
	}


}
