import java.util.*;

public class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			
			int ans = 0;
			int N = sc.nextInt();
			for(int i=0; i<N; i++){
				int k = sc.nextInt();
				ans = Math.max(ans+k, ans*k);
			}
		
			System.out.println("#"+tc+" "+ans);
			
		}
	}
	

}
