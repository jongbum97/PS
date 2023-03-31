
import java.util.Scanner;

class Solution
{
	public static void main(String args[]) throws Exception{

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int tc = 0; tc < T; tc++) {

			int N = sc.nextInt();
			int L = sc.nextInt();
			int[] taste = new int[N];
			int[] calorie = new int[N];
			int i = 0;
			while (i < N) {
				taste[i] = sc.nextInt();
				calorie[i++] = sc.nextInt();
			}

			// 풀이시작
			
			int ans = 0;
			for (int k = 0; k < (1 << N); k++) {
				int sum_cal = 0;
				int sum_taste = 0;
				
				for (int j = 0; j < N; j++) {
					
					if ((k & (1 << j)) > 0) {
						sum_cal += calorie[j];
						sum_taste += taste[j];
					}
				}
				if (sum_cal <= L) {
					ans = Math.max(ans, sum_taste);
				}
			}
			System.out.println("#"+(tc+1)+" "+ans);

		}
	}
	
}