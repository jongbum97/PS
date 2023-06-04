import java.util.*;

public class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int a = N;
			int[] nums = new int[10];
			int ans = 0;
			while(true){
				char[] ch = (N+"").toCharArray();
				for(int i=0; i<ch.length; i++){
					nums[ch[i]-'0']++;
				}
				
				
				
				int flag = 0;
				for(int i=0; i<10; i++){
					if(nums[i]==0){
						flag = 1;
						break;
					}
				}
				ans = N;
				if(flag==0){
					break;
				}else {
					N += a;
				}
			}
			
			
			System.out.println("#"+tc+" "+ans);

		}
	}
}
