import java.util.*;

public class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			
			int A = sc.nextInt();
			int B = sc.nextInt();
			int C = sc.nextInt();
			int D = sc.nextInt();
			
			int ans = -1;
			for(int i=A; i<=B; i++){
				if(i>=C && i<=D){
					ans++;
				}
			}
			
			
			
			System.out.println("#"+tc+" "+((ans==-1)? 0:ans));
		}
	}
}
