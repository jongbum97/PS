import java.util.*;

public class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			
			int N = sc.nextInt();
			int K = sc.nextInt();
			int[] nums = new int[K];
			
			for(int i=0; i<N*K; i++){
				if((i/K)%2==0){
					nums[i%K] += i+1;
				}else {
					nums[K-1-(i%K)] += i+1;
				}
			}
			
			
			
			
			System.out.print("#"+tc);
			for (int e : nums) {
				System.out.print(" "+e);
			}
			System.out.println();
		}
	}
	

}
