import java.util.*;

public class Solution {
	
	static long[] a = new long[101];
	static {
		a[1] = 1; a[2] = 1; a[3] = 1;
	}
	
	
	
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			
			
			
			

			System.out.println("#"+tc+" "+an(N));

		}
	}
	
	static long an (int n) {
		
		if(n<4){
			return 1;
		}
		
		if(a[n]==0){
			a[n] = an(n-3)+an(n-2);
		}
		
		return a[n];
		
	}
	
	
}
