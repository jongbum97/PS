import java.util.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int tc = 0; tc < T; tc++) {
			int N = sc.nextInt();
			int[][] A = new int[N][2];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < 2; j++) {
					A[i][j] = sc.nextInt();
				}
			}
			int P = sc.nextInt();
			int[] stop = new int[P];
			for(int i=0; i<P; i++){
				stop[i] = sc.nextInt();
			}

			int[] ans = new int[5001];
			for (int i = 0; i < N; i++) {
				for (int j = A[i][0]; j <= A[i][1]; j++) {
					ans[j]++;
				}
			}
			System.out.print("#" + (tc + 1));
			for (int i = 1; i <= P; i++) {
				System.out.print(" " + ans[stop[i-1]]);
			}
			System.out.println();
		}
	}
}