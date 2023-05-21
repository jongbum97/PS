import java.util.*;

public class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			
			int ans = sc.nextInt()*60*24 + sc.nextInt()*60 + sc.nextInt() - 16511;
			if(ans<0){
				ans = -1;
			}
			
			System.out.println("#"+tc+" "+ans);
			
			
			
		}
	}
}
