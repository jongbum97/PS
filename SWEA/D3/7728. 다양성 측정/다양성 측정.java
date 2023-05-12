import java.util.*;

public class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {

			char[] nums = sc.next().toCharArray();
			int[] nine = new int[10];
			for(int i=0; i<nums.length; i++){
				nine[nums[i]-'0']++;
			}
			
			int ans = 0;
			for(int i=0; i<10; i++){
				if(nine[i] != 0){
					ans++;
				}
			}
			
			
			
			System.out.println("#"+tc+" "+ans);
			
		}
	}
	

}
