import java.util.*;

public class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			
			long L = sc.nextLong();
			long ans = (L/2)*(L/2);
			
			System.out.println("#"+tc+" "+ans);
			
		}
	}
	

}
