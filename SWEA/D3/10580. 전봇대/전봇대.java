import java.util.*;

public class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			
			int N = sc.nextInt();
			int[][] line = new int[N][2];
			for(int i=0; i<N; i++){
				line[i][0] = sc.nextInt();
				line[i][1] = sc.nextInt();
			}
			
			int ans = 0;
			for(int i=0; i<N; i++){
				for(int j=0; j<N ; j++){
					if((line[i][0]-line[j][0])*(line[i][1]-line[j][1])<0){
						ans++;
					}
				}
			}
			
			
			
			System.out.println("#"+tc+" "+ans/2);
			
		}
	}
	

}
