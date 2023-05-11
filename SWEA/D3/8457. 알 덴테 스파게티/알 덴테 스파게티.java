import java.util.*;

public class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {

			int N = sc.nextInt();
			int B = sc.nextInt();
			int E = sc.nextInt();
			int[] hourglass = new int[N];
			for(int i=0; i<N; i++){
				hourglass[i] = sc.nextInt();
			}
			int ans = 0;
			for(int i=0; i<N; i++){
				for(int j=B-E; j<=B+E; j++){
					if(j%hourglass[i]==0){
						ans++;
						break;
					}
				}
			}
			
			
			
			System.out.println("#"+tc+" "+ans);
			
		}
	}
	

}
