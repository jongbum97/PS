import java.util.*;

public class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {

			int N = sc.nextInt();
			int ans = 0;
			for(int i=1; i<=N; i++){
				if(i%2==0){
					ans -= i;
				}else {
					ans += i;
				}
			}
			
			
			

			System.out.println("#"+tc+" "+ans);

		}
	}
}
