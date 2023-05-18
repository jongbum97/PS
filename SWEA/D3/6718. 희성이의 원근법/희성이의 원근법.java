import java.util.*;

public class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {

			Double d = sc.nextDouble()/1000;
			
			int ans = 0;
			for(int i=0; i<6; i++){
				if(d>=Math.pow(10, i-2)){
					ans = i;
				}else {
					break;
				}
			}
			
			
			
			
			
			
			
			
			
			
			
			System.out.println("#"+tc+" "+ans);
			
			
			
		}

	}
}
