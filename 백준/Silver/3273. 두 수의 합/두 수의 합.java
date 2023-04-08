import java.util.*;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[] nums = new int[n];
		for(int i=0; i<n; i++){
			nums[i] = sc.nextInt();
		}
		int x = sc.nextInt();
		
		Arrays.sort(nums);
		
		
		int ans = 0;
		for(int i=0; i<n; i++){
			for(int j=i+1; j<n ; j++){
				if(nums[i]+nums[j]==x){
					ans++;
					break;
				}
			}
		}
		
		System.out.println(ans);
		
		
		
		
		
		
	}
	
}
