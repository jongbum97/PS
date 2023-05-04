import java.util.*;

public class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			
			char[] nums = sc.next().toCharArray();
			int front = Integer.parseInt((nums[0]+""+nums[1]));
			int behind = Integer.parseInt((nums[2]+""+nums[3]));
			
			String ans;
			if(front>12 || front==0){
				if(behind>12 || behind==0){
					ans = "NA";
				}else {
					ans = "YYMM";
				}
			}else {
				if(behind>12 || behind==0){
					ans = "MMYY";
				}else {
					ans = "AMBIGUOUS";
				}
			}
			
			
			System.out.println("#"+tc+" "+ans);
		}
	}
	

}
