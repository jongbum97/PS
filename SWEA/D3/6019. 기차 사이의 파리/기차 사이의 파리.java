import java.util.*;

public class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {

			double D = sc.nextInt();
			int A = sc.nextInt();
			int B = sc.nextInt();
			int S = sc.nextInt();
			
			double ans = (D/(A+B))*S;
			
	
			System.out.println("#"+tc+" "+ans);
			
			
			
			
		}
	}
	

}
