import java.util.*;

public class Main {
	
	static boolean board[][];
	static int N,M;
	

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		board = new boolean[N][6*N/3-1];

		star(0,0,N);
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j]) {
					sb.append("*");
				}else {
					sb.append(" ");
				}
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	}

	static void star(int x, int y, int n) {
		
		if (n==3) {
			board[x][y+2] = true;
			board[x+1][y+1] = true; board[x+1][y+3] = true;
			for (int i = 0; i < 5; i++) {
				board[x+2][y+i] = true;
			}
		}else {
			int b = 6*n/3-1;
			star(x, y+b/4+1, n/2);
			star(x+n/2, y, n/2);
			star(x+n/2, y+b/2+1, n/2);
			
		}
		
		
	}
	

}
