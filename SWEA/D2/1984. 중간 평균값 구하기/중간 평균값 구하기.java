import java.util.*;

public class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {

			int[] N = new int[10];
			for(int i=0; i<10; i++){
				N[i] =  sc.nextInt();
			}
			Arrays.sort(N);
			double ans = 0;
			for(int i=1; i<9; i++){
				ans += N[i];
			}
			
			ans = Math.round(ans/8);

			System.out.println("#"+tc+" "+(int)ans);

		}
	}
}
