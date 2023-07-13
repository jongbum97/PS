import java.util.*;

public class Main {
	
	static boolean[] PN = new boolean[100001];
	static {
		PN[2] = true;
		PN[3] = true;
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] nums = new int[N];
		for (int i = 0; i < N; i++) {
			nums[i] = sc.nextInt();
		}
		
		primeNumber();
		for (int i = 0; i < N; i++) {
			int n = nums[i];
			int a = 0;
			int b = 0;
			for (int j = 0;	 j <= nums[i]; ) {
				a = j;
				if (PN[j]) {
					if (n%j!=0) {
						if (b != 0) {
							System.out.println(a+" "+b);
						}
						b = 0;
						j++;
					}else {
						n /= j;
						b++;
					}
				}else {
					j++;
				}
			}
		}
		
		
		
		
	}
	
	public static void primeNumber() {
		
		for (int i = 4; i <= 100000; i++) {
			PN[i] = true;
			for (int j = 2; j <= (int)Math.sqrt(i); j++) {
				if (i%j==0) {
					PN[i] = false;
					break;
				}
			}
		}
	}
	
	
}
