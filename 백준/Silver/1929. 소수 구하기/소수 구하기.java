import java.util.*;

public class Main {
	public static void main(String args[]) throws Exception {

		Scanner sc = new Scanner(System.in);
		
		int[] nums = new int[1000001];
		nums[1] = -1;
		int M = sc.nextInt();
		int N = sc.nextInt();
		
		for (int i = M; i <= N; i++) {
			if (nums[i]==1) {
				System.out.println(i);
			}else if(nums[i]==-1) {
				continue;
			}else {
				for (int j = 2; j <= Math.sqrt(i); j++) {
					if (i%j==0) {
						nums[i]=-1;
						break;
					}
				}
				if (nums[i]==0) {
					nums[i]=1;
					System.out.println(i);
				}
			}
				
		}
		
		

	}
}