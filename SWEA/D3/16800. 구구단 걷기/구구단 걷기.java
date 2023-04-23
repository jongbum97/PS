import java.util.*;

public class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			long N = sc.nextLong();
			long A = 0;
			for(int i=(int)Math.pow(N, 0.5); i>=1; i--){
				if(N%i==0){
					A=i;
					break;
				}
			}
			
			System.out.println("#" + tc + " "+((A-1)+(N/A-1)));
			
			
			
			
			
			
			
			
			
			
		}

	}
}
