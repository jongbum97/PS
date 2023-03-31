import java.util.*;

public class Solution {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int ans = 0;
			String[][] farm = new String[N][N];
			int[][] farm2 = new int[N][N];
			String[] tmp = new String[N];
			for(int i=0; i<N; i++){
				tmp[i]=sc.next();
			}
			for(int i=0; i<N; i++){
				farm[i] = tmp[i].split("");
			}
			for(int i=0; i<N; i++){
				for(int j=0; j<N ; j++){
					farm2[i][j]=Integer.parseInt(farm[i][j]);
				}
			}
			
			//풀이 시작
			for(int i=0; i<=N/2; i++){
				for(int j=0; j<N ; j++){
					if(Math.abs(j-N/2)<=i){
						ans += farm2[i][j];
					}
				}
			}
			for(int i=N/2+1; i<N; i++){
				for(int j=0; j<N; j++){
					if(Math.abs(j-N/2)<=N-1-i){
						ans += farm2[i][j];
					}
				}
			}
		
			
			
			
			System.out.println("#"+tc+" "+ans);
		}
		
		
		
	}
}
