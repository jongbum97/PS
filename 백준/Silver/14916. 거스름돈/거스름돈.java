import java.util.*;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[] nums = new int[n/5+1];
		
		for(int i=0; i<=n/5; i++){
			if((n-5*i)%2==0){
				nums[i] = i + (n-5*i)/2;
			}else {
				nums[i] = -1;
			}
		}
		
		Arrays.sort(nums);
		
		int ans = -1;
		if(nums.length==1){
			if(nums[0]!=-1){
				ans = nums[0];
			}
		}
		for(int i=n/5; i>=1; i--) {
			if(nums[i]!=-1 && nums[i-1]==-1){
				ans = nums[i];
			}
		}
		
		System.out.println(ans);
	}
}