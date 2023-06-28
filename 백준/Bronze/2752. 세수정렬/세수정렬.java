import java.util.*;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[] nums = new int[3];
		for(int i=0; i<3; i++){
			nums[i] = sc.nextInt();
		}
		Arrays.sort(nums);
		for (int e : nums) {
			System.out.print(e+" ");
		}
	}
	
}