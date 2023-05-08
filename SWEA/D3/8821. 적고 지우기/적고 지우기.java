import java.util.*;

public class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			
			char[] ch = sc.next().toCharArray();
			int[] nums = new int[10];
			
			for(int i=0; i<ch.length; i++){
				nums[ch[i]-'0']++;
			}
			
			int ans = 0;
			for(int i=0; i<10; i++){
				if(nums[i]%2==1){
					ans++;
				}
			}
			
			
			System.out.println("#"+tc+" "+ans);
			
		}
	}
	

}
