import java.util.*;
import java.io.*;

public class Main {

	static char[] A, B;
	static int[][] dp;
	static int N, M;

	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		A = br.readLine().toCharArray();
		B = br.readLine().toCharArray();
		N = A.length;
		M = B.length;
		dp = new int[M+1][N+1];
		for (int j = 1; j <= N; j++) {
			for (int i = 1; i <= M; i++) {
				if (A[j-1]==B[i-1]) {
					dp[i][j] = dp[i-1][j-1]+1;
				}else {
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				}
			}
		}
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(dp[M][N]+"\n");
		bw.close();
		
	}
	

}