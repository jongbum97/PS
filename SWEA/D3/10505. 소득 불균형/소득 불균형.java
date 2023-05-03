import java.util.*;

public class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			
			int N = sc.nextInt();
			int[] money = new int[N];
			int avg = 0;
			for(int i=0; i<N; i++){
				int k = sc.nextInt();
				money[i] = k;
				avg += k;
			}
			avg /= N;
			int ans = 0;
			for(int i=0; i<N; i++){
				if(money[i]<=avg){
					ans++;
				}
			}
			
			
			
			System.out.println("#"+tc+" "+ans);
			
		}
	}
	

}
