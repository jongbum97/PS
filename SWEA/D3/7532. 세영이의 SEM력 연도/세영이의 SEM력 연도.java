import java.util.*;

public class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {

			int S = sc.nextInt();
			int E = sc.nextInt();
			int M = sc.nextInt();
			
			int ans = 0;
			for(int i=0; i<2000000000; i++){
				if(i%365==S-1 && i%24==E-1 && i%29==M-1){
					ans = i+1;
					break;
				}
			}
			
			System.out.println("#"+tc+" "+ans);
		}
	}
	

}
