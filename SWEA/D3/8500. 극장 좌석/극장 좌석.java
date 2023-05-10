import java.util.*;

public class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {

			int N = sc.nextInt();
			int[] seat = new int[N];
			for(int i=0; i<N; i++){
				seat[i] = sc.nextInt();
			}
			
			Arrays.sort(seat);
			int ans = 0;
			for(int i=0; i<N; i++){
				ans += seat[i]+1;
			}
			ans += seat[N-1];
			
			System.out.println("#"+tc+" "+ans);
			
		}
	}
	

}
