import java.util.*;

public class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {

			int ans = 0;
			for(int i=0; i<5; i++){
				int t = sc.nextInt();
				ans += (t<40)? 40:t;
			}
			
			
			

			System.out.println("#"+tc+" "+ans/5);

		}
	}
}
