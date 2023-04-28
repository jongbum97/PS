import java.util.*;

public class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			
			int A = sc.nextInt();
			int B = sc.nextInt();
			
			System.out.println("#"+tc+" "+(A+B)%24);
		}
	}
}
