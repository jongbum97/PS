import java.util.*;

public class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);

		for (int tc = 1; tc <= 10; tc++) {

			int N = sc.nextInt();
			String[][] board = new String[8][8];
			for (int i = 0; i < 8; i++) {
				board[i] = sc.next().split("");
			}
			
			// 시작
			int ans = 0;

			for (int i = 0; i < 8; i++) {
				for (int j = 0; j < 9 - N; j++) {
					for (int k = 0; k < N / 2; k++) {
						if (!board[i][j + k].equals(board[i][j + N - 1 - k]))
							break;
						if(k==N/2-1){
							ans++;
						}
					}
				}
			}

			for (int i = 0; i < 8; i++) {
				for (int j = 0; j < 9 - N; j++) {
					for (int k = 0; k < N / 2; k++) {
						if (!board[j + k][i].equals(board[j + N - 1 - k][i]))
							break;
						if (k == (N / 2 - 1)) {
							ans++;
						}
					}
				}
			}

			System.out.println("#" + tc + " " + ans);
		}

	}
}
