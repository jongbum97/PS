import java.util.*;

public class Solution {
	
	static int[] nums = new int[1000001];
	static int A, B, D, ans;
	static {
		nums[1] = -1;
	}
	
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {

			D = sc.nextInt();
			A = sc.nextInt();
			B = sc.nextInt();
			
			ans = 0;
			for(int i=A; i<=B; i++){
				judge2(judge(i));
			}
			
			System.out.println("#"+tc+" "+ans);
			
			
			
		}

	}
	
	
	public static int judge(int num) {
		if(nums[num]==1){
			return num;
		}else if(nums[num]==-1) {
			return -1;
		}else {
			int flag = 0;
			for(int i=2; i<=Math.sqrt(num); i++){
				if(num%i==0){
					flag = 1;
					break;
				}
			}
			if(flag==0){
				nums[num] = 1;
				return num;
			}else {
				nums[num] = -1;
				return -1;
			}
		}
	}
	
	public static void judge2(int num) {
		if(num==-1){
			return;
		}
		char[] arr = (num+"").toCharArray();
		int flag = 0;
		for(int i=0; i<arr.length; i++){
			if(arr[i]-'0'==D){
				flag = 1;
				break;
			}
		}
		if(flag==1){
			ans++;
		}
	}
	
}
