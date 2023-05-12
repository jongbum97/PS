import java.util.*;

public class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {

			int N = sc.nextInt();
			int ans = 0;
			
			for(int i=1; i<=N; i++){
				int tmp = 0;
				if(i>N){
					break;
				}
				for(int j=i; j<=N; j++){
					tmp += j;
					if(tmp<N){
						continue;
					}else if (tmp>N) {
						break;
					}else {
						ans++;
						break;
					}
				}
			}
			
			
			System.out.println("#"+tc+" "+ans);
		}
	}
	

}
