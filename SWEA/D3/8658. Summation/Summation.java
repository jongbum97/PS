import java.util.*;

public class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			
			int[] nums = new int[10];
			for(int i=0; i<10; i++){
				char[] num = sc.next().toCharArray();
				int k = 0;
				for(int j=0; j<num.length; j++){
					k += num[j]-'0';
				}
				nums[i] = k;
			}
			
			Arrays.sort(nums);
			String ans = nums[9]+" "+nums[0];
			
			System.out.println("#"+tc+" "+ans);
			
		}
	}
	

}
