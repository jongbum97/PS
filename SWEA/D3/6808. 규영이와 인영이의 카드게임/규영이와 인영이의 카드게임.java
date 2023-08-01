import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int win ;
	static int lose;
	static int[] A = new int[9];
	static int[] B = new int[9];
	static int Asum;
	static int Bsum;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder("");
		int TC = Integer.parseInt(br.readLine());
		for (int t = 1; t <= TC; t++) {
			win = 0 ;
			lose = 0;
			boolean[] card = new boolean[19];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 9; i++) {
				A[i] = Integer.parseInt(st.nextToken());
				card[A[i]] = true;
			}
			for (int i = 1, j = 0; i < 19; i++) {
				if (!card[i]) {
					B[j++] = i;
				}
			}
			permutation(A, 0, 9);
			sb.append("#").append(t).append(" ").append(win).append(" ").append(lose).append("\n");
		}
		System.out.print(sb);
	}

	static void permutation(int[] arr, int depth, int r) {
		if (depth == r) {
			Asum = 0;
			Bsum = 0;
			for (int i = 0; i < r; i++) {
				if (arr[i] > B[i]) {
					Asum += (arr[i] + B[i]);
				} else {
					Bsum += (arr[i] + B[i]);
				}
			}
			if (Asum > Bsum) {
				win++;
			} else {
				lose++;
			}
			return;
		}
		for (int i = depth; i < arr.length; i++) {
			int temp = arr[depth];
			arr[depth] = arr[i];
			arr[i] = temp;

			permutation(arr, depth + 1, r);

			arr[i] = arr[depth];
			arr[depth] = temp;
		}
	}

}