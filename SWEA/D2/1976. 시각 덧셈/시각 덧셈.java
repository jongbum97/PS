import java.util.*;

public class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			int d = sc.nextInt();
			
			int x = (a-1+c+(b+d)/60)%12+1;
			int y = (b+d)%60;
			
			

			System.out.println("#"+tc+" "+x+" "+y);

		}
	}
}
