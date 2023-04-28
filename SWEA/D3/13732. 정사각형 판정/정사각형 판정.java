import java.util.*;

public class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			
			int N = sc.nextInt();
			char[][] grid = new char[N][N];
			for(int i=0; i<N; i++){
				grid[i] = sc.next().toCharArray();
			}
			int min_r = N-1;
			int min_c = N-1;
			int max_r = 0;
			int max_c = 0;
			
			for(int i=0; i<N; i++){
				for(int j=0; j<N ; j++){
					if(grid[i][j]=='#' && i+j < min_r+min_c){
						min_r = i;
						min_c = j;
					}else if (grid[i][j]=='#' && i+j > max_r+max_c) {
						max_r = i;
						max_c = j;
					}
				}
			}
			
			String ans = " yes";
			outer: for(int i=0; i<N; i++){
				for(int j=0; j<N ; j++){
					if(grid[i][j]!='#' && i>=min_r && i<=max_r && j>=min_c && j<=max_c){
						ans = " no";
						break outer;
					}else if (grid[i][j]!='.' && (i<min_r || i>max_r) && (j<min_c || j>max_c)) {
						ans = " no";
						break outer;
					}
				}
			}
			if(max_r-min_r!=max_c-min_c){
				ans = " no";
			}
			
			System.out.println("#"+tc+ans);
		}
	}
}
