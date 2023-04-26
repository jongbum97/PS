import java.util.*;

public class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			
			int N = sc.nextInt();
			String Ns = N+"";
			int n = Ns.length();
			
			int k = 2;
			boolean ans = false;

			while((int)Math.log10(N)==(int)Math.log10(N*k)){
				int[] word = new int[n];
				int M = N*k;
				String Ms = M+"";
				for(int i=0; i<Ms.length(); i++){
					for(int j=0; j<word.length; j++){
						if(Ms.charAt(i)==Ns.charAt(j) && word[j]==0){
							word[j]++;
							break;
						}
					}
				}
				
				ans = true;
				for (int e : word) {
					if(e==0){
						ans = false;
					}
				}	
				if(ans==true){
					break;
				}
				k++;
			}
			
			
			
			System.out.println("#"+tc+" "+((ans)? "possible":"impossible"));
			
		}

	}
}
