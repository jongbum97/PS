import java.util.*;

public class Main {
	
	static int[] nums = new int[1000001];
	static {
		nums[1] = 1;
		nums[2] = 2;
		nums[3] = 3;
	}
	
	
	
	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		System.out.println(tile(N));
		
	}
	
	
	public static int tile(int n) {
		if (nums[n] != 0) {
			return nums[n];
		}else {
			nums[n] = (tile(n-2) + tile(n-1))%15746;
			return nums[n];
		}
	}
	
}
