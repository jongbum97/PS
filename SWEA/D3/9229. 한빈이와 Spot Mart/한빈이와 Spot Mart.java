import java.util.*;

public class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			
			int N = sc.nextInt();
			int M = sc.nextInt();
			int[] bag = new int[N];
			for(int i=0; i<N; i++){
				bag[i] = sc.nextInt();
			}
			
			int ans = -1;
			for(int i=0; i<N; i++){
				for(int j=i+1; j<N ; j++){
					if((bag[i]+bag[j])<=M){
						ans = Math.max(ans, (bag[i]+bag[j]));
					}
				}
			}
			
			

			System.out.println("#" + tc + " "+ans);
			
		}

	}
}
