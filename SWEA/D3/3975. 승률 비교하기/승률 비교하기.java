import java.util.*;

public class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			
			double A = (double)sc.nextInt()/sc.nextInt();
			double B = (double)sc.nextInt()/sc.nextInt();
			
			String ans = "DRAW";
			if(A>B){
				ans = "ALICE";
			}else if (B>A) {
				ans = "BOB";
			}
			
			
	
			System.out.println("#"+tc+" "+ans);
			
			
		}
	}
}
