import java.util.*;

public class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			
			int K = sc.nextInt();
			int N = (int)Math.pow(2,K);
			int[] nums = new int[N];
			for(int i=0; i<N; i++){
				nums[i] = sc.nextInt();
			}
			
			int ans = 0;
			outer : for(int i=0; i<N-1; ){
				int key = -1;
				int keyValue = -1;
				for(int j=0; j<N ; j++){
					if(nums[j] != 0 && key == -1){
						key = j;
						keyValue = nums[j];
					}else if (nums[j] != 0 && key != -1) {
						if(keyValue>=nums[j]){
							ans += keyValue-nums[j];
							nums[j] = 0;
						}else {
							ans += nums[j] - keyValue;
							nums[key] = 0;
						}
						key = -1;
						keyValue = -1;
						i++;
					}
				}
			}
			
			
			
			
			
			
			System.out.println("#"+tc+" "+ans);
			
		}
	}
	

}
