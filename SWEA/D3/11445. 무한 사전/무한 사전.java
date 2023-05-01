import java.util.*;

public class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {

			String a = sc.next();
			String b = sc.next();
			
			String ans = " Y";
			if((a+"a").equals(b) || (b+"b").equals(a)){
				ans = " N";
			}
		

			
			System.out.println("#"+tc+ans);
			
		}
	}
	

}
