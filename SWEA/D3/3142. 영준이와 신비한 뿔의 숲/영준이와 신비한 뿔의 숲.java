import java.util.*;

public class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			
			int u = 0;
			int t = m;
			for(u=0; m>=0; u++,t--){
				if((u+t*2)==n){
					break;
				}
			}
			
			
			System.out.println("#"+tc+" "+u+" "+t);

		}
	}
}
