import java.util.*;

public class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			
			int N = sc.nextInt();
			int ans = 0;
			int v = 0;
			for(int i=0; i<N; i++){
				int c = sc.nextInt();
				if(c==0){
					ans += v;
				}else {
					int dv = sc.nextInt();
					if(c==1){
						v += dv;
						ans += v;
					}else {
						v -= dv;
						if(v<0){
							v = 0;
						}
						ans += v;
					}
				}
				
			}
			
			
			
			System.out.println("#"+tc+" "+ans);

		}
	}
}
