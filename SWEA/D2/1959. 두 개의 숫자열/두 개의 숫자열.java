
import java.util.Scanner;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 0; tc < T; tc++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			int[] A = new int[N];
			int[] B = new int[M];

			for (int i = 0; i < N; i++) {
				A[i] = sc.nextInt();
			}
			for (int i = 0; i < M; i++) {
				B[i] = sc.nextInt();
			}
			int answer = -99999999;
			if (N < M) {
				for (int i = 0; i < M - N+1; i++) {
					int ans = 0;
					for (int j = 0; j < N; j++) {
						ans += A[j] * B[j+i];
					}
					if(ans>answer) {
						answer = ans;
					}
				}
			} else {
				
				for (int i = 0; i < N - M+1; i++) {
					int ans = 0;
					for (int j = 0; j < M; j++) {
						ans += A[j+i] * B[j];
					}
					if(ans>answer) {
						answer = ans;
					}
				}
			}
			
			System.out.println("#"+(tc+1)+" "+answer);
		}

	}
}