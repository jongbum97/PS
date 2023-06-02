import java.util.*;

public class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		int[][] tri = new int[10][];
		for(int i=0; i<10; i++){
			tri[i] = new int[i+1];
			tri[i][0]=1;
			tri[i][i]=1;
			for(int j=1; j<i ; j++){
				
				tri[i][j] = tri[i-1][j-1]+tri[i-1][j];
				
			}
		}
		
		for (int tc = 1; tc <= T; tc++) {
			
			int n = sc.nextInt();
			
			
			System.out.println("#"+tc);
			for(int i=0; i<n; i++){
				for (int e : tri[i]) {
					System.out.print(e+" ");
				}
				System.out.println();
			}
			
			

		}
	}
}
