import java.util.*;

public class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			
			int N = sc.nextInt();
			int K = sc.nextInt();
			
			int ans = 1;
			if(N%K==0){
				ans = 0;
			}
			
			
			System.out.println("#"+tc+" "+ans);
		}
	}
	

}
