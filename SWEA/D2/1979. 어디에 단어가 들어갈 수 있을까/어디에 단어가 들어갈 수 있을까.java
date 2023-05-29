import java.util.*;

public class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			
			int N = sc.nextInt();
			int K = sc.nextInt();
			int[][] board = new int[N][N];
			for(int i=0; i<N; i++){
				for(int j=0; j<N; j++){
					board[i][j] = sc.nextInt();
				}
			}
			
			int ans = 0;
			for(int i=0; i<N; i++){
				int count = 0;
				for(int j=0; j<N ; j++){
					if(board[i][j]==1){
						count++;
					}
					if(board[i][j]==0 || j==N-1){
						if(count==K){
							ans++;
						}
						count = 0;
					}
				}
			}
			
			for(int i=0; i<N; i++){
				int count = 0;
				for(int j=0; j<N ; j++){
					if(board[j][i]==1){
						count++;
					}
					if(board[j][i]==0 || j==N-1){
						if(count==K){
							ans++;
						}
						count = 0;
					}
				}
			}
			
			
			
			
			System.out.println("#"+tc+" "+ans);
			

		}
	}
}
