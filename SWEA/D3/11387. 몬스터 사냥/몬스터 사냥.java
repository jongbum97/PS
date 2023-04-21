import java.util.*;

public class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			Double D = sc.nextDouble();
			Double L = sc.nextDouble();
			Double N = sc.nextDouble();
			
			Double ans = 0.0;
			for(int i=0; i<N; i++){
				ans += D*(1+i*L/100);
			}
			
			int k = (int) Math.round(ans);
			
			
			
			
			System.out.println("#" + tc + " " +k);
		}
		
		
		
		
		
	}
}
