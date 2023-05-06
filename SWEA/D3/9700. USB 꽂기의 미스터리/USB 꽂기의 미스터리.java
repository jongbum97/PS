import java.util.*;

public class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			Float p = sc.nextFloat();
			Float q = sc.nextFloat();
			
			Float s1 = (1-p)*q;
			Float s2 = p*(1-q)*q;
			
			String ans = "YES";
			if(s1>=s2){
				ans = "NO";
			}
			System.out.println("#"+tc+" "+ans);
			
		}
	}
	

}
