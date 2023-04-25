import java.util.*;

public class Solution {
	
	static int N,M;
	static char[][] board;
	
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			M = sc.nextInt();
			board = new char[N][M];
			for(int i=0; i<N; i++){
				board[i] = sc.next().toCharArray();
			}
			
			if(WB() || BW()){
				System.out.println("#"+tc+" possible");
			}else {
				System.out.println("#"+tc+" impossible");
			}
			
			
			
		}

	}
	
	static boolean WB() {
		for(int i=0; i<N; i++){
			for(int j=0; j<M ; j++){
				if((i+j)%2==0 && board[i][j]=='#'){
					return false;
				}else if ((i+j)%2==1 && board[i][j]=='.') {
					return false;
				}
			}
		}
		return true;
	}
	
	
	static boolean BW() {
		for(int i=0; i<N; i++){
			for(int j=0; j<M ; j++){
				if((i+j)%2==0 && board[i][j]=='.'){
					return false;
				}else if ((i+j)%2==1 && board[i][j]=='#') {
					return false;
				}
			}
		}
		return true;
	}
	
	
	
	
	
	
	
	
}
