import java.util.*;

public class Main {
	
	static int[] nums = new int[10001];
	
	public static void main(String[] args) {
		
		for(int i=1; i<10000; i++){
			d(i);
		}
		
		for(int i=1; i<10001; i++){
			if(nums[i]==0){
				System.out.println(i);
			}
		}
		
	}
	
	
	static void d(int N) {
		
		if(N>10000){
			return;
		}
		
		int ans = N;
		while(N>0){
			ans += N%10;
			N /= 10;
		}
		if(ans>10000){
			return;
		}
		nums[ans] = 1;
		
		d(ans);
	}
	
	
}