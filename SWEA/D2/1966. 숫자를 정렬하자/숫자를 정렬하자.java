import java.util.*;

public class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {

			int N = sc.nextInt();
			int[] n = new int[N];
			for(int i=0; i<N; i++){
				n[i] = sc.nextInt();
			}
			
			Arrays.sort(n);
			
			System.out.print("#"+tc);
			for (int e : n) {
				System.out.print(" "+e);
			}

			System.out.println();

		}
	}
}
