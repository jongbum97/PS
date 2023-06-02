import java.util.*;

public class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			
			int N = sc.nextInt();
			int[] nums = {2, 3, 5, 7, 11};
			int[] ans = new int[5];
			for(int i=0; i<5; i++){
				while(N%nums[i]==0){
					ans[i]++;
					N/=nums[i];
				}
			}
			
			
			
			
			System.out.print("#"+tc);
			for (int e : ans) {
				System.out.print(" "+e);
			}
			System.out.println();
		}
	}
}
