import java.util.*;

public class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {

			int[] moneys = {50000, 10000, 5000, 1000, 500, 100, 50, 10};
			int N = sc.nextInt();
			
			
			System.out.println("#"+tc);

			for(int i=0; i<8; i++){
				System.out.print(N/moneys[i]+" ");
				N %= moneys[i];
			}

			System.out.println();
		}
	}
}
