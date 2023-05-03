import java.util.*;

public class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			
			int[] nums = {1, 4, 9, 121, 484};
			int A = sc.nextInt();
			int B = sc.nextInt();
			
			int ans = 0;
			for(int i=0; i<5; i++){
				if(nums[i]>=A && nums[i]<=B){
					ans++;
				}
			}
			System.out.println("#"+tc+" "+ans);
		}
	}
}