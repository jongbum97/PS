import java.util.*;

public class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {

			int N = sc.nextInt();
			int D = sc.nextInt();
			int[] city = new int[N+2];
			city[0] = 1; city[N+1] = 1;
			for(int i=1; i<=N; i++){
				city[i] = sc.nextInt();
			}
			
			int ans = 0;
			int count = 0;
			for(int i=0; i<N+2; i++){
				if(city[i]==1){
					count = D;
				}else {
					if(count == 0){
						ans++;
						count = D;
					}
				}
				count--;
			}
			
			
			
			
			System.out.println("#"+tc+" "+ans);
			
		}
	}
	

}
